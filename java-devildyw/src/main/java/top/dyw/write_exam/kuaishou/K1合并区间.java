package top.dyw.write_exam.kuaishou;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class K1合并区间 {
    public static void main(String[] args) {
            int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
            int[][] res = merge(intervals);
            for (int[] re : res) {
                System.out.println(re[0] + " " + re[1]);
            }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i=1; i<intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if (curStart <= end) {
                end = Math.max(end, curEnd);
            } else {
                result.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            }
        }

        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
