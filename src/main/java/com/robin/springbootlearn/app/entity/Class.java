package com.robin.springbootlearn.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 班级信息
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 11:21
 */
@Data
@Entity
@Table(name = "t_class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(name = "name")
    private String name;


    @OneToMany(fetch = FetchType.LAZY, targetEntity = Student.class, mappedBy = "clazz")
    private Set<Student> students = new HashSet<>();
}