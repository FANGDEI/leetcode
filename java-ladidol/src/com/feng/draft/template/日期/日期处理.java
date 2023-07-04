package com.feng.draft.template.日期;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author Ladidol
 * @Date: 2022/3/20 15:49
 * @Version 1.0
 */
public class 日期处理 {
    public static void main(String[] args) throws Exception {
        //基本输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //通过SimpleDateFormat来解析设置日期格式:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        /*天数差*/
        Date fromDate = sdf.parse("2022-03-20 12:00");
        Date toDate = sdf.parse("2090-03-20 12:00");
        long from = fromDate.getTime();
        long to = toDate.getTime();
        int days = (int) ((to - from)/(1000*60*60*24));
        System.out.println("两个时间之间的天数差为: " + days);
    }
}