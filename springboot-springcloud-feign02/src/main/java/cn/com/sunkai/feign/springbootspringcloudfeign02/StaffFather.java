package cn.com.sunkai.feign.springbootspringcloudfeign02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class StaffFather {

    public Map<String,Task> taskMap = new HashMap<String,Task>();

    public LeadFather leadFather;
    public String staffName;

    public String staffCode;

    public abstract List<Task> getTask(String code) ;

    public abstract void setTask();


}
