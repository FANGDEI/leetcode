package com.feng.draft.template.rangesum;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template.rangesum
 * @className: presum
 * @author: Ladidol
 * @description: 前缀和
 * @date: 2022/7/24 18:23
 * @version: 1.0
 */

public class preSumTemplate {

    class preSum一维 {

        int[] preSum;//前缀和数组
        int[] nums;
        int n = nums.length;
        int i,j;
        int ans;

        /*============一维前缀和模板==============*/
        // 预处理前缀和数组
        {
            preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // 计算 [i, j] 结果
        {
            i++; j++;
            ans = preSum[j] - preSum[i - 1];
        }
    }


    class preSum二维{

        int[][] preSum;//前缀和数组
        int[][] matrix;
        int n,m;
        int x1,x2,y1,y2;
        int ans;

        /*============二维前缀和模板==============*/
        // 预处理前缀和数组
        {
            preSum = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // 当前格子(和) = 上方的格子(和) + 左边的格子(和) - 左上角的格子(和) + 当前格子(值)【和是指对应的前缀和，值是指原数组中的值】
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        // 首先我们要令左上角为 (x1, y1) 右下角为 (x2, y2)
        // 计算 (x1, y1, x2, y2) 的结果
        {
            // 前缀和是从 1 开始，原数组是从 0 开始，上来先将原数组坐标全部 +1，转换为前缀和坐标
            x1++; y1++; x2++; y2++;
            // 记作 22 - 12 - 21 + 11，然后 不减，减第一位，减第二位，减两位
            // 也可以记作 22 - 12(x - 1) - 21(y - 1) + 11(x y 都 - 1)
            ans = preSum[x2][y2] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1] + preSum[x1 - 1][y1 - 1];
        }
    }
}




