package top.dyw.leetcode.Hot100;

public class L75颜色分类 {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length-1;
        int cur = 0;

        while (cur <= p2) {
            if (nums[cur] == 0) {
                // p0所处位置一定是1
                // cur 指针从左向右移动
                swap(nums, cur, p0);
                p0++;
                cur++;
            } else if (nums[cur]==2) {
                // 但是p2所处位置不一定是1 还可能是0 所以cur不能移动
                swap(nums, cur, p2);
                p2--;
            } else {
                // 如果是1 那么不用管 因为我们默认了分布为 0 1 2
                cur++;
            }
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
