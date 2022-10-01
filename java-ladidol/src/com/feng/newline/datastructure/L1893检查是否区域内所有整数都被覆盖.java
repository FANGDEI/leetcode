package com.feng.newline.datastructure;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L1893检查是否区域内所有整数都被覆盖
 * @author: Ladidol
 * @description: 给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [starti, endi]表示一个从starti到 endi 的 闭区间 。
 * 如果闭区间[left, right]内每个整数都被ranges 中 至少一个 区间覆盖，那么请你返回true，否则返回false。
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 * 示例 1：
 * <p>
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * 示例 2：
 * <p>
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * 通过次数37,020提交次数62,603
 * @date: 2022/9/19 23:44
 * @version: 1.0
 */
public class L1893检查是否区域内所有整数都被覆盖 {
    class Solution1 {
        //其实直接暴力就行：判断是不是每一个整数都能满足条件。
        public boolean isCovered(int[][] rs, int l, int r) {
            for (int i = l; i <= r; i++) {
                boolean flag = false;//默认没有一个。
                //只要至少一个区间囊括i就可以。
                for (int[] ints : rs) {
                    if (i >= ints[0] && i <= ints[1]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
            }
            return true;
        }
    }


    // 树状数组
    // 基本思想都是使用 range[0,b] 的计数情况减去 range[0, a-1] 的计数情况来得出 [a, b] 的计数情况。
    // 回到本题，由于数据范围很小，只有 5050，我们可以使用「树状数组」进行求解：
    // void add(int x, int u)：对于数值 xx 出现次数进行 +u 操作；
    // int query(int x)：查询某个满足 <= x 的数值的个数。
    // 那么显然，如果我们需要查询一个数值 x 是否出现过，可以通过查询 cnt = query(x) - query(x - 1) 来得知。

    class Solution {


        public boolean isCovered(int[][] ranges, int left, int right) {
            for (int[] range : ranges) {
                int l = range[0], r = range[1];
                for (int i = l; i <= r; i++) {
                    add(i, 1);//i不会取到0值
                }
            }

            for (int i = left; i <= right; i++) {
                int cnt = query(i) - query(i - 1);
                if (cnt == 0) return false;//没在树状数组中找到。
            }
            return true;
        }


        // 树状数组
        int n = 55;
        int[] tree = new int[n];


        /**
         * 计算lowBit
         */
        int lowbit(int x) {
            return x & -x;
        }

        /**
         * 查询树状数组
         */
        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                ans += tree[i];
            }
            return ans;
        }

        /**
         * 在x = index+1处加入 add 差值。
         */
        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tree[i] += u;
            }
        }

    }


}
