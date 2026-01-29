package top.dyw.leetcode.Hot100;

import java.util.*;
public class L118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j==0||j==i) {
                    list.add(1);
                } else {
                    List<Integer> preRow = result.get(i-1);
                    list.add(preRow.get(j-1) + preRow.get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}
