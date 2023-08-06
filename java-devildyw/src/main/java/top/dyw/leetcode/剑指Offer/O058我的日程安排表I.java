package top.dyw.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devildyw
 * @date 2023/08/06 13:02
 **/
@SuppressWarnings("all")
public class O058我的日程安排表I {

    public static void main(String[] args) {

    }

    class MyCalendar {
        List<int[]> list;

        public MyCalendar() {
            list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int i = 0; i < list.size(); i++) {
                int[] range = list.get(i);
                int left = range[0];
                int right = range[1];
                if (left<end&&start<right){ //说明有重叠区域
                    return false;
                }
            }
            list.add(new int[]{start,end});
            return true;
        }
    }
}
