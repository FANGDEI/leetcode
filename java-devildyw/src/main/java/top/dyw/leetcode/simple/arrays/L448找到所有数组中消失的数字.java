package top.dyw.leetcode.simple.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Devil
 * @date 2022-05-16-19:47
 * <p>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
@SuppressWarnings("all")
public class L448找到所有数组中消失的数字 {
    public static void main(String[] args) {
        new L448找到所有数组中消失的数字().findDisappearedNumbers01(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        int length = nums.length;

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            integers.add(nums[i]);
        }

        for (int i = 1; i <= length; i++) {
            if (!integers.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers01(int[] nums) {
        int n = nums.length;
        //通过自定义的一个hash算法 对应元素-1取模得到的下标的元素然后对其加上n
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //这里遍历途中 如果有下标对应的元素是小于n的 说明它不存在 因为如果存在的话那么 一定会被上述hash算法计算 并且对应值一定会大于n
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
