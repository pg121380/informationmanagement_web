package pub.liyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    public Student getById(@PathVariable("id") String id){
        return studentService.getById(id);
    }

    @GetMapping("/getByLike/{partOfName}")
    public Student getByLike(@PathVariable("partOfName") String partOfName){
        return studentService.getByLike(partOfName);
    }

}
