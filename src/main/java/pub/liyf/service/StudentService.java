package pub.liyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.liyf.bean.Student;
import pub.liyf.mapper.StudentMapper;

import java.util.List;

@Service
public class StudentService {

    // TODO:完善service层的方法

    @Autowired
    private StudentMapper mapper;

    @Transactional
    public List<Student> getAll(){
        return mapper.getAll();
    }

    @Transactional
    public Student getById(String id){
        return mapper.getById(id);
    }

    @Transactional
    public List<Student> getByLike(String partOfName){
        return mapper.getByLike(partOfName);
    }

    @Transactional
    public int insert(Student student){
        return mapper.insert(student);
    }

    @Transactional
    public int deleteById(String id){
        return mapper.deleteById(id);
    }

    @Transactional
    public int update(Student student){
        return mapper.update(student);
    }
}
