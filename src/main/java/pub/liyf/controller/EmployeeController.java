package pub.liyf.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pub.liyf.bean.Employee;
import pub.liyf.service.EmployeeService;

import java.util.ArrayList;
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

    @RequestMapping("/employee/getById")
    public String getEmployeeById(@RequestParam("id") String id, Model model){
        List<Employee> employees = new ArrayList<>();
        Employee employee = employeeService.getEmployeeById(id);
        employees.add(employee);
        model.addAttribute("employees", employees);
        return "employee";
    }


    @RequestMapping("/employee/getByLike")
    public String getEmployeeByLike(@RequestParam("partOfName") String partOfName, Model model){
        List<Employee> employees = employeeService.getEmployeeByLike(partOfName);
        model.addAttribute("employees", employees);
        return "employee";
    }

    @RequestMapping("/employee/insert")
    public String insert(Employee employee, Model model){
        employeeService.insert(employee);
        List<Employee> list = employeeService.getAll();
        model.addAttribute("employees", list);
        return "employee";
    }


    @RequestMapping("/employee/delete")
    public String deleteById(@RequestParam("id") String id,Model model){
        employeeService.deleteById(id);
        List<Employee> list = employeeService.getAll();
        model.addAttribute("employees", list);
        return "employee";
    }

    @RequestMapping("/employee/update")
    public String update(Employee employee, Model model){
        employeeService.update(employee);
        model.addAttribute("employees", employeeService.getAll());
        return "employee";
    }
}
