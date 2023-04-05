package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/20 20:01
 **/

@SuppressWarnings("all")
public class O21调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {

    }

    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];

        int ji = 0, ou = nums.length-1;
        for (int num : nums) {
            if (num%2!=0){
                res[ou--] = num;
            }else{
                res[ji++] = num;
            }
        }
        return res;
    }
}
