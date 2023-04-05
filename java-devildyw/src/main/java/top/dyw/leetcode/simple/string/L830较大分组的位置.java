package top.dyw.leetcode.simple.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-07-08-11:28
 * <p>
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 */
@SuppressWarnings("all")
public class L830较大分组的位置 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new L830较大分组的位置().largeGroupPositions("aaa");
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(start)) {
                if (end - start >= 2) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(start);
                    integers.add(end);
                    lists.add(integers);
                }
                start = i;
            }
            end = i;
        }
        if (end - start >= 2) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(start);
            integers.add(end);
            lists.add(integers);
        }
        return lists;
    }
}
