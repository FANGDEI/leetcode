package top.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-27-12:00
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
@SuppressWarnings("all")
public class L59螺旋矩阵II {
    public static void main(String[] args) {
        new L59螺旋矩阵II().generateMatrix01(3);
    }

    /**
     * 模拟 螺旋填入数据
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1, index = 1;

        while (index <= n * n) {
            for (int i = left; i <= right; i++) {
                //由左到右填
                ans[up][i] = index++;
            }
            //填了一层 所以up向下一阶
            up++;
            for (int i = up; i <= down; i++) {
                //由上到下填
                ans[i][right] = index++;
            }
            //填了一竖列 所以right像左移动一阶
            right--;
            for (int i = right; i >= left; i--) {
                //由右到左填
                ans[down][i] = index++;
            }
            //填了最后一层 所以down向上移动一阶
            down--;
            for (int i = down; i >= up; i--) {
                //由下到上填
                ans[i][left] = index++;
            }
            //填了左一竖列 所以left向右移动一些
            left++;

            //这就完成了一个螺旋 如此重复知道填到n*n为止
        }
        return ans;
    }


    public int[][] generateMatrix01(int n) {
        int loop = 0; //控制循环次数
        int[][] res = new int[n][n];
        int start = 0; //每次循环起始点
        int count = 1; //填充数字
        int i, j; //下标

        while (loop++ < n / 2) {
            //模拟上侧从左闭到右开区间
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            //模拟右侧从上闭到下开区间
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            //模拟下侧闭区间到左开区间
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            //模拟左侧从下闭到上开区间
            for (; i>=loop;i--){
                res[i][j] = count++;
            }
            System.out.println(i+":"+j);
            start++;//一圈后 起始位置加1

        }

        //判断n为奇数的情况 中间会留下一个位置 需要我们单独填入
        if (n%2 == 1){
            res[start][start] = count;
        }

        return res;

    }
}
