package pub.liyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.liyf.bean.Employee;
import pub.liyf.mapper.EmployeeMapper;

import java.util.List;

@Service
public class EmployeeService {
    //TODO:修改EmployeeService

    @Autowired
    private EmployeeMapper mapper;

    public List<Employee> getAll(){
        return mapper.getAll();
    }

    public Employee getEmployeeById(String id){
        return mapper.getEmployeeById(id);
    }

    public List<Employee> getEmployeeByLike(String partOfName){
        return mapper.getEmployeeByLike(partOfName);
    }

    public int insert(Employee employee){
        return mapper.insert(employee);
    }

    public int deleteById(String id){
        return mapper.deleteById(id);
    }

    public int update(Employee employee){
        return mapper.update(employee);
    }
}
