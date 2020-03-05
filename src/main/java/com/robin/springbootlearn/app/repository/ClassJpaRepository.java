package com.robin.springbootlearn.app.repository;

import com.robin.springbootlearn.app.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 10:53
 */
public interface ClassJpaRepository extends JpaRepository<Class, Long> {


}