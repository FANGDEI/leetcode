package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L27移除元素
 * @author: Ladidol
 * @description: 双指针风骚起来，也是无敌, 但是该怎么风骚呢?
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * @date: 2022/5/21 11:35
 * @version: 1.0
 */
public class L27移除元素 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(new L27双指针().removeElement(nums,2));
    }
}
class L27双指针 {

    //法子一, 就是指针通过前后相向移动[相对顺序改变]
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int pre = 0;//从前面检索满足的
        int end = len-1;//从后面检索可以替换的, 和前面的换位置
        while(pre<=end){
            if (nums[pre]==val){
                if (nums[end]!=val){
                    nums[pre]=nums[end];
                    pre++;
                    end--;
                    len--;
                }
                else{
                    end--;
                    len--;
                }
            }else{
                pre++;
            }
        }
        return len;
    }
    //法子二, 就是有个快指针,一个慢指针,快指针遍历一遍就结束,慢指针位置表示新数组的末尾[相对顺序不变]
    public int removeElement2(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                //快指针被依次赋值不同的值
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;

    }
}
