package pub.liyf.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pub.liyf.bean.Employee;
import pub.liyf.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee/list")
    public String getAll(Model model){
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employee";
    }

    @RequestMapping("/employee/getById/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable("id") String id){
        return employeeService.getEmployeeById(id);
    }


    @RequestMapping("/employee/getByLike/{partOfName}")
    @ResponseBody
    public List<Employee> getEmployeeByLike(@PathVariable("partOfName") String partOfName){
        return employeeService.getEmployeeByLike(partOfName);
    }

    @RequestMapping("/employee/insert")
    @ResponseBody
    public int insert(Employee employee){
        return employeeService.insert(employee);
    }


    @RequestMapping("/employee/delete")
    public String deleteById(@RequestParam("id") String id,Model model){
        employeeService.deleteById(id);
        List<Employee> list = employeeService.getAll();
        model.addAttribute("employees", list);
        return "employee";
    }

    @RequestMapping("/employee/update")
    @ResponseBody
    public int update(Employee employee){
        return employeeService.update(employee);
    }
}
