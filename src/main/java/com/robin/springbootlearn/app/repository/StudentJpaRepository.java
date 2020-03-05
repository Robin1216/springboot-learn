package com.robin.springbootlearn.app.repository;

import com.robin.springbootlearn.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author robin
 * @version v0.0.1
 * @create 2020-03-04 10:53
 */
public interface StudentJpaRepository extends JpaRepository<Student, Long> {

    /*
  JpaRepository 是继承于 PagingAndSortingRepository  和 QueryByExampleExecutor，是对 PagingAndSortingRepository 功能的进一步拓展.

  按照 Spring Data 的规则，其支持将条件属性定义在数据访问层接口 Repository 下的方法名中，条件属性通过条件关键字连接，需要注意的是：
  条件属性的首字母必须大写，查询的方法名称必须以 find、get、read 开头。
     */

    /**
     * 通过学生姓名来查询学生信息<br/>
     * 相当于 JPQL 语句代码：select s from t_student s where s.name = ?1
     *
     * @param name 姓名
     * @return
     */
    List<Student> findByName(String name);

    /**
     * 通过学生姓名来模糊查询学生信息<br/>
     * 相当于 JPQL 语句代码：select s from t_student s where s.name like ?1
     *
     * @param name 姓名
     * @return 包含 Student 对象的 list 对象
     */
    List<Student> findByNameLike(String name);

    /**
     * 通过名字和地址查询学生信息<br/>
     * 相当于 JPQL 语句代码：select s from t_student s where s.name = ?1 and s.address = ?2
     *
     * @param name    姓名
     * @param address 地址
     * @return
     */
    List<Student> findByNameAndAddress(String name, String address);

    /* ********** 多对一双向级联操作 ********** */

    /**
     * 根据班级名称查询这个班级的所有学生信息<br/>
     * 相当于 JPQL 语句代码：select s from t_student s where s.aClass.name = ?1
     *
     * @param className 班级名称
     * @return
     */
    List<Student> findByClazz_Name(String className);

    /**
     * 根据班级名称查询这个班级的所有学生信息. @Query 写法，与 findByAClass_Name效果等同 <br/>
     *
     * @param className 班级名称
     * @return
     */
    @Query("select s from Student s where s.clazz.name = ?1")
    List<Student> findByClassName(String className);

    /**
     * 查询某个班级下素有学生名称及性别
     *
     * @param className 班级名称
     * @return
     */
    @Query("select s.name as name, s.sex as sex from Student s where s.clazz.name = ?1")
    List<Map<String, Object>> findNameAndSexByClassName(String className);

    /**
     * 查询某个班级下某种性别所欲学生的名称。使用名臣过来匹配查询，使用格式“:参数名称” 引用
     *
     * @param className 类名称
     * @param sex       性别
     * @return
     */
    @Query("select s.name from Student s where s.clazz.name = :className and s.sex = :sex")
    List<String> findNameByClassNameAndSex(@Param("className") String className, @Param("sex") String sex);

    /**
     * 查询某个学生属于哪个班级
     *
     * @param studentName 学生姓名
     * @return
     */
    @Query("select c from Class c inner join c.students s where  s.name = ?1")
    String findClassNameByStudentName(String studentName);


    /**
     * 执行更新查询，使用 @Query 和 @Modifying 可以执行更新操作，如删除学生信息
     *
     * @param stuName 学生名称
     * @return 更新个数
     */
    @Modifying
    @Query("delete from Student s where s.name = ?1")
    int deleteStudentByStuName(String stuName);
}