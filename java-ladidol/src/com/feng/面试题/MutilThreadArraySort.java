package com.feng.面试题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/15 12:54
 * @description: {}
 */
public class MutilThreadArraySort implements Runnable {
    private String num;

    public MutilThreadArraySort(int num) {
        this.num = num + "";
    }

    public static void main(String[] args) {
        //把这个数组升序输出
        int length = 10;
        List<Integer> nums = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);
        System.out.println("nums = " + nums);

        for (int i = 0; i < length; i++) {
            new Thread(new MutilThreadArraySort(nums.get(i))).start();
        }
    }


    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
