package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/27 18:37
 **/
@SuppressWarnings("all")
public class OII003前n个数字二进制中1的个数 {

    public static void main(String[] args) {
        int[] ints = new OII003前n个数字二进制中1的个数().countBits(5);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }

    }

    /**
     * dp
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            //状态转义方程
            dp[i] = dp[i>>1] + (i&1); //根据i>>1时的1的个数推出i时1的个数
        }
        return dp;
    }
}
