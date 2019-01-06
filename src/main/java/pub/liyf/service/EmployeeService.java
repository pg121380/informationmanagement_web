package pub.liyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.liyf.bean.Employee;
import pub.liyf.mapper.EmployeeMapper;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Transactional
    public List<Employee> getAll(){
        return mapper.getAll();
    }

    @Transactional
    public Employee getEmployeeById(String id){
        return mapper.getEmployeeById(id);
    }

    @Transactional
    public List<Employee> getEmployeeByLike(String partOfName){
        return mapper.getEmployeeByLike(partOfName);
    }

    @Transactional
    public int insert(Employee employee){
        return mapper.insert(employee);
    }

    @Transactional
    public int deleteById(String id){
        return mapper.deleteById(id);
    }

    @Transactional
    public int update(Employee employee){
        return mapper.update(employee);
    }
}
