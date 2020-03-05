package com.robin.springbootlearn.app.service;

import com.robin.springbootlearn.app.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * student 服务接口
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 09:27
 */
public interface StudentService {

    /* ********** 使用 CrudRepository 接口访问 ********** */
    Student save(Student student);

    void delete(Long id);

    Iterable<Student> getAll();

    Student getById(Long id);

    void update(Student student);

    /* ********** 使用 PagingAndSortingRepository 接口访问 ********** */
    Iterable<Student> getAllSort(Sort sort);

    Page<Student> getAllPage(Pageable page);

    /* ********** 使用 StudentJpaRepository 接口访问 ********** */
    List<Student> getStudentsByNameLike(String name);

    List<Map<String, Object>> getNameAndSexByClassName(String className);
}