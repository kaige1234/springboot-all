package cn.com.sk.mycat.controller;

import cn.com.sk.mycat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/get")
    public String get(){
        return studentService.queryFarmer();
    }
}
