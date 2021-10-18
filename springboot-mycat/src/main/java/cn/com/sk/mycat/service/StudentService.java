package cn.com.sk.mycat.service;

import cn.com.sk.mycat.entity.Student;

/**
 * @author sunkai
 * @title: StudentService
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/1511:54
 */
public interface StudentService {

    String queryFarmer(int id);

    int insert(Student student);
}
