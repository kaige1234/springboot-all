package cn.com.sk.mycat.service.impl;

import cn.com.sk.mycat.entity.Student;
import cn.com.sk.mycat.mapper.StudentMapper;
import cn.com.sk.mycat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunkai
 * @title: StudentServiceImpl
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/1511:54
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String queryFarmer(int id) {
        return studentMapper.queryFarmer(id);
    }

    @Override
    public String queryStudent(String name) {
        return studentMapper.queryStudent(name);
    }

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }
}
