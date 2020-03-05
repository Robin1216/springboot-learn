package com.robin.springbootlearn.app.repository;

import com.robin.springbootlearn.app.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Spring Boot 整合 MyBatis
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 23:27
 */
public interface StudentMyBatisRepository {

    /**
     * 插入数据
     *
     * @param student 待插入数据
     * @return
     */
    @Insert("INSERT INTO `t_student`(`name`, `sex`, `age`, `address`, `class_code`) " +
            "VALUES ( #{name},#{address},#{sex},#{address},#{classCode})")
    int insertStudent(Student student);


    /**
     * 插入数据获取主键
     *
     * @param student 待插入数据
     */
    @Insert("INSERT INTO `t_student`(`name`, `sex`, `age`, `address`, `class_code`) " +
            "VALUES ( #{name},#{address},#{sex},#{address},#{classCode})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertAndGetKey(Student student);


    @Select("select * from `t_student` where `name` = #{name}")
    @ResultMap("studentResult")
    List<Student> selectByStudentName(@Param("name") String name);


    @Select("select * from `t_student`")
    @Results(id = "studentResult", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "address", property = "address"),
            @Result(column = "class_code", property = "classCode")
    })
    List<Student> findAll();


    @Select("select * from `t_student` where `id` = #{id}")
    @ResultMap("studentResult")
    Student findByStudentId(long id);


    @Update("UPDATE `t_student` SET `name` = #{name}, `sex` = #{sex}, `sex` = #{sex}, " +
            "`address` = #{address}, `class_code` = #{classCode} WHERE `id` = #{id}")
    void update(Student student);
}