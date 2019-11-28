package com.robin.springbootlearn.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author robin
 * @version v0.0.1
 * @depiction IP 工具类
 * @create 2019-11-28 21:48
 **/
public class IPUtil {

    /**
     * 从 HttpServletRequest 中获取用户IP
     * <p>
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,;
     * 如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，取X-Forwarded-For中第一个非unknown的有效IP字符串。
     * </p>
     *
     * @param request HttpServletRequest 请求
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            // X-Real-IP 记录请求的客户端真实IP
            ip = request.getHeader("X-Real-IP");
        }

        if (StringUtils.isNotEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            // Proxy-Client-IP 代理客户端的IP，如果客户端真实IP获取不到的时候，就只能获取代理客户端的IP了
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isNotEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            // WL-Proxy-Client-IP 是在 Weblogic 下获取真实IP所用的的参数
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isNotEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            // HTTP_CLIENT_IP 可以理解为X-Forwarded-For， 因为其是PHP中的用法
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isNotEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            // HTTP_X_FORWARDED_FOR 可以理解为 X-Forwarded-For， 因为其是PHP中的用法
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isNotEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 根据网卡取本机配置的IP
        if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                if (inetAddress != null) {
                    ip = inetAddress.getHostAddress();
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        return ip;
    }

    public static String getIpAddress() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) (RequestContextHolder.getRequestAttributes());
        if (servletRequestAttributes != null) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            return getIpAddress(request);
        }
        return null;
    }

}
