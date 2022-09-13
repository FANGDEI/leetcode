package com.feng.draft;

/**
 * @projectName: leetcode
 * @package: com.feng.draft
 * @className: String的一些小操作
 * @author: Ladidol
 * @description:
 * @date: 2022/9/12 23:55
 * @version: 1.0
 */
public class String的一些小操作 {

    String s = "xiaoxiao";

    // 判断是不是数字字符
    public boolean isDigit(){
        if (Character.isDigit(s.charAt(0))){
            System.out.println("这个字符是数字！");
        }
        return true;
    }


}
