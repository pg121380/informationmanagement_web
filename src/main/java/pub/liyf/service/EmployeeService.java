package pub.liyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.liyf.mapper.EmployeeMapper;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper mapper;
}
