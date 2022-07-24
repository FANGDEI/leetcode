package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1184公交站间的距离_前缀和
 * @author: Ladidol
 * @description:
 * @date: 2022/7/24 17:22
 * @version: 1.0
 */
public class L1184公交站间的距离_前缀和 {

    //前缀和
    class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            //虽说是个环形，但是依旧可以用前缀和来做。
            int[] preSum = new int[distance.length + 1];
            int allSum  = 0;
            for (int i = 1; i <= distance.length; i++) {
                preSum[i] = preSum[i-1] + distance[i-1];
                allSum += distance[i-1];
            }
            int ans = Math.abs(preSum[destination] - preSum[start]);//保证一定时大的减小的。
            return Math.min(ans,allSum-ans);//取最小值
        }
    }
}
