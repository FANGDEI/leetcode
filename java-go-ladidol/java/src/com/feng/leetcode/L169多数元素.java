package com.feng.leetcode;

/**
 * @Description: 这里的多数元素, 有一个重要的条件, 就是个数一定是多余一半的
 * @Author Ladidol
 * @Date: 2022/3/29 15:18
 * @Version 1.0
 */
public class L169多数元素 {
    public static void main(String[] args) {
        System.out.println("nihao");
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new 多数元素_分治().majorityElement(nums));
    }

}

class 多数元素_分治 {

    public int count(int[] nums, int target, int start, int end){
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == target){
                count ++;
            }
        }
        return count;
    }
    public  int majorityElementRec(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }


        int mid = start + (end - start) / 2;
        int left = majorityElementRec(nums, start, mid);
        int right = majorityElementRec(nums, mid + 1, end);

        if(left == right){
            //两边都相等的话,就随便返回一个
            return left;
        }
        //到这里就说说明,left和right不相等,有分歧;
        //所以合并left和right数组,再来看谁最多;
        int leftCount = count(nums, left, start, end);
        int rightCount = count(nums, right, start, end);

        //这里就是随机了,如果相等的话取哪一个都可以
        return leftCount >= rightCount ? left: right;

    }


    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}

class 多数元素_摩尔投票{
    public int majorityElement(int[] nums) {
        int x = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                //对每一次,count被怼完成0的时候,再次赋值;
                x = nums[i];
                count ++;
            }else if(x == nums[i]){
                count ++;
            }else{
                count --;
            }

        }
        return x;
    }
}
class 多数元素_随机数法{
    public int majorityElement(int[] nums) {//这里就是随机数大法, 我也不知道是为啥!!!
        int len = nums.length, half = len >> 1;
        while (true) {
            //随机取一个下标;
            int index = (int) (Math.random() * len);
            int num = nums[index];
            int count = 0;
            //然后对该数进行判断;
            for (int i = 0; i < len; i++) {
                count += nums[i] == num ? 1 : 0;
            }
            if (count > half) {
                return num;
            }
        }
    }
}


