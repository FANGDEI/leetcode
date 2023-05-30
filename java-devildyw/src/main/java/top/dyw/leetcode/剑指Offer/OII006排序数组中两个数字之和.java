package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/29 21:05
 **/
@SuppressWarnings("all")
public class OII006排序数组中两个数字之和 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        //双指针
        int left = 0, right = numbers.length-1;
        while (left<=right){
            int result = numbers[left]+numbers[right];
            if (result>target){
                right--;
            } else if (result<target){
                left++;
            } else {
                return new int[]{left,right};
            }
        }
        return new int[]{};
    }
}
