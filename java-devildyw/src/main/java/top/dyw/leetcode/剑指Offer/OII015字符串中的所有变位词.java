package top.dyw.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Devildyw
 * @date 2023/06/06 19:21
 **/
@SuppressWarnings("all")
public class OII015字符串中的所有变位词 {

    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(pCount, sCount)) {
                ans.add(i + 1);
            }
        }


        return ans;
    }
}
