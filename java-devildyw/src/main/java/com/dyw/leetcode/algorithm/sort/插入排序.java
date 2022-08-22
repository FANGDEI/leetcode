package com.dyw.leetcode.algorithm.sort;

/**
 * @author Devil
 * @since 2022-08-22-10:55
 */
@SuppressWarnings("all")
public class 插入排序 {
    public static void main(String[] args) {
        int[] ints = {5, 2, 4, 6, 1, 3};
        new 插入排序().insertionSortAsc(ints);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }


    public void insertionSort(int[] nums){
        int n = nums.length;

        //以[0，j-1]视为已排序好的序列 而[j，n-1]则是还未排序的序列 我们需要从[j,n-1]中取出元素插入到已排序好的序列中
        for (int j = 1; j < n; j++) {
            //初始时,j为1 所以已排序好的序列中只有一个元素 也就是我们数组中的第一个元素
            int key = nums[j];
            //存储此时j的值
            //初始化i 移动元素
            int i = j-1;
            //从i开始往前找出比key小的第一个元素 并将此前比key大的元素往后移动
            while (i>=0&&nums[i]>key){
                nums[i+1] = nums[i];
                i--;
            }
            //最后会空出一个坑 这个坑就填上我们存储好的j对应的值
            nums[i+1] = key;
            //如此往复 序列自然而然会排序好
        }
    }

    /**
     * 降序
     * @param nums
     */
    public void insertionSortAsc(int[] nums){
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j>=0&&nums[j]<key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

}
