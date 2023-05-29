package com.feng.draft.template.经典排序.排序的应用;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/26 16:20
 * @description: {}
 */
public class 寻找n中的第k大数字 {


    /**
     * https://mp.weixin.qq.com/s?__biz=MzA4MTE4NTg1OA==&mid=2247483943&idx=1&sn=e4dddfcb197db67f18f2438f6fca3fbe&chksm=9f999f0aa8ee161ca91779fbd3c7fbc72185288f0dec2fbd2dc07404d651b0ec14290279eda7#rd
     */
    public int search_main(int n, int[] nums, int k) {
        sort(0, n - 1, nums, k);
        return ans;

    }

    int ans = -1;

    public void sort(int p, int r, int[] nums, int k) {
        if (p >= r) {
            return;
        }
        //获得分区位置
        int q = partition(p, r, nums);
        if (q + 1 == k) {
            ans = nums[q];
        } else if (q + 1 > k) {//注意方向不要找错了
            sort(p, q - 1, nums, k);
        } else {
            sort(q + 1, r, nums, k);
        }
    }

    //分区函数，原地分区
    public int partition(int start, int end, int[] nums) {
        //默认取最后一个元素作为pivot；
        int pivot = end;
        //通过i来遍历增加小于pivot的值：左边小于pivot，右边大于pivot
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] > nums[pivot]) {//求降序
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
