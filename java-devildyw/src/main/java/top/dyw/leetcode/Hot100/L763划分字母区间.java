package top.dyw.leetcode.Hot100;
import java.util.*;
public class L763划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        int n = s.length();

        for (int i=0; i<n; i++) {
            hash[chars[i]-'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        int curEnd = 0;
        for (int i= 0; i<n; i++) {
            curEnd = Math.max(curEnd, hash[chars[i]-'a']);
            count++;
            if (i == curEnd) {
                result.add(count);
                count=0;
            }
        }

        return result;
    }
}
