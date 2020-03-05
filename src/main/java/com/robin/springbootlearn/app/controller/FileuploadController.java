package com.robin.springbootlearn.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author silkNets
 * @program springboot-learn
 * @description 文件上传下载控制器
 * @createDate 2020-02-27 15:27
 */
@Slf4j
@Controller
public class FileuploadController {


    // 上传文件会自动绑定到 MultipartFile 中
    @PostMapping(value = "/fileUpload")
    public String fileupload(HttpServletRequest request,
                             @RequestParam("description") String description,
                             @RequestParam("file") MultipartFile file) throws IOException {

        boolean isNotEmpty = !file.isEmpty();
        log.info("description: {}, 文件{}为空", description, isNotEmpty ? "不" : "");
        if (isNotEmpty) {
            // 上传文件路径
            String path = request.getServletContext().getRealPath("/upload/");
            log.info("上传文件，原文件路径:{}", path);

            // 上传文件名
            String fileName = file.getOriginalFilename();
            if (StringUtils.isNotBlank(fileName)) {
                File newFile = new File(path, fileName);

                // 判断路径是否存在，如果不存在就创建一个
                File parentFile = newFile.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }

                // 将上传的文件保存到一个目标文件当中
                String newFilePath = "D:\\upload" + File.pathSeparator + fileName;
                log.info("上传文件，新文件路径:{}", newFilePath);

                file.transferTo(new File(newFilePath));
                return "success";
            }
        }
        return "error";
    }

    @PostMapping(value = "/fileDownload")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, Model model,
                                               @RequestParam("filename") String fileName,
                                               @RequestHeader("User-Agent") String userAgent) throws IOException {

        // 下载文件路径
        String filePath = request.getServletContext().getRealPath("/upload");

        // 构建 File
        String newFilePath = filePath + File.pathSeparator + fileName;
        File file = new File(newFilePath);

        // ok 表示 HTTP 中的状态为 200
        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.ok();

        // 内容长度
        bodyBuilder.contentLength(file.length());

        // application/octet-stream 二进制流数据（最常见的文件下载）
        bodyBuilder.contentType(MediaType.APPLICATION_OCTET_STREAM);

        // 使用 URLEncoder.encode 对文件进行解码
        fileName = URLEncoder.encode(fileName, "UTF-8");

        // 设置实际的响应文件名，告诉浏览器文件要用于 下载 和 保存；不同浏览器，处理方式不同，要区别对待
        if (userAgent.indexOf("MSIE") > 0) {
            // 如果是 IE, 只需要用 UTF-8 字符集对 URL 编码即可
            bodyBuilder.header("Content-Disposition", "attachement; filename =" + fileName);
        } else {
            // Chrome\FireFox 等，需要说明编码的字符集
            bodyBuilder.header("Content-Disposition", "attachement; filename*=UTF-8''" + fileName);
        }

        return bodyBuilder.body(FileUtils.readFileToByteArray(file));
    }

    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "haha.jpg";
        String filePath = "D:\\develop_space\\0IDEA_DEV\\springboot-learn\\src\\main\\resources\\statics\\img\\";
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            String realPath = request.getServletContext().getRealPath("//statics//");
            File file = new File(filePath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}