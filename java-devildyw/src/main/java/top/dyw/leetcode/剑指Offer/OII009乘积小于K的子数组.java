package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/31 19:41
 **/
@SuppressWarnings("all")
public class OII009乘积小于K的子数组 {

    public static void main(String[] args) {
        System.out.println(new OII009乘积小于K的子数组().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int multiply = 1;
        int left = 0;
        int result = 0;
        for (int right = 0; right < nums.length; right++) {
            multiply*=nums[right];

            //这里left<=right 是为了防止nums[right]大于k的情况 使得left和right重合甚至left>right 从而导致multiply=0 从而导致result+=0 从而导致结果错误（对后续结果也是错误） 例如nums=[1,2,3] k=0
            while (left<=right&&multiply>=k){
                multiply/=nums[left++];
            }
            //这里right-left+1是因为right-left+1是以right为结尾的子数组的个数 [1,2,3] 以3为结尾的子数组有[3],[2,3],[1,2,3] 一共3个
            result+=right-left+1;
        }
        return result;
    }
}
