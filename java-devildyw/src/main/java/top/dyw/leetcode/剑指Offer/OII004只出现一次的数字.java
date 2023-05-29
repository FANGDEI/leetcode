package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/29 20:54
 **/
@SuppressWarnings("all")
public class OII004只出现一次的数字 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSum[i] += num&1;
                num>>>=1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bitSum[i]%3!=0){
                res|=(1<<i);
            }
        }
        return res;
    }
}
