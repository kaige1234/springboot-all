package cn.com.sunkai.feign.springbootspringcloudfeign02;

import java.util.List;
import java.util.stream.Collectors;

public class Safft extends StaffFather {


    @Override
    public List<Task> getTask(String code) {
        if(super.taskMap != null){
            taskMap.entrySet().stream().filter(str ->{
                if(code.equals(str)){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public void  setTask() {
         taskMap.put(leadFather.leadCode,leadFather.task)  ;
    }
}
