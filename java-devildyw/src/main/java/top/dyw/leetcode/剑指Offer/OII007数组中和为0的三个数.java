package top.dyw.leetcode.剑指Offer;

import java.util.*;

/**
 * @author Devildyw
 * @date 2023/05/30 19:23
 **/
@SuppressWarnings("all")
public class OII007数组中和为0的三个数 {
    public static void main(String[] args) {
        System.out.println(new OII007数组中和为0的三个数().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }

            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;

            for (;left<nums.length; left++){
                if (left>i+1&&nums[left]==nums[left-1]){
                    continue;
                }

                while (left<right&&nums[left]+nums[right]>target){
                    right--;
                }

                //排序后 找不到满足 a+b+c的 那么后续也找不到了，所以这里不用再往后找了
                if (left==right){
                    break;
                }

                if (nums[left]+nums[right]==target){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                }
            }
        }
        return list;

    }
}
