package pub.liyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pub.liyf.bean.Employee;
import pub.liyf.bean.Student;
import pub.liyf.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/list")
    public String getAllStudent(Model model){
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "student";
    }

    @RequestMapping("/student/getById")
    public String getById(@RequestParam("id") String id, Model model){
        Student student = studentService.getById(id);
        model.addAttribute("students", student);
        return "student";
    }

    @RequestMapping("/student/getByLike")
    public String getByLike(@RequestParam("partOfName") String partOfName, Model model){
        System.out.println("hello");
        List<Student> students = studentService.getByLike(partOfName);
        model.addAttribute("students", students);
        return "student";
    }


    @RequestMapping("/student/insert")
    public String insert(Student student, Model model){
        studentService.insert(student);
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "student";
    }

    @RequestMapping("/student/delete")
    public String deleteById(@RequestParam("id") String id, Model model){
        studentService.deleteById(id);
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "student";
    }

    @RequestMapping("/student/update")
    public String update(Student student, Model model){
        studentService.update(student);
        model.addAttribute("students", studentService.getAll());
        return "student";
    }
}
