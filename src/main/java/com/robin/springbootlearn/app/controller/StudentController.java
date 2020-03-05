package com.robin.springbootlearn.app.controller;

import com.robin.springbootlearn.app.entity.Student;
import com.robin.springbootlearn.app.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 学生请求控制器
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 10:24
 */
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/save")
    public String save() {
        Student student = new Student();
        student.setAge(22);
        student.setName("robin");
        student.setSex("男");

        studentService.save(student);

        return "成功";
    }

    @RequestMapping("/query/sort")
    public Iterable<Student> querySort() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Iterable<Student> students = studentService.getAllSort(sort);

        return students;
    }


    @RequestMapping("/query/page")
    public Iterable<Student> queryPageAndSort() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Pageable page = PageRequest.of(0, 10, sort);

        Page<Student> students = studentService.getAllPage(page);
        students.getTotalElements();
        students.getTotalPages();

        return students;
    }


    @RequestMapping("/query/like")
    public List<Student> queryNameLike() {
        return studentService.getStudentsByNameLike("robin");
    }

    @RequestMapping("/query/nameAndSex")
    public List<Map<String, Object>> getNameAndSexByClassName() {
        return studentService.getNameAndSexByClassName("t1");
    }
}