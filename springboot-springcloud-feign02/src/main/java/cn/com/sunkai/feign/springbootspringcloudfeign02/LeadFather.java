package cn.com.sunkai.feign.springbootspringcloudfeign02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class LeadFather {

    public Map<String,StaffFather> map = new HashMap<>();


    public String leadCode ;

    public String leadName;

    public Task task;

    public abstract void assingningTask(String staffCode);

    public abstract List<Task> getSubordinateTask(String staffCode);

    public void delSafft(StaffFather staffFather){};

    public void addSafft(StaffFather staffFather){};
}
