package top.dyw.write_exam.pdd;

import java.util.ArrayList;
import java.util.List;

public class P1完全平方数最少组合 {
    public static void main(String[] args) {
        System.out.println(getMinSquaresList(12));
    }

    public static List<Integer> getMinSquaresList(int n) {
        if (n<=0) {
            return new ArrayList<>();
        }

        int[] dp = new int[n+1];
        int[] prev = new int[n+1];

        for (int i=1; i<=n; i++) {
            dp[i] = i;

            for(int j=1; j*j<=i; j++) {
                if (dp[i-j*j] + 1< dp[i]) {
                    dp[i] = dp[i-j*j] + 1;
                    prev[i] = j*j;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int cur = n;
        while (cur > 0) {
            result.add(prev[cur]);
            cur -= prev[cur];
        }

        return result;
    }

}
