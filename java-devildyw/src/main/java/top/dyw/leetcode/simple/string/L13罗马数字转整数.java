package top.dyw.leetcode.simple.string;

import java.util.HashMap;

/**
 * @author Devildyw
 * @date 2023/12/22 20:22
 **/
@SuppressWarnings("all")
public class L13罗马数字转整数 {

    public static void main(String[] args) {

    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("D",500);
        map.put("CD",400);
        map.put("CM",900);
        map.put("M",1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                sum+=map.get(s.substring(i,i+2));
                ++i;
            }else if (map.containsKey(s.substring(i,i+1))){
                sum+=map.get(s.substring(i,i+1));
            }
        }

        return sum;
    }
}
