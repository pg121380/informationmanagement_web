package pub.liyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pub.liyf.bean.Employee;
import pub.liyf.bean.JSONCheck;
import pub.liyf.bean.Msg;
import pub.liyf.bean.Student;
import pub.liyf.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    //TODO:添加健壮性
    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/list")
    public String getAllStudent(Model model){
        List<Student> students = studentService.getAll();
        if(students.isEmpty()){
            model.addAttribute("msg", new Msg("数据库中还没有学生数据，请先进行增加操作！"));
        } else {
            model.addAttribute("students", students);
        }
        return "student";
    }

    @RequestMapping("/student/getById")
    public String getById(@RequestParam("id") String id, Model model){
        if(id.trim().equals("")){
            model.addAttribute("msg", new Msg("id不能为空！"));
            return "student";
        }
        Student student = studentService.getById(id);
        if(student == null){
            model.addAttribute("msg", new Msg("没有找到学号为" + id + "的学生"));
        }
        model.addAttribute("students", student);
        return "student";
    }

    @RequestMapping("/student/getByLike")
    public String getByLike(@RequestParam("partOfName") String partOfName, Model model){
        if(partOfName.trim().equals("")){
            model.addAttribute("msg", new Msg("名字不能为空！"));
            return "student";
        }
        List<Student> students = studentService.getByLike(partOfName);
        if(students.isEmpty()){
            model.addAttribute("msg", new Msg("没有找到名字中带有" + partOfName + "的学生"));
        }
        model.addAttribute("students", students);
        return "student";
    }


    @RequestMapping("/student/insert")
    public String insert(Student student, Model model){
        if(student.getId().trim().equals("")){
            model.addAttribute("msg", new Msg("id不能为空！"));
            return "student";
        }
        if(studentService.getById(student.getId()) != null){
            model.addAttribute("msg", new Msg("输入的id已重复！"));
            return "student";
        }
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
        int reflect = studentService.update(student);
        if(reflect == 0){
            model.addAttribute("msg", new Msg("没有找到id为" + student.getId() + "的学生！修改失败！"));
        } else {
            model.addAttribute("msg", new Msg("修改成功！"));
        }
        model.addAttribute("students", studentService.getAll());
        return "student";
    }

    @RequestMapping("/student/checkDuplicated")
    @ResponseBody
    public JSONCheck checkDuplicated(@RequestParam("id") String id){
        Student student = studentService.getById(id);
        if(student == null){
            return new JSONCheck(id + "1", id);
        }else {
            return new JSONCheck(student.getId(), id);
        }
    }

    @RequestMapping("/student/showBack")
    @ResponseBody
    public Student AjaxShowBack(@RequestParam("id") String id){
        Student student = studentService.getById(id);
        if (student == null){
            return new Student(id, "此姓名不存在！！！！！！！", 0, 0.0);
        } else {
            return student;
        }
    }
}
