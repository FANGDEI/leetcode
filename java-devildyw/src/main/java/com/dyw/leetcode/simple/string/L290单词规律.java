package com.dyw.leetcode.simple.string;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-06-22-13:30
 */
@SuppressWarnings("all")
public class L290单词规律 {
    public static void main(String[] args) {
        System.out.println(new L290单词规律().wordPattern01("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        int length = str.length;
        if (length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> sMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char c = pattern.charAt(i);
            if ((patternMap.containsKey(c) && !patternMap.get(c).equals(str[i])) || (sMap.containsKey(str[i]) && sMap.get(str[i]) != c)) {
                return false;
            }
            patternMap.put(c, str[i]);
            sMap.put(str[i], c);
        }
        return true;
    }

    public boolean wordPattern01(String pattern, String s) {
        String[] split = s.split("[ ]+");
        if (split.length!=pattern.length()){
            return false;
        }
        //使用两个map分别存储字符与字符串的对应关系 防止出现 abba dog dog dog dog 为true的情况
        //该情况就是没有字符对应字符串的情况 我们需要保证字符与字符串一一对应 而map只是一个key对应一个值 所以我们用两个map就可以相互对应 达到一一对应
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> sMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)&&!map.get(c).equals(split[i])||(sMap.containsKey(split[i])&&sMap.get(split[i])!=(c))){
                return false;
            }
            map.put(c,split[i]);
            sMap.put(split[i],c);
        }
        return true;
    }
}
