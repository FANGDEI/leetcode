package top.dyw.leetcode.simple.arrays;

import java.util.Arrays;

/**
 * @author Devil
 * @date 2022-04-30-13:27
 * <p>
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊n/2⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
@SuppressWarnings("all")
public class L169多数元素 {
    public static void main(String[] args) {
        int i = new L169多数元素().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        //排序 然后取length/2处的值返回
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //法二: 哈希表

    public int majorityElement01(int[] nums) {
        Arrays.sort(nums);
        //只要出现次数超过半数 那么半数索引位置对应的元素一定是那个出现超过半数的元素
        return nums[nums.length / 2];
    }
}
