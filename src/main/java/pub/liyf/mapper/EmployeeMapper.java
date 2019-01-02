package pub.liyf.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import pub.liyf.bean.Employee;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    @Select("select * from employee")
    List<Employee> getAll();

    @Select("select * from employee where id=#{id}")
    Employee getEmployeeById(String id);

    @Select("select * from employee where name like CONCAT('%',#{partOfName},'%')")
    List<Employee> getEmployeeByLike(String partOfName);

    @Insert("insert into employee(id,name,age,salary,job) values(#{id},#{name},#{age},#{salary},#{job})")
    int insert(Employee employee);

    @Delete("delete from employee where id=#{id}")
    int deleteById(String id);

    @Update("update employee set name=#{name},age=#{age},salary=#{salary},job=#{job} where id=#{id}")
    int update(Employee employee);
}
