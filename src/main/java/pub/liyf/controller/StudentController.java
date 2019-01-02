package pub.liyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pub.liyf.bean.Student;
import pub.liyf.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/list")
    @ResponseBody
    public List<Student> getAllStudent(){
        return studentService.getAll();
    }

    @GetMapping("/student/getById/{id}")
    @ResponseBody
    public Student getById(@PathVariable("id") String id){
        return studentService.getById(id);
    }

    @GetMapping("/student/getByLike/{partOfName}")
    @ResponseBody
    public List<Student> getByLike(@PathVariable("partOfName") String partOfName){

        return studentService.getByLike(partOfName);
    }


    @PostMapping("/student/add")
    @ResponseBody
    public int insert(Student student){
        return studentService.insert(student);
    }

    @GetMapping("/student/delete/{id}")
    @ResponseBody
    public int deleteById(@PathVariable("id") String id){
        return studentService.deleteById(id);
    }

    @PostMapping("/student/update")
    @ResponseBody
    public int update(Student student){
        return studentService.update(student);
    }
}
