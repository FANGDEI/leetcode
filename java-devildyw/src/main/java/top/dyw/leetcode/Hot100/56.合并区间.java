/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->{
            return a[0] - b[0];
        });
        
        List<int[]> result = new ArrayList<>();
        int left = intervals[0][0];
        int rightMax = intervals[0][1];
        for (int i=0; i<intervals.length; i++) {
            if (rightMax >= intervals[i][0]) {
                rightMax = Math.max(rightMax, intervals[i][1]);
            } else {
                result.add(new int[]{left, rightMax});
                left=intervals[i][0];
                rightMax=intervals[i][1];
            }
        }

        result.add(new int[]{left, rightMax});


        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

