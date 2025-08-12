
package com.feng.面试题.与爱为舞;


import java.util.Arrays;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/12 15:28
 */
public class Main {

  public static void main(String[] args) {

    // 向右k个移动1,2,3,4,5,6,7
    // 6,7  1,2,3,4,5
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 2;
    rotate(nums, k);
    System.out.println("nums = " + Arrays.toString(nums));
  }

  static void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }

  /**
   * 翻转指定区域的数组
   *
   * @param nums
   * @param start
   * @param end
   */
  static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      // 向内靠
      start++;
      end--;
    }
  }
}
