package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1109航班预订统计
 * @author: Ladidol
 * @description: 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * @date: 2022/7/25 10:37
 * @version: 1.0
 */
public class L1109航班预订统计 {

    class Solution1 {
        //注意本题是从1开始编号到n的.
        //对 c[l] += vc[l]+=v：由于差分是前缀和的逆向过程，这个操作对于将来的查询而言，带来的影响是对于所有的下标大于等于 ll 的位置都增加了值 vv；
        //对 c[r + 1] -= vc[r+1]−=v：由于我们期望只对 [l, r][l,r] 产生影响，因此需要对下标大于 rr 的位置进行减值操作，从而抵消“影响”。

        int[] chaFen;//记住这里是前缀和逆运算, 他不是preSum

        public int[] corpFlightBookings(int[][] bookings, int n) {
            chaFen = new int[n + 2];
            for (int[] booking : bookings) {
                chaFen[booking[0]] += booking[2];//对当前差分进行增加
                chaFen[booking[1] + 1] -= booking[2];//对下一个差分进行恢复.
            }
            int[] ans = new int[n];
            ans[0] = chaFen[1];//对第一个数进行赋值.
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] + chaFen[i + 1];
            }
            return ans;
        }
    }

    //你会发现这里面的chaFen第一个数是没有用上的.我们可以优化一下.
    class Solution {
        //注意本题是从1开始编号到n的.
        //对 c[l] += vc[l]+=v：由于差分是前缀和的逆向过程，这个操作对于将来的查询而言，带来的影响是对于所有的下标大于等于 ll 的位置都增加了值 vv；
        //对 c[r + 1] -= vc[r+1]−=v：由于我们期望只对 [l, r][l,r] 产生影响，因此需要对下标大于 rr 的位置进行减值操作，从而抵消“影响”。
        int[] chaFen;//记住这里是前缀和逆运算, 他不是preSum

        public int[] corpFlightBookings(int[][] bookings, int n) {
            chaFen = new int[n + 1];
            for (int[] booking : bookings) {
                chaFen[booking[0] - 1] += booking[2];//对当前差分进行增加
                chaFen[booking[1]] -= booking[2];//对下一个差分进行恢复.
            }
            int[] ans = new int[n];
            ans[0] = chaFen[0];//对第一个数进行赋值.
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] + chaFen[i];
            }
            return ans;
        }
    }

}
