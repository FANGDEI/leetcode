package top.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-03-15:25
 */
@SuppressWarnings("all")
public class O53I在排序数组中查找数字I {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                count++;
            }
        }
        return count;
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int search01(int[] nums,int target){
        int leftIndex = binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false) - 1;
        if (leftIndex<=rightIndex&&rightIndex<nums.length&&nums[leftIndex]==target&&nums[rightIndex]==target){
            return rightIndex-leftIndex+1;
        }
        return 0;

    }

    /**
     * 二分查找找到target在数组中第一次/最后一次出现的位置
     * @param nums 数组
     * @param target 目标
     * @param flag true标识是第一次出现的位置/ false 最后一次出现的位置
     * @return
     */
    private int binarySearch(int[] nums, int target, boolean flag) {
        int low = 0, high = nums.length-1, ans = nums.length;
        while (low<=high){
            int mid = (high-low)/2 + low;
            if (nums[mid]>target||(flag&&nums[mid]>=target)){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
