package com.robin.springbootlearn.app.service.impl;

import com.robin.springbootlearn.app.entity.Student;
import com.robin.springbootlearn.app.repository.StudentJpaRepository;
import com.robin.springbootlearn.app.repository.StudentPageAndSortRepository;
import com.robin.springbootlearn.app.repository.StudentRepository;
import com.robin.springbootlearn.app.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * student 服务接口实现
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 09:29
 */
@Slf4j
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private StudentPageAndSortRepository studentPageAndSortRepository;

    @Resource
    private StudentJpaRepository studentJpaRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        Optional<Student> op = studentRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Iterable<Student> getAllSort(Sort sort) {
        return studentPageAndSortRepository.findAll(sort);
    }

    @Override
    public Page<Student> getAllPage(Pageable page) {
        return studentPageAndSortRepository.findAll(page);
    }

    @Override
    public List<Student> getStudentsByNameLike(String name) {
        return studentJpaRepository.findByNameLike(name);
    }

    @Override
    public List<Map<String, Object>> getNameAndSexByClassName(String className) {
        return studentJpaRepository.findNameAndSexByClassName(className);
    }
}