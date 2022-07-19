package com.feng.newline.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L731我的日程安排表II
 * @author: Ladidol
 * @description: 如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * <p>
 * 输入：
 * ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * 输出：
 * [null, 1, 1, 2, 3, 3, 3]
 * <p>
 * 解释：
 * MyCalendarThree myCalendarThree = new MyCalendarThree();
 * myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
 * myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
 * myCalendarThree.book(5, 10); // 返回 3
 * myCalendarThree.book(25, 55); // 返回 3
 * @date: 2022/7/19 10:01
 * @version: 1.0
 */
public interface L732我的日程安排表III {


    class MyCalendarThree1 {
        //这个就是II的缩水版
        TreeMap<Integer, Integer> cnt;
        int bookMax = 0;
        int res = 0;

        public MyCalendarThree1() {
            cnt = new TreeMap<>();
        }

        public int book(int start, int end) {
            cnt.put(start, cnt.getOrDefault(start, 0) + 1);
            cnt.put(end, cnt.getOrDefault(end, 0) - 1);

            int temp = 0;

            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                temp = entry.getValue();
                bookMax += temp;
                res = Math.max(bookMax, res);
            }
            return res;//放回最大值。

        }
    }

    class MyCalendarThree {
        TreeMap<Integer, Integer> cnt;
        int bookMax = 0;
        int res = 0;

        public MyCalendarThree() {
            cnt = new TreeMap<>((x, y) -> y - x);//只能说这个好神奇!
        }

        public int book(int start, int end) {
            cnt.put(start, cnt.getOrDefault(start, 0) + 1);
            cnt.put(end, cnt.getOrDefault(end, 0) - 1);

            int temp = 0;

            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                temp = entry.getValue();
                bookMax -= temp;
                res = Math.max(bookMax, res);
            }
            return res;//放回最大值。

        }
    }

}
