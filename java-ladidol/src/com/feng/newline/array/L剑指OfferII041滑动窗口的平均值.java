package com.feng.newline.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L剑指OfferII041滑动窗口的平均值
 * @author: Ladidol
 * @description:
 * @date: 2022/7/16 23:08
 * @version: 1.0
 */
public class L剑指OfferII041滑动窗口的平均值 {


//    class MovingAverage {
//        int size = 0;
//        List<Integer> nums = new ArrayList<>();
//        int sum = 0;
//
//        /**
//         * Initialize your data structure here.
//         */
//        public MovingAverage(int size) {
//            this.size = size;
//        }
//
//        public double next(int val) {
//            nums.add(val);
//            int winSize = size;
//            double avg = 0;
//            for (int i = nums.size() - 1; i >= 0; i--) {
//                winSize--;
//                if (winSize < 0) {
//                    return sum/size;
//                }
////                System.out.println("i = " + i);
//                sum += nums.get(i);
//            }
//            return sum/size;
//        }
//    }


    class MovingAverage {
        List<Integer> nums = new ArrayList<>();

        int size;
        int sum;//窗口中的总和.
        int left = 0, right = 0;

        public MovingAverage(int size) {
            this.size = size;
            sum = 0;
        }

        // 维护大小为size的队列
        public double next(int val) {
            // 超过窗口数,就左边的收缩,出窗口
            if (right - left == size) {
                sum -= nums.get(left++);
            }
            // 入队
            nums.add(val);
            right++;
            sum = sum + nums.get(right-1);
            return 1.0 * sum / (right - left);
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
