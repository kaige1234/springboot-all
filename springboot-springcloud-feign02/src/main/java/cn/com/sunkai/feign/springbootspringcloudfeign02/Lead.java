package cn.com.sunkai.feign.springbootspringcloudfeign02;

import java.util.List;

public class Lead  extends LeadFather{

    Lead(Task task){
        this.task =task;
    }
    @Override
    public void assingningTask(String staffCode) {
        if(super.map != null){
            StaffFather staffFather = super.map.get(staffCode);
            staffFather.setTask();
        }
    }

    @Override
    public List<Task> getSubordinateTask(String staffCode) {
        if(super.map != null){
            StaffFather staffFather = super.map.get(staffCode);
            return staffFather.getTask(this.leadCode);
        }
        return null;
    }
}
