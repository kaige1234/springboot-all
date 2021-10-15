package cn.com.sk.mycat.mapper;

import cn.com.sk.mycat.entity.Student;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import org.springframework.stereotype.Component;



@Component
public interface StudentMapper extends Mapper<Student> {

    String queryFarmer();
}