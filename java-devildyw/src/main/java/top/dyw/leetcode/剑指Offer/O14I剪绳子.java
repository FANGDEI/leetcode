package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/14 20:08
 **/
@SuppressWarnings("all")
public class O14I剪绳子 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划
     */
    public int cuttingRope_dp(int n) {
        int[] dp = new int[n + 1]; // dp[i] 表示将正整数i拆分成了至少两个数之后对应的最大乘积
        //dp[0] dp[1] 因为 0 和 1 都是不能再拆分的数所以值为0

        //dp[i] 要么直接为 i直接拆成两个数的乘积(j*(i-j))，要么为i+1拆成多个数相乘 (i*dp[i-j]) 或者上两种情况都不如其原本的值大（dp[i]是会变化的）
        //因为上述分析过，0，1不能拆分所以这里从2开始
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //动态规划
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }

        return dp[n];
    }

    /**
     * 贪心算法 性能更好
     * 尽量将一个数拆成几个三相乘，这样的结果最大
     */
    public int cuttingRope_greedy(int n) {
        //如果小于等于三，拆只能拆成 1*1*1 或者 1*2，所以结果为 n-1
        if (n <= 3) {
            return n - 1;
        }

        //a计算n可以拆成多少的3 b则代表n拆成多个3后剩下的数
        int a = n / 3, b = n % 3;
        if (b == 0) { //余0 刚好分够
            return (int)Math.pow(3, a);
        } else if (b == 1) { //余1 乘4总比乘3*1 大吧
            return (int)Math.pow(3, a - 1) * 4;
        } else { //余2没什么好说的 *2即可
            return (int)Math.pow(3, a) * 2;
        }
    }


    /**
     * dp
     * @param n
     * @return
     */
    public int cuttingRope_dp01(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        //dp[i] 表示i所拆分成的数乘积的最大值 j*(i-j) 表示将i拆成了i和i-j, j*dp[i-j] (dp[i-j](i-j)表示拆分成数乘积最大值)与j的乘积
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}

