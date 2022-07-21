package com.feng.newline.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L729我的日程安排表I
 * @author: Ladidol
 * @description:
 *
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 *
 * 解释：
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
 * myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
 *
 *
 *
 * @date: 2022/7/19 16:37
 * @version: 1.0
 */
public class L729我的日程安排表I {
    //分析本题只需要考虑不重复就行,不是日程安排中的II
    //TODO2022/7/19  //不知道为啥这里就是不行.
//    class MyCalendar {
//        Set<Integer> set = null;
//        public MyCalendar() {
//            set = new HashSet<>();
//        }
//
//        public boolean book(int start, int end) {
//            for (int i = start; i < end; i++) {
//                if (!set.add(i)){
//                    return false;
//                }
//            }
//            return true;
//        }
//    }

    //试一下模拟
    class MyCalendar2 {
        List<int[]> booded;

        public MyCalendar2() {
            booded = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] temp : booded) {
                //画图就知道为啥这里这样取了.
                if (temp[0] < end && temp[1] > start){//因为一开一闭, 所以都不取等于.
                    return false;
                }
            }
            booded.add(new int[]{start,end});
            return true;
        }
    }






}
