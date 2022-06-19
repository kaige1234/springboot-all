package cn.com.sunkai.feign.springbootspringcloudfeign02;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args){
        int[] inputArray = {2,8,9,12,21,24,56};
        //System.out.println(5/2);
        String ss= Test.findMiddleNumber(inputArray);
        System.out.println(ss);
    }

    public static String findMiddleNumber(int[] inputArray){
        if(null == inputArray || inputArray.length == 0){
           return "";
        }
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length - 1 - i; j++) {
                if (inputArray[j + 1] < inputArray[j]) {
                    int temp = inputArray[j + 1];
                    inputArray[j + 1] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }

        if(inputArray.length %2 == 1){
            return String.valueOf(inputArray[(inputArray.length-1)/2 ]);
        }else{
            int a = inputArray[(inputArray.length-1)/2 +1];
            int b = inputArray[(inputArray.length)/2 -1];
            BigDecimal bigDecimal = new BigDecimal(a + b);
            return bigDecimal.divide(new BigDecimal(2),1,BigDecimal.ROUND_HALF_UP).toString();
        }

    }
}
