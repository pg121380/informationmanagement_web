package pub.liyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pub.liyf.bean.Employee;
import pub.liyf.bean.JSONCheck;
import pub.liyf.bean.Msg;
import pub.liyf.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {
    //TODO:添加健壮性
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee/list")
    public String getAll(Model model){
        List<Employee> employees = employeeService.getAll();
        if(employees.isEmpty()){
            model.addAttribute("msg", new Msg("数据库中还没有职工数据，请先进行增加操作！"));
        } else {
            model.addAttribute("employees", employees);
        }
        return "employee";
    }

    @RequestMapping("/employee/getById")
    public String getEmployeeById(@RequestParam("id") String id, Model model){
        if(id.trim().equals("")){
            model.addAttribute("msg", new Msg("id不能为空！"));
            return "employee";
        }
        Employee employees = employeeService.getEmployeeById(id);
        if(employees == null){
            model.addAttribute("msg", new Msg("没有找到id为" + id + "的职工"));
        }
        model.addAttribute("employees", employees);
        return "employee";
    }


    @RequestMapping("/employee/getByLike")
    public String getEmployeeByLike(@RequestParam("partOfName") String partOfName, Model model){
        if(partOfName.trim().equals("")){
            model.addAttribute("msg", new Msg("名字不能为空！"));
            return "employee";
        }
        List<Employee> employees = employeeService.getEmployeeByLike(partOfName);
        if(employees.isEmpty()){
            model.addAttribute("msg", new Msg("没有找到名字中带有" + partOfName + "的职工！"));
        }
        model.addAttribute("employees", employees);
        return "employee";
    }

    @RequestMapping("/employee/insert")
    public String insert(Employee employee, Model model){
        if(employee.getId().trim().equals("")){
            model.addAttribute("msg", new Msg("id不能为空！"));
            return "employee";
        }
        if(employeeService.getEmployeeById(employee.getId()) != null){
            model.addAttribute("msg", new Msg("输入的id已重复！"));
            return "employee";
        }
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
        int reflect = employeeService.update(employee);
        if(reflect == 0){
            model.addAttribute("msg", new Msg("修改失败！没有找到id为" + employee.getId() + "的职工！"));
        } else {
            model.addAttribute("msg", new Msg("修改成功!"));
        }
        model.addAttribute("employees", employeeService.getAll());
        return "employee";
    }

    @RequestMapping("/employee/checkDuplicated")
    @ResponseBody
    public JSONCheck checkDuplicated(@RequestParam("id") String id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            return new JSONCheck(id + "1", id);
        } else {
            return new JSONCheck(employee.getId(), id);
        }
    }

    @RequestMapping("/employee/showBack")
    @ResponseBody
    public Employee AjaxShowBack(@RequestParam("id") String id){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null){
            return new Employee(id, "此姓名不存在！！！！！！！", 0, 0.0,"");
        } else {
            return employee;
        }
    }
}
