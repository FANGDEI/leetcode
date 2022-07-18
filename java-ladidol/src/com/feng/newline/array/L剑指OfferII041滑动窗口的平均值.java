package com.feng.newline.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L剑指OfferII041滑动窗口的平均值
 * @author: Ladidol
 * @description:
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 *
 * 实现 MovingAverage 类：
 *
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 *  
 *
 * 示例：
 *
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 * @date: 2022/7/16 23:08
 * @version: 1.0
 */
public class L剑指OfferII041滑动窗口的平均值 {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("movingAverage.next(1) = " + movingAverage.next(1));
        System.out.println("movingAverage.next(10) = " + movingAverage.next(10));
        System.out.println("movingAverage.next(4) = " + movingAverage.next(3));
        System.out.println("movingAverage.next(5) = " + movingAverage.next(5));
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
//2022/7/17 看一下这里为啥不行哦。因为那个分母不是一直都是winSize的,然后就是sum是局部变量
//通过数组遍历怎么都没有滑动窗口在添加就做完这些东西快.
class MovingAverage {
    int size = 0;
    List<Double> nums = new ArrayList<>();
    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        double sum = 0;
        nums.add((double) val);
//        int winSize = Math.min(size, nums.size());
        int winSize = size;
        int fenMu = winSize;
        for (int i = nums.size() - 1; i >= 0; i--) {
            //带个for循环怎么都要慢一些的
            winSize--;//从数组后面开始遍历到前面来,遍历winSize个
            if (winSize < 0) {//如果winsize小于零了,就直接除以fenMu
                return sum/fenMu;
            }
            sum += nums.get(i);
        }
        //如果遍历完了,winSize还没有变成0,就直接用nums.size();
        return sum/ nums.size();
    }
}

//法2 滑动窗口!,效率的神.
class MovingAverage2 {
    List<Integer> nums = new ArrayList<>();

    int size;
    int sum;//窗口中的总和.
    int left = 0, right = 0;

    public MovingAverage2(int size) {
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