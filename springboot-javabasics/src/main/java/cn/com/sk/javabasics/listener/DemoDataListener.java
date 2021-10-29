package cn.com.sk.javabasics.listener;

import cn.com.sk.javabasics.entity.DemoData;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    private static final int BATCH_COUNT = 5;
    List<DemoData> list = new ArrayList<DemoData>();
    DemoData demoData =null;

    public DemoDataListener(DemoData demoData) {
        this.demoData = demoData;
    }

    public DemoDataListener(){}

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        simpleDateFormat.format(demoData.getDate());

        list.add(demoData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<DemoData> getList(){
        return list;
    }



}
