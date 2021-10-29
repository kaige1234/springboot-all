package cn.com.sk.javabasics.controller.haberneter;


import cn.com.sk.javabasics.entity.Classes;
import cn.com.sk.javabasics.entity.Student;
import cn.com.sk.javabasics.entity.VolidationEntity;
import cn.com.sk.javabasics.service.VolidationService;
import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/volidation")
public class VolidationController {


    @GetMapping("/getVolidation")
    public String getVolidation(@Validated @RequestBody VolidationEntity volidationEntity,
                           BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for(ObjectError objectError: allErrors){
                return objectError.getDefaultMessage();
            }

        }


       return "成功";
    }

    @GetMapping("/getClasses")
    public String getClasses(@Validated @RequestBody Classes classes
            ,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for(ObjectError objectError: allErrors){
                return objectError.getDefaultMessage();
            }

        }
        return "成功";
    }

    @GetMapping("/getC")
    public Classes getC(){
        Classes classes = new Classes();
        classes.setCode("ddd");
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setCode("ddd");
        student.setId(22);
        student.setName("ddd");
        list.add(student);
        classes.setList(list);
        return classes;
    }

    @GetMapping("/getV")
    public VolidationEntity getV(){
        VolidationEntity volidationEntity = new VolidationEntity();
        volidationEntity.setAge("33");
        volidationEntity.setCode("ddd");
        volidationEntity.setDecimalMax(22);
        volidationEntity.setDecimalMin(22);
        volidationEntity.setFlag(true);
        volidationEntity.setId("22");
        volidationEntity.setName("sss");
        volidationEntity.setOldAge(1);
        volidationEntity.setUse(true);
        volidationEntity.setPast(new Date());
        volidationEntity.setFuture(new Date());
        volidationEntity.setEmai("dddd");
        volidationEntity.setDecimalMin(2);
        volidationEntity.setNum(1);
        volidationEntity.setNotEtity("222");
        List<String> list = new ArrayList<>();
        list.add("ddd");
        volidationEntity.setList(list);
        return volidationEntity;
    }

    @Autowired
    private VolidationService volidationService;

    /**
     * 测试手动校验
     */
    @GetMapping("/checkValidation")
    public void checkValidation(){
        volidationService.testVolidation();
    }

    /**
     * 测试分组校验
     */
    @GetMapping("/checkGroupValidation")
    public void checkGroupValidation(){
        volidationService.testGroupVolidation();
    }

    /**
     * 自定义校验
     */
    @GetMapping("/customValidation")
    public void customValidation(){
        volidationService.customValidation();
    }


}
