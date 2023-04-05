package top.dyw.leetcode.simple.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-07-27-11:20
 */
@SuppressWarnings("all")
public class L119杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(list);
        }
        return lists.get(rowIndex - 1);
    }
}
