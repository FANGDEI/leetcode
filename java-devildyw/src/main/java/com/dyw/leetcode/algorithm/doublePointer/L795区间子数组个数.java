package com.dyw.leetcode.algorithm.doublePointer;

/**
 * @author Devil
 * @since 2022-11-24-15:42
 */
@SuppressWarnings("all")
public class L795区间子数组个数 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int sum = 0;
        //用于记录在遍历的过程中第一个满足 left<=nums[i]<=right 也是该区间的子数组所必须要包含的节点
        int last1 = -1;
        //用于记录上一个不能被包含的节点
        int last2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last1 = -1;
                last2 = i;
            }
            /**
             * 上一个不能包含的下标为 last2，等价于上一个可以包含的下标为 last2+1，这是子数组左端点的最小值。
             */
            if (last1 != -1) {
                /**
                 * 如果当前last1 不为-1 即在该遍历过程中找到了第一个满足条件的 left<=nums[i]<=right 此时记录子数组 因为子数组必须要包含 nums[i] 所以 [last2+1,last1],[last2+2,last1]...[last2,last2] 都是满足条件的 这有last1-last2个
                 */
                sum += last1 - last2;
            }
        }
        return sum;
    }

    public int numSubarrayBoundedMax01(int[] nums, int left, int right) {
        int ans = 0, last1 = -1, last2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=right&&nums[i]>=left){
                last1 = i;
            }else if (nums[i]>right){
                last1 = -1;
                last2 = i;
            }
            if (last1!=-1){
                ans += last1-last2;
            }
        }
        return ans;
    }
}
