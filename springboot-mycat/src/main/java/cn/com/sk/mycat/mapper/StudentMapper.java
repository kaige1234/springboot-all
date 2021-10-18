package cn.com.sk.mycat.mapper;

import cn.com.sk.mycat.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;



@Component
public interface StudentMapper extends BaseMapper<Student> {

    String queryFarmer(@Param("id") int id);
}