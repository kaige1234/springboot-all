package cn.com.sk.javabasics.service.impl;

import cn.com.sk.javabasics.entity.GroupVolidation;
import cn.com.sk.javabasics.entity.Student;
import cn.com.sk.javabasics.group.OneGroup;
import cn.com.sk.javabasics.service.VolidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class VolidationServiceImpl implements VolidationService {

    @Qualifier("validator")
    @Autowired
    private Validator validated;

    /**
     * 手动校验对象中的参数
     */
    @Override
    public void testVolidation() {
        Student student = new Student();
        //student.setName("ddd");
        //student.setId(1);
        //student.setCode("222");
        Set<ConstraintViolation<Student>> validate = validated.validate(student);
        for(ConstraintViolation<Student> constraintViolation : validate){
            System.out.println(constraintViolation.getMessage());
        }

    }

    @Override
    public void testGroupVolidation() {
        GroupVolidation groupVolidation = new GroupVolidation();
        groupVolidation.setCode("11");
        groupVolidation.setName("333");
        groupVolidation.setNum("111");
        //groupVolidation.setDd();
        Set<ConstraintViolation<GroupVolidation>> validate = validated.validate(groupVolidation, OneGroup.class);
        for(ConstraintViolation<GroupVolidation> constraintViolation : validate){
            System.out.println(constraintViolation.getMessage());
        }


    }

    @Override
    public void customValidation() {

    }


}
