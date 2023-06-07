package top.dyw.leetcode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Devildyw
 * @date 2023/06/07 19:21
 **/
@SuppressWarnings("all")
public class OII017含有所有字符的最短字符串 {

    public static void main(String[] args) {

    }


    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();


    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        // 记录最短子串的开始位置和长度
        int start = 0, minLen = Integer.MAX_VALUE;
        int left  = 0, right = 0;
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0)+1);
        }

        int sLen = s.length();
        for (;right<sLen; right++){
            char c = s.charAt(right);
            if (ori.containsKey(c)){
                cnt.put(c,cnt.getOrDefault(c,0)+1);
            }

            while (check()&&left<=right){
                if (right-left+1< minLen){
                    //更新最小子串的位置和长度
                    start = left;
                    minLen = right-left+1;
                }
                char c1 = s.charAt(left++);
                if (ori.containsKey(c1)){
                    cnt.put(c1,cnt.getOrDefault(c1,0)-1);
                }
            }
        }
        return minLen ==Integer.MAX_VALUE?"":s.substring(start,start+ minLen);

    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            Character key = entry.getKey();
            if (cnt.getOrDefault(key,0)<entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
