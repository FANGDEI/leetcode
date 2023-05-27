package com.feng.draft.template.排序;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/27 14:32
 * @description: {}
 */
public class 快速排序 {
    //https://mp.weixin.qq.com/s?__biz=MzA4MTE4NTg1OA==&mid=2247483943&idx=1&sn=e4dddfcb197db67f18f2438f6fca3fbe&chksm=9f999f0aa8ee161ca91779fbd3c7fbc72185288f0dec2fbd2dc07404d651b0ec14290279eda7#rd


    /**
     * quick sort(no stable)
     * best: 0(nlogn)
     * worst: 0(n2)
     * average: 0(nlogn)
     * space: 0(1)
     *
     * @param n
     * @param nums
     */
    public void main_sort(int n, int[] nums) {
        sort(0, n - 1, nums);
    }

    /**
     * 递推公式：
     * quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
     * 终止条件：
     * p >= r
     *
     * @param p
     * @param r
     * @param nums
     */
    public void sort(int p, int r, int[] nums) {
        if (p >= r) {
            return;
        }
        //获得分区位置
        int q = partition(p, r, nums);
        sort(p, q - 1, nums);
        sort(q + 1, r, nums);
    }

    //分区函数，原地分区
    public int partition(int start, int end, int[] nums) {
        //默认取最后一个元素作为pivot；
        int pivot = end;
        //通过i来遍历增加小于pivot的值：左边小于pivot，右边大于pivot
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < nums[pivot]) {//求升序
                swap(i++, j, nums);
            }
        }
        swap(i, pivot, nums);
        return i;//此时的pivot已经换位到它的位置了。
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
