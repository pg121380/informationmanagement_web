package pub.liyf.mapper;


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

    @Select("select * from student where name like %#{partOfName}%")
    Student getByLike(String partOfName);
}
