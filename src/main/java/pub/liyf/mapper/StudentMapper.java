package pub.liyf.mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import pub.liyf.bean.Student;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    @Select("select * from student")
    List<Student> getAll();

    @Select("select * from student where id=#{id}")
    Student getById(String id);

    @Select("select * from student where name like CONCAT('%',#{partOfName},'%')")
    List<Student> getByLike(String partOfName);

    @Insert("insert into student(id,name,age,score) values(#{id},#{name},#{age},#{score})")
    int insert(Student student);

    @Delete("delete from student where id=#{id}")
    int deleteById(String id);

    @Update("update student set name=#{name},age=#{age},score=#{score} where id=#{id}")
    int update(Student student);

}
