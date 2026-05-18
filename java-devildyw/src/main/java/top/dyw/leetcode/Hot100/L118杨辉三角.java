package top.dyw.leetcode.Hot100;

import java.util.*;
public class L118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j==0 || j==i) {
                    temp.add(1);
                } else {
                    List<Integer> prev = result.get(i-1);
                    temp.add(prev.get(j) + prev.get(j-1));
                }
            }
            result.add(temp);
        }
        return result;
    }
}
