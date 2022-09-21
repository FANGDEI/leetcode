package com.feng.newline.datastructure;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L1395统计作战单位数
 * @author: Ladidol
 * @description: n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 * 示例 1：
 * <p>
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 * 示例 2：
 * <p>
 * 输入：rating = [2,1,3]
 * 输出：0
 * 解释：根据题目条件，我们无法组建作战单位。
 * 示例 3：
 * <p>
 * 输入：rating = [1,2,3,4]
 * 输出：4
 * 提示：
 * <p>
 * n == rating.length
 * 3 <= n <= 1000
 * 1 <= rating[i] <= 10^5
 * rating 中的元素都是唯一的
 * @date: 2022/9/17 23:33
 * @version: 1.0
 */
public class L1395统计作战单位数 {
    // 树状数组标准题，这里我先用dp来做一下。

    // dp 我超我看球不懂这个dp
    class Solution3 {
        // dp1[i][j]：考虑前i个元素，
        public int numTeams(int[] rating) {
            return 0;
        }
    }

    // 树状数组（枚举中点）这题中的「抵消计数」把我弄麻了。
    class Solution {
        // 提示：通过枚举中点，这里需要知道乱序中的rating[i]的
        // 左边小于自己的，右边比自己大的；
        // 右边小于自己的，左边比自己大的；
        // 再通过乘法原理：得到以rating[i]为中点的情况有几种。


        //抵消计数：最开始right[]包含0号位右边的全部东西，所以先初始化right
        //在从左往右遍历的过程中：right[]依次是去遍历过的元素，left依次得到遍历过的元素。
        public int numTeams(int[] rating) {
            left = new int[n];
            right = new int[n];
            for (int shu : rating) {//初始化right数组
                add(right, shu, 1);//shu一定不会是1，所以不用加一；
            }

            int ans = 0;
            for (int i = 0; i < rating.length; i++) {
                int cur = rating[i];//当前遍历到的数值。

                add(right, cur, -1);// 不包含当前元素；0-（i-1）和（i+1）-（length-1）
                ans += query(left, cur - 1) * (query(right, n - 1) - query(right, cur));// 递增：左小右大；
                ans += (query(left, n - 1) - query(left, cur)) * query(right, cur - 1);// 递增：左大右小；
                add(left, cur, 1);
            }
            return ans;


        }


        int n = 100005;//数组大小，这里就需要自定义了！
        // 树状数组
//        int[] tree = new int[n];
        // 修改后的数组存放
        int[] left;
        int[] right;


        /**
         * 计算lowBit
         */
        int lowbit(int x) {
            return x & -x;
        }

        /**
         * 查询树状数组
         */
        int query(int[] tree, int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                ans += tree[i];
            }
            return ans;
        }

        /**
         * 在x = index+1处加入 add 差值。(如果index取不到0，就可以直接x = index)
         */
        void add(int[] tree, int x, int u) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tree[i] += u;
            }
        }
    }


}
