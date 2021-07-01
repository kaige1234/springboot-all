package cn.com.sk.javabasics.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DemoData {
    private String str;
    private Date date;
    private Double doubleData;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }
}
