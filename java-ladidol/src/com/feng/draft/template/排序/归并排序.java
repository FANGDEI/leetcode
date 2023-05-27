package com.feng.draft.template.排序;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/27 14:01
 * @description: {}
 */
public class 归并排序 {

    /**
     * merge sort(stable)
     * best: 0(nlogn)
     * worst: 0(nlogn)
     * average: 0(nlogn)
     * space: 0(n)
     *
     * @param n
     * @param nums
     */
    public void main_sort(int n, int[] nums) {
        sort(0, n - 1, nums);
    }


    /**
     * 自己规定，p和r都是可以到达的index；
     *
     * 递推公式：
     * merge_sort(p…r) = merge(sort(p…q), sort(q+1…r))
     * 终止条件：
     * p >= r 不用再继续分解
     *
     * @param p
     * @param r
     * @param nums
     */
    public void sort(int p, int r, int[] nums) {
        if (p >= r) {
            return;
        }
        int mid = (p + r) / 2;
        sort(p, mid, nums);
        sort(mid + 1, r, nums);
        merge(p, mid, r, nums);

    }

    public void merge(int start, int mid, int end, int[] nums) {
        int[] tmp = new int[nums.length];
        //使用两个index，分别从两数组开始遍历。
        int i = start;
        int j = mid + 1;
        int t = 0;//temp的index；
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                tmp[t++] = nums[j++];
            }
        }
        //将未接完的数组全部放到后面去
        while (i <= mid) {
            tmp[t++] = nums[i++];
        }
        while (j <= end) {
            tmp[t++] = nums[j++];
        }
        //copy from `tmp` to `nums`；
        for (i = start, t = 0; i <= end; i++, t++) {//注意t和i的起始坐标
            nums[i] = tmp[t];
        }
    }


}
