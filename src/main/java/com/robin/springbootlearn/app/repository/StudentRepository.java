package com.robin.springbootlearn.app.repository;

import com.robin.springbootlearn.app.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Student 访问仓库接口
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 09:25
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}