package pub.liyf.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @RequestMapping("/toStudent")
    public String toStudentPage(){
        return "student";
    }

    @RequestMapping("/toEmployee")
    public String toEmployeePage(){
        return "employee";
    }
}
