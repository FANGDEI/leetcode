package top.dyw.leetcode.剑指Offer;

import java.util.HashSet;
import java.util.Map;

/**
 * @author Devildyw
 * @date 2023/06/06 19:39
 **/
@SuppressWarnings("all")
public class OII016不含重复字符的最长子字符串 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int count = 0;

        int[] hash = new int[128];
        int index = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            hash[s.charAt(i)]++;
            while (hash[s.charAt(i)]==2){
                hash[s.charAt(index++)]--;
            }
            count = Math.max(count,i-index+1);
        }
        return count;
    }

}


