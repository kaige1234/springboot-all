package cn.com.sk.javabasics.controller.excel;

import cn.com.sk.javabasics.entity.DemoData;
import cn.com.sk.javabasics.entity.a;
import cn.com.sk.javabasics.listener.DemoDataListener;
import com.alibaba.excel.EasyExcel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @GetMapping("/get")
    public String get(){
        return "成功";
    }

    @GetMapping("/gets")
    public a gets(){
        a ss = new a();
        List<String> list = new ArrayList<>();
        list.add("ddd");
        list.add("ddsfs");
        ss.setSss(list);
        ss.setAa("ddfdfd");
        return ss;
    }



    @PostMapping("/multipatFile")
    public List<DemoData> multipatFile( @RequestParam("multipatFile") MultipartFile file, HttpServletRequest request){
        try {
            DemoDataListener excelListener = new DemoDataListener();

            EasyExcel.read(new BufferedInputStream(file.getInputStream()),excelListener).head(DemoData.class).sheet().doReadSync();
            return excelListener.getList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/excel")
    public List<DemoData> excel(){
        try {
            DemoDataListener excelListener = new DemoDataListener();
            File file1 = new File("/Users/sunkai/excel/test.xls");
            EasyExcel.read(new BufferedInputStream(new FileInputStream(file1)),excelListener).head(DemoData.class).sheet().doReadSync();
            return excelListener.getList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
