package com.feng.面试题.句子互动;

import java.util.Arrays;

public class HelloWorld {

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 4, 2};
    quickSort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }

  public static void quickSort(int[] nums, int left, int right) {
    if (left < right) {
      int index = partition(nums, left, right);
      quickSort(nums, index + 1, right);
      quickSort(nums, left, index - 1);
    }
  }

  // 获取分割点
  static int partition(int[] nums, int left, int right) {
    int pivot = nums[left];
    int n = nums.length;
    int i = left;
    int j = right;
    while (i < j) {
      while (i < j && pivot < nums[j]) {
        j--;
      }
      nums[i] = nums[j];
      while (i < j && pivot > nums[i]) {
        i++;
      }
      nums[j] = nums[i];
    }
    nums[i] = pivot;
    return i;
  }
}