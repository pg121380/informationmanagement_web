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

    @GetMapping("/list")
    @ResponseBody
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Student getById(@PathVariable("id") String id){
        return studentService.getById(id);
    }

    @GetMapping("/getByLike/{partOfName}")
    @ResponseBody
    public List<Student> getByLike(@PathVariable("partOfName") String partOfName){

        return studentService.getByLike(partOfName);
    }


    @PostMapping("/add")
    @ResponseBody
    public int insert(Student student){
        System.out.println(student);
        return studentService.insert(student);
    }

}
