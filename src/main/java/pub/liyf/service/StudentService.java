package pub.liyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.liyf.bean.Student;
import pub.liyf.mapper.StudentMapper;

import java.util.List;

@Service
public class StudentService {

    // TODO:完善service层的方法

    @Autowired
    private StudentMapper mapper;

    public List<Student> getAll(){
        return mapper.getAll();
    }

    public Student getById(String id){
        return mapper.getById(id);
    }

    public List<Student> getByLike(String partOfName){
        return mapper.getByLike(partOfName);
    }

    public int insert(Student student){
        return mapper.insert(student);
    }

    public int deleteById(String id){
        return mapper.deleteById(id);
    }

    public int update(Student student){
        return mapper.update(student);
    }
}
