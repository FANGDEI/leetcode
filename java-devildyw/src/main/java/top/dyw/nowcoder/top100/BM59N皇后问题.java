package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-02-19-19:44
 */
@SuppressWarnings("all")
public class BM59N皇后问题 {

    public static void main(String[] args) {

    }

    //记录结果集
    int res = 0;
    public int Nqueen (int n) {

        // write code here
        //n皇后数组 用来记录第i号皇后的列号 queen[i] 表示第i个皇后所在第i列第queen[i]列位置
        int[] queen = new int[n]; //默认初始化为0

        backTracking(n,0,queen);

        return res;
    }

    /**
     * 为皇后找位置的方案
     * @param n
     * @param row
     * @param queen
     */
    private void backTracking(int n, int row, int[] queen) {
        if (row==n){ //代表n个皇后都找到自己的位置
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(queen,row,i)){
                //如果有效 就将第row号皇后放在第i列
                queen[row] = i;
                //回溯
                backTracking(n,row+1,queen);
            }
        }
    }

    /**
     * 判断是否有效 同一列 同一行（我们这种写法直接避免了相同的行的情况，所以这里不用判断） 同一斜线不能有相同的
     * @param queen
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(int[] queen, int row, int col) {
        //查找之前皇后的记录判断该位置是否可以放置新皇后
        for (int i = 0; i < row; i++) {
            if (row==i/*这个应该不用写*/||col == queen[i]/*判断是否同一行*/||Math.abs(row-i)==Math.abs(queen[i]-col)/*判断是否同一斜线*/){
                return false;
            }
        }
        return true;
    }
}
