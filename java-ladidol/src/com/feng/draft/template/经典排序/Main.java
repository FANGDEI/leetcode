package com.feng.draft.template.经典排序;

import com.feng.draft.template.经典排序.排序的应用.寻找n中的第k大数字;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/27 14:15
 * @description: {}
 */
public class Main {
    public static void main(String[] args) {
//        归并排序 _归并排序 = new 归并排序();
//        快速排序 _快速排序 = new 快速排序();
        寻找n中的第k大数字 _寻找n中的第k大数字 = new 寻找n中的第k大数字();
        int[] nums = {1, 9, 2, 8, 6, 3, 4, 5, 7, 0};
        int ans = _寻找n中的第k大数字.search_main(nums.length, nums, 2);
        System.out.println("ans = " + ans);
    }
}
