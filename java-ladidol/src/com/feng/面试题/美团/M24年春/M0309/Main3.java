package com.feng.面试题.美团.M24年春.M0309;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小美拿到了一个n*n的矩阵，其中每个元素是 0 或者 1。
 * 小美认为一个矩形区域是完美的，当且仅当该区域内 0 的数量恰好等于 1 的数量。
 * 现在，小美希望你回答有多少个i*i的完美矩形区域。你需要回答1 <= i <= n的所有答案。
 * <p>
 * arr = [1, 0, 1, 0]
 * arr = [0, 1, 0, 1]
 * arr = [1, 1, 0, 0]
 * arr = [0, 0, 1, 1]
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = scan.nextInt();
        char[][] arr = new char[n][n];
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLine().toCharArray();
        }
        //奇数 为零
        //构造前缀和
        int[][] preSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + (arr[i - 1][j - 1] - '0');
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.println(0);
            } else {
                //从右下角的矩形开始便利
                int target = i * i;
                System.out.println("target = " + target);
                for (int j = i; j <= n; j++) {
                    int tmp = 0;
                    for (int k = i; k <= n; k++) {
                        if (j == i && k == i) {
                            tmp = preSum[j][k];
                        } else if (j == i) {
                            tmp = preSum[j][k] - preSum[j][k - i];
                        } else if (k == i) {
                            tmp = preSum[j][k] - preSum[j - i][k];
                        } else {
                            tmp = preSum[j][k] - preSum[j][k - i] - preSum[j - i][k] + preSum[j - i][k - i];
                        }
                        if (tmp * 2 == target) {
                            ans++;
                        }
                    }
                }
                System.out.println(ans);
                ans=0;
            }
        }


    }

}
