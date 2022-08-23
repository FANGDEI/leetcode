package com.dyw.leetcode.algorithm.sort;

/**
 * @author Devil
 * @since 2022-08-23-13:14
 */
@SuppressWarnings("all")
public class 快速排序 {
    public static void main(String[] args) {
        int[] ints = {6, 2, 3, 4, 5};
        new 快速排序().quickSort(ints, 0, ints.length - 1);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public void quickSort(int[] nums, int low, int high) {
        int i, j, index;
        if (low >= high) {
            return; //基线条件
        }
        //递归条件
        //根据遍历条件将数组分为两侧 一侧数字全部小于基准 一侧全部大于基准 最后将基准填入两侧之间
        i = low;
        j = high;
        index = nums[i]; //此时nums[i]作为基准 i也作为一个坑
        while (i < j) {
            //从右找出第一个小于基准的值
            while (i < j && nums[j] >= index){
                j--;
            }
            //将其填入此时i的那个坑中 且i++
            if (i<j){
                nums[i++] = nums[j];
            }
            //同理从左找出第一个大于基准的值
            while (i<j&&nums[i]<index){
                i++;
            }
            if (i<j){
                nums[j--] = nums[i];
            }
        }
        nums[i] = index; //最后i==j条件跳出循环 此时ij指向的那个坑就是最终基准该填入的位置
        quickSort(nums,low,i-1); //递归将基准左右两边继续进行快速排序
        quickSort(nums,i+1,high);
    }

}
