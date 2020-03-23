package com.robin.springbootlearn.app.repository;

import com.robin.springbootlearn.app.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * JdbcTemplate连接数据库
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 14:11
 */
@Repository  // @Repository  表明这是一个持久化操作对象
public class StudentJdbcRepository {

    /*
    JdbcTemplate(JDBC 模版) 设计的目的是为不同雷属性的 JDBC 操作提供模版方法，每个模版方法都能控制整个数据
    访问的过程，通过这种方式，可以再尽可能保持灵活性的情况下，将数据库存取的工作量降低到最低，通过 Spring boot
    自动装配功能，在maven 配置温江中需要增加 spring-boot-starter-jdbc 模块
     */


    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 插入数据
     *
     * @param name      姓名
     * @param sex       性别
     * @param age       年龄
     * @param address   地址
     * @param classCode 班级编号
     * @return
     */
    public int insertStudent(String name, String sex, int age, String address, long classCode) {
        String sql = "INSERT INTO `t_student`(`name`, `sex`, `age`, `address`, `class_code`) VALUES ( ?, ?, ?, ?, ?);";
        Object[] args = new Object[]{name, sex, age, address, classCode};
        return jdbcTemplate.update(sql, args);
    }

    /**
     * 插入数据，获取被插入数据的主键
     *
     * @param student 待插入的数据
     * @return
     */
    public Student insertAndGetKey(Student student) {
        String sql = "INSERT INTO `t_student`(`name`, `sex`, `age`, `address`, `class_code`) VALUES ( ?, ?, ?, ?, ?);";

        // 插入数据后获取主键的对象
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                // 插入数据后，将被插入数据的主键返回
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSex());
                ps.setInt(3, student.getAge());
                ps.setString(4, student.getAddress());

                return ps;
            }
        }, holder);

        // 获取被插入数据库的主键，注入到 student 对象中
        long newStudentId = holder.getKey().longValue();
        student.setId(newStudentId);

        return student;
    }

    /**
     * 根据学生姓名查询数据
     *
     * @param name 学生姓名
     * @return
     */
    public Student selectByStudentName(String name) {
        String sql = "select * from `t_student` where `name` = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, rowMapper);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<Student> findAll() {
        String sql = "select * from  `t_student`";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        return jdbcTemplate.query(sql, rowMapper);
    }


    /**
     * 修改数据
     *
     * @param id        学生id
     * @param name      姓名
     * @param sex       性别
     * @param age       年龄
     * @param address   地址
     * @param classCode 班级编号
     */
    public void update(long id, String name, String sex, int age, String address, long classCode) {
        String sql = "UPDATE `t_student` SET `name` = ?, `sex` = ?, `age` = ?, `address` = ?, `class_code` = ? WHERE `id` = ?;";
        Object[] args = new Object[]{name, sex, age, address, classCode, id};
        jdbcTemplate.update(sql, args);
    }

    /**
     * 根据 id 删除数据
     */
    public void deleteById(long id) {
        String sql = "delete from `t_student` where id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }


}