package top.dyw.leetcode.simple.arrays;

/**
 * @author Devildyw
 * @date 2023/12/22 20:01
 **/
@SuppressWarnings("all")
public class L1822数组元素积的符号 {

    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        /**
         * 其实关键就在于数组中是否有0 如果有0那么乘积一定是0
         * 其次是数组中的负数的个数 如果是偶数个那么乘积一定正数
         */
        int countNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                countNegative++;
            }else if (nums[i]==0){
                return 0;
            }
        }

        return countNegative%2==0?1:-1;
    }
}
