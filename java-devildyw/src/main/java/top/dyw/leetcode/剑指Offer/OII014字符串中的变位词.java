package top.dyw.leetcode.剑指Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Devildyw
 * @date 2023/06/03 11:39
 **/
@SuppressWarnings("all")
public class OII014字符串中的变位词 {


    public static void main(String[] args) {

    }

    /**
     * 滑动窗口，感觉性能影响不是很大和暴力相比
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n>m){
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i)-'a'];
            ++cnt2[s2.charAt(i)-'a'];
        }
        //先计算前n个时
        if (Arrays.equals(cnt1,cnt2)){
            return true;
        }
        //滑动窗口 n个后时
        for (int i = n; i<m; i++){
            ++cnt2[s2.charAt(i)-'a'];
            --cnt2[s2.charAt(i-n)-'a'];
            if (Arrays.equals(cnt1,cnt2)){
                return true;
            }
        }
        return false;
    }
}
