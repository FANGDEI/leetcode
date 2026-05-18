package top.dyw.leetcode.Hot100;
import java.util.*;
public class L763划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character,Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int curEnd = 0;

        for (int i=0; i<s.length(); i++) {
            curEnd = Math.max(curEnd, map.get(s.charAt(i)));
            if (i==curEnd) {
                result.add(i-start+1);
                start = i+1;
            }
        }

        return result;
    }
}
