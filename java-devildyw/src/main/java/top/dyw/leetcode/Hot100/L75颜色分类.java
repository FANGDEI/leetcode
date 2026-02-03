package top.dyw.leetcode.Hot100;

public class L75颜色分类 {
    public void sortColors(int[] nums) {
        // 两个指针
        int p0 = 0;
        int p2 = nums.length-1;
        int curr = 0;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, curr, p0);
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            } else {
                curr++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
