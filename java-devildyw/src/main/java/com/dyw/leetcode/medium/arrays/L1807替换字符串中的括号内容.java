package com.dyw.leetcode.medium.arrays;

import java.util.HashMap;
import java.util.List;

/**
 * @author Devil
 * @since 2023-01-12-10:13
 */
@SuppressWarnings("all")
public class L1807替换字符串中的括号内容 {
    public static void main(String[] args) {
        System.out.println(new L1807替换字符串中的括号内容().evaluate("(a)(a)(a)aaa", null));
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        //转换为hash表 防止超时
        HashMap<String,String> map = beHash(knowledge);

        StringBuilder sb = new StringBuilder();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                start = i;
                while (i<s.length()&&s.charAt(i)!=')'){
                    i++;
                }
                String str = s.substring(start+1,i); //获取括号里的key
                String value = map.getOrDefault(str, "?");
                sb.append(value);

            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private HashMap<String, String> beHash(List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0),list.get(1));
        }
        return map;
    }

}
