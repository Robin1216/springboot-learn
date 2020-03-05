package com.robin.springbootlearn.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 学生实体类
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 09:19
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "class_code")
    private Long classCode;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Class.class)
    @JoinColumn(name = "class_code", referencedColumnName = "code")
    private Class clazz;

    public Student(String name, String address, String sex, Integer age, Class clazz) {
        super();
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.age = age;
        this.clazz = clazz;
    }
}