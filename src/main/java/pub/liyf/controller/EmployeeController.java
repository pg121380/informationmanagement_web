package pub.liyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pub.liyf.service.EmployeeService;

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
}
