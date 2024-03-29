package com.feng.newline.array;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L731我的日程安排表II
 * @author: Ladidol
 * @description: 如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * <p>
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * @date: 2022/7/19 10:01
 * @version: 1.0
 */
public class L731我的日程安排表II {

    public static void main(String[] args) {

//        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
//        System.out.println("myCalendarTwo.book(10,20) = " + myCalendarTwo.book(10, 20)); // returns true
//        System.out.println("myCalendarTwo.book(50,60) = " + myCalendarTwo.book(50, 60)); // returns true
//        System.out.println("myCalendarTwo.book(10,40) = " + myCalendarTwo.book(10, 40)); // returns true
//        System.out.println("myCalendarTwo.book(5,15) = " + myCalendarTwo.book(5, 15)); // returns false
//        System.out.println("myCalendarTwo.book(5,10) = " + myCalendarTwo.book(5, 10)); // returns true
//        System.out.println("myCalendarTwo.book(25,55) = " + myCalendarTwo.book(25, 55)); // returns true

    }

    class MyCalendarTwo {
            TreeMap<Integer, Integer> cnt;//treemap有顺序,相当于,用treemap来换了一下数组
//        HashMap<Integer, Integer> cnt;//hashmap没有顺序

        public MyCalendarTwo() {
        cnt = new TreeMap<Integer, Integer>();
//            cnt = new HashMap<Integer, Integer>();
        }

        public boolean book(int start, int end) {
            int maxBook = 0;
            int ans = 0;
            //默认是没有日程的,所以默认cnt差分数组都是0;
            cnt.put(start, cnt.getOrDefault(start, 0) + 1);//新建日程
            cnt.put(end, cnt.getOrDefault(end, 0) - 1);


            //恢复,正向恢复
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int freq = entry.getValue();//得到当前预定情况, 这里一定是按顺序来的.
                maxBook += freq;//还原原数组, 得到当前天数最大的预定量maxBook
                if (maxBook > 2) {
                    cnt.put(start, cnt.getOrDefault(start, 0) - 1);//没有写入日程的,就不允许insert进去,还原回去.
                    cnt.put(end, cnt.getOrDefault(end, 0) + 1);//对于没有写入日程的,就不允许insert.
                    return false;
                }
            }
            return true;
        }
    }

    //暴力模拟
    class MyCalendarTwo2 {
        List<int[]> booked;//第一次预定后就会放到这里来
        List<int[]> overlaps;//这个是第二次重复后保存的地方

        public MyCalendarTwo2() {
            booked = new ArrayList<int[]>();
            overlaps = new ArrayList<int[]>();
        }

        public boolean book(int start, int end) {
            for (int[] arr : overlaps) {//和日程安排I的暴力模拟一样, 先遍历数组,看看若在overlaps中就有重复的话,就直接return false;
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    return false;
                }
            }
            for (int[] arr : booked) {//通过overlaps的筛选,这里对第一次插入的日程进行遍历
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
                }
            }
            booked.add(new int[]{start, end});
            return true;
        }
    }


    //一个佬的逆向恢复方法todo这里有点没看懂。
    class MyCalendarTwo3 {

        TreeMap<Integer, Integer> map;

        public MyCalendarTwo3() {
            map = new TreeMap<>((x, y) -> y - x);//这里是传一个比较器，让数据倒序。
        }

        public boolean book(int start, int end) {
            int temp = 0;
            int ans = 0;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);

            //恢复所有的值 采取了逆向恢复 和正向恢复都一样
            for (Integer key : map.keySet()) {
                temp = temp - map.get(key);
                ans = Math.max(ans, temp);
                if (ans > 2) {
                    map.put(start, map.getOrDefault(start, 0) - 1);
                    map.put(end, map.getOrDefault(end, 0) + 1);
                    return false;
                }
            }
            return true;
        }
    }


}




