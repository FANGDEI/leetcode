package com.feng.newline.dp;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/10/10 9:52
 * @description: 我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
 * 数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
 * 注意：
 * <p>
 * 用例保证可以实现操作。
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 * 示例 2:
 * <p>
 * 输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
 * 输出: 1
 * 提示:
 * <p>
 * 2 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 2 * 105
 */
public class L801使序列递增的最小交换次数 {


    //dp (错误理解，走不通)
    class Solution1 {
        /**
         * 参数：[nums1, nums2]
         * 返回值：int
         * 作者： ladidol
         * 描述：dp[i][j]：只考虑nums1[i-1]和nums2[j-1]以前的数字，最少需要交换多少次数使其变成递增序列。
         * 可以交换当前值：不符合递增但是可以交换
         * 不交换当前值：符合递增都
         */
        public int minSwap(int[] nums1, int[] nums2) {
            int n = nums1.length, m = nums2.length;
            int[][] dp = new int[n + 1][m + 1];

            //默认第一位不交换。
            dp[1][1] = 0;
            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= n; j++) {
                    if (nums1[i - 1] > nums1[i - 2] && nums2[i - 1] > nums2[i - 2]) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }

            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }

            System.out.println("===============================================");
            int ans = dp[n][m];


            //假设第一个变了，分析后面的
            dp[1][1] = 1;
            int tmp = nums1[0];
            nums1[0] = nums2[0];
            nums2[0] = tmp;
            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= n; j++) {
                    if (nums1[i - 1] > nums1[i - 2] && nums2[i - 1] > nums2[i - 2]) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }


            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }

            ans = Math.min(dp[n][m], ans);
            return ans;
        }
    }


    //状态机dp
    class Solution {
        /**
         * 参数：[nums1, nums2]
         * 返回值：int
         * 作者： ladidol
         * 描述：其实你会发现，这题只会交换同一个位置，所以用一个i就能表示当前比较的位置，所以就不要变成二维，像上面变成二维的方式其实是错的。
         * 然后这里面有两个状态，就是换与不换用1和0表示第二维度。这里是阐释了前面题解出现了两次dp的主要原因。
         * dp[i][j]： 为考虑下标范围为 [0, i] 的元素，且位置 i 的交换状态为 j 时（其中 j = 0 为不交换，j = 1 为交换）两数组满足严格递增的最小交换次数。
         * 状态转移方程就是：Math.min(dp[i-1][0],dp[i-1][1]);
         *
         * 注意维护两种可能的全部状态。有时候既满足双边都递增，同时也满足交叉递增。
         *
         */
        public int minSwap(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[][] dp = new int[n][2];//这里就不用多开一个空间了。

            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i][1] = n + 1;
            }

            dp[0][0] = 0;
            dp[0][1] = 1;


            for (int i = 1; i < n; i++) {
                if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {//前后都没换的情况，或者前后都换。
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                }
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {//当前不满足递增情况，可以有替换当前值or前一个替换。
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
                }
            }
            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }


            return Math.min(dp[n - 1][0], dp[n - 1][1]);
        }
    }
}