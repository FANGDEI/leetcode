package top.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-01-11:45
 */
@SuppressWarnings("all")
public class O11旋转数组的最小数字 {

    public static void main(String[] args) {
        System.out.println(new O11旋转数组的最小数字().minArray01(new int[]{3, 4, 5, 1, 2}));
    }

    /**
     * 暴力
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            min = Math.min(min,numbers[i]);
        }
        return min;
    }

    /**
     * 二分法
     * @param numbers
     * @return
     */
    public int minArray01(int[] numbers) {
        int n = numbers.length;
        int left = 0, right = n-1;

        //因为是有序数组进行了旋转 那么旋转后分为的两个区间也一定是分别有序的
        while (left<=right){
            int mid = left+(right-left)/2;
            //如果nums[mid]<nums[right] 因为区间有序，所以最小值一定在左区间所以 right=mid
            if (numbers[mid]<numbers[right]){
                right = mid;
                //如果nums[mid]>nums[right] 因为区间有序 并且两个区间也是有大小关系 所以最小值一定在右区间 left = mid+1 并且最小值不可能是mid所在的位置（因为mid已经比别人大了）
            }else if (numbers[mid]>numbers[right]){
                left = mid+1;
            }else{//如果nums[mid] == nums[right] 有可能是当前right为最终结果，但也有可能是数组中有重复的值，有因为是有序递增的，所以最小值在右边，这里就通过right来逼近
                //因为有可能最小值就在mid和right的中间，是一个凹下去的区间.
                right--;
            }
        }
        return numbers[left];
    }

    public int minArray02(int[] numbers) {
        if (numbers == null||numbers.length==0){
            return -1;
        }

        int left = 0, right = numbers.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (numbers[mid]<numbers[right]){
                right = mid;
            }else if (numbers[mid]>numbers[right]){
                left = mid+1;
            }else{
                right--;
            }
        }
        return numbers[left];
    }
}
