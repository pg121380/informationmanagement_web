package pub.liyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pub.liyf.bean.Employee;
import pub.liyf.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/list")
    @ResponseBody
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/employee/getById/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable("id") String id){
        return employeeService.getEmployeeById(id);
    }


    @GetMapping("/employee/getByLike/{partOfName}")
    @ResponseBody
    public List<Employee> getEmployeeByLike(@PathVariable("partOfName") String partOfName){
        return employeeService.getEmployeeByLike(partOfName);
    }

    @PostMapping("/employee/insert")
    @ResponseBody
    public int insert(Employee employee){
        return employeeService.insert(employee);
    }


    @ResponseBody
    @GetMapping("/employee/delete/{id}")
    public int deleteById(@PathVariable("id") String id){
        return employeeService.deleteById(id);
    }

    @PostMapping("/employee/update")
    @ResponseBody
    public int update(Employee employee){
        return employeeService.update(employee);
    }
}
