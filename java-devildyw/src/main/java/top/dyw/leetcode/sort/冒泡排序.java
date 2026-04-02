package top.dyw.leetcode.sort;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] nums = {5, 3, 8, 4, 2};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
