package com.feng.newline.dp.path;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.path
 * @className: L1575统计所有可行路径
 * @author: Ladidol
 * @description: 给你一个 互不相同的整数数组，其中locations[i]表示第i个城市的位置。同时给你start，finish和fuel分别表示出发城市、目的地城市和你初始拥有的汽油总量
 * 每一步中，如果你在城市 i，你可以选择任意一个城市 j，满足 j != i且0 <= j < locations.length，并移动到城市j。
 * 从城市i移动到j消耗的汽油量为|locations[i] - locations[j]|，|x|表示x的绝对值。
 * 请注意，fuel任何时刻都不能为负，且你可以经过任意城市超过一次（包括start和finish）。
 * 请你返回从start到finish所有可能路径的数目。
 * 由于答案可能很大， 请将它对10^9 + 7取余后返回。
 * 示例 1：
 * <p>
 * 输入：locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
 * 输出：4
 * 解释：以下为所有可能路径，每一条都用了 5 单位的汽油：
 * 1 -> 3
 * 1 -> 2 -> 3
 * 1 -> 4 -> 3
 * 1 -> 4 -> 2 -> 3
 * 示例 2：
 * <p>
 * 输入：locations = [4,3,1], start = 1, finish = 0, fuel = 6
 * 输出：5
 * 解释：以下为所有可能的路径：
 * 1 -> 0，使用汽油量为 fuel = 1
 * 1 -> 2 -> 0，使用汽油量为 fuel = 5
 * 1 -> 2 -> 1 -> 0，使用汽油量为 fuel = 5
 * 1 -> 0 -> 1 -> 0，使用汽油量为 fuel = 3
 * 1 -> 0 -> 1 -> 0 -> 1 -> 0，使用汽油量为 fuel = 5
 * 示例 3：
 * <p>
 * 输入：locations = [5,2,1], start = 0, finish = 2, fuel = 3
 * 输出：0
 * 解释：没有办法只用 3 单位的汽油从 0 到达 2 。因为最短路径需要 4 单位的汽油。
 * 提示：
 * <p>
 * 2 <= locations.length <= 100
 * 1 <= locations[i] <= 109
 * 所有locations中的整数 互不相同。
 * 0 <= start, finish < locations.length
 * 1 <= fuel <= 200
 * @date: 2022/8/25 22:25
 * @version: 1.0
 */
public class L1575统计所有可行路径 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 8, 4};
//        System.out.println(new Solution().countRoutes(nums, 1, 3, 5));
    }

    //记忆化搜索（优化前）
    class Solution1 {
        // 缓存器：用于记录「特定状态」下的结果
        // cache[i][fuel] 代表从位置 i 出发，当前剩余的油量为 fuel 的前提下，到达目标位置的「路径数量」
        int mod = 1000000007;
        int[][] cache;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            //通过dfs
            //我们知道，如果要实现 DFS 的话，通常有以下几个步骤：
            //1.设计好递归函数的「入参」和「出参」
            //2.设置好递归函数的出口（Base Case）（基线条件）
            //3.编写「最小单元」处理逻辑

            //记忆化搜索：！！！！！
            //dfs一般数据量少于30，对于本题，可以使用记忆化搜索。
            cache = new int[locations.length][fuel + 1];
            for (int[] ints : cache) {
                Arrays.fill(ints, -1);
            }
            int res = dfs(locations, start, finish, fuel);
            return res;

        }

        int dfs(int[] location, int cur, int end, int fuel) {
            // 缓存器的作用到了
            // 如果缓存器中已经有答案，直接返回
            if (cache[cur][fuel] != -1) {
                return cache[cur][fuel];
            }

            int n = location.length;

            // 2）设置递归函数出口
            // base case 1：如果油量为 0，且不在目标位置
            // 将结果 0 写入缓存器并返回
            if (fuel == 0 && cur != end) {
                cache[cur][fuel] = 0;
                return 0;
            }

            // base case 2：油量不为 0，且无法到达除本身外的任何位置
            // 将结果 0 写入缓存器并返回
            boolean hasNext = false;
            for (int i = 0; i < n; i++) {
                if (i != cur) {
                    int cha = Math.abs(location[i] - location[cur]);
                    if (fuel >= cha) {
                        hasNext = true;
                        break;
                    }
                }
            }
            if (!hasNext && fuel != 0) {//这里还合并了一个可能：已经到终点（ cur==end ）的情况。
                return cache[cur][fuel] = cur == end ? 1 : 0;
            }

            // 3）最小单元处理逻辑
            // 计算油量为 fuel，从位置 cur 到 end 的路径数量
            // 由于每个点都可以经过多次，如果 cur = end，那么本身就算一条路径
            int sum = cur == end ? 1 : 0;
            for (int i = 0; i < n; i++) {
                //cur到其他位置
                if (cur != i) {
                    int cha = Math.abs(location[i] - location[cur]);
                    if (fuel >= cha) {//可到达
                        sum += dfs(location, i, end, fuel - cha);//回溯
                        sum %= mod;//取模操作。
                    }
                }
            }

            cache[cur][fuel] = sum;
            return sum;
        }
    }

    //记忆化搜索（优化后），思考一下可以发现，base case 2 就可以在这里优化成下面这样，就不用了单独抽出来。
    class Solution2 {
        int mod = 1000000007;
        int[][] cache;

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            cache = new int[locations.length][fuel + 1];
            for (int[] ints : cache) {
                Arrays.fill(ints, -1);
            }
            int res = dfs(locations, start, finish, fuel);
            return res;

        }

        int dfs(int[] location, int cur, int end, int fuel) {

            if (cache[cur][fuel] != -1) {
                return cache[cur][fuel];
            }

            int n = location.length;
            if (fuel == 0 && cur != end) {
                cache[cur][fuel] = 0;
                return 0;
            }
            // base case 2：如果一步到达不了，说明从位置 u 不能到达 end 位置
            // 将结果 0 写入缓存器并返回
            int cha = Math.abs(location[end] - location[cur]);
            if (cha > fuel) {
                cache[cur][fuel] = 0;
                return 0;
            }
            int sum = cur == end ? 1 : 0;
            for (int i = 0; i < n; i++) {
                if (cur != i) {
                    cha = Math.abs(location[i] - location[cur]);
                    if (fuel >= cha) {
                        sum += dfs(location, i, end, fuel - cha);
                        sum %= mod;
                    }
                }
            }

            cache[cur][fuel] = sum;
            return sum;
        }
    }

    //dp
    class Solution {
        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            int mod = 1000000007;
            int[][] dp = new int[locations.length][fuel + 1];

            //对于本身就在目的地的的
            for (int i = 0; i <= fuel; i++) {
                dp[finish][i] = 1;
            }

            // 从状态转移方程可以发现 dp[i][fuel]=dp[i][fuel]+dp[k][fuel-need]
            // 在计算 dp[i][fuel] 的时候依赖于 dp[k][fuel-need]
            // 其中 i 和 k 并无严格的大小关系
            // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
            // 因此需要先从小到大枚举油量
            for (int curFuel = 0; curFuel <= fuel; curFuel++) {
                for (int curIndex = 0; curIndex < locations.length; curIndex++) {
                    for (int k = 0; k < locations.length; k++) {
                        if (k != curIndex) {//不能原地跳。
                            int cha = Math.abs(locations[curIndex] - locations[k]);
                            if (curFuel >= cha) {//不合法越界
                                dp[curIndex][curFuel] += dp[k][curFuel - cha];
                                dp[curIndex][curFuel] %= mod;
                            }
                        }

                    }
                }
            }
            return dp[start][fuel];
        }
    }
}


