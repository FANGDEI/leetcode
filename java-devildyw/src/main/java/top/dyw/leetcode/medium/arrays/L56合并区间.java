package top.dyw.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Devil
 * @since 2022-07-26-11:14
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
@SuppressWarnings("all")
public class L56合并区间 {
    public static void main(String[] args) {

    }

    /**
     * 将区间进行排序
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/50417462969bd13230276c0847726c0909873d22135775ef4022e806475d763e-56-2.png">
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        //将散列的区间进行排序 以区间的左区间为排序的基准
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //mergedlist 用来合并区间
        ArrayList<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //取出第i个元素的左区间和右区间
            int L = intervals[i][0], R = intervals[i][1];
            //如果列表为空或是列表中最后一个元素(往往是右区间最大的数)比第i个元素的左区间小的话 就新增 因为他们无法合并只能算作新的区间
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            }//如果不符合上面的条件的话 就更新区间 因为右区间已经比左区间大了(所以列表中的区间包括了左区间的一部分) 更新右区间
            else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        //返回结果
        return merged.toArray(new int[merged.size()][]);

    }
}
