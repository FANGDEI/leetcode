package top.dyw.leetcode.Hot100;

public class L240搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 我们这里从右上角开始 因为往左就是减小 往下就是增加 只有两种选择（左下角也是同理） 其他位置我们都需要处理多种情况
        //这道题的核心就是 每一行都递增 甚至每一列也是递增的 但是每一行的最小值并不是比上一行的最大值大 所以这里没办法用一维二分了
        // 正确解法：“Z字形”查找 (Staircase Search)
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) { // 如果大于了 那么当前列下面的元素也一定大于 所以只能向右移动才能逼近结果 每次只移动一步
                //向右移动
                col--;
            } else { //小于 向下移动
                row++;
            }
        }
        return false;
    }
}
