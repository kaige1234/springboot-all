package cn.com.sk.mycat.controller;

import cn.com.sk.mycat.entity.Student;
import cn.com.sk.mycat.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/get/{id}")
    public String get(@PathParam("id") int id){
        return studentService.queryFarmer(id);
    }

    @RequestMapping("/insert")
    public int insert(@RequestBody Student student){
        return studentService.insert(student);
    }
}
