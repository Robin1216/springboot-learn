package com.robin.springbootlearn.app.repository;

import com.robin.springbootlearn.app.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Student 访问仓库接口
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 09:25
 */
public interface StudentPageAndSortRepository extends PagingAndSortingRepository<Student, Long> {

    /*
    PagingAndSortingRepository 继承于 CrudRepository ，在其基础上增加了排序和分页功能
     */
}