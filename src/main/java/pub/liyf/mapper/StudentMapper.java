package pub.liyf.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    @Insert("insert into student(id,name,age,score) values(id,name,age,score)")
    int insert(Student student);

}
