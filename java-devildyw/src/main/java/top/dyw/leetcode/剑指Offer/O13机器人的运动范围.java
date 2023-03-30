package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/30 21:30
 **/
@SuppressWarnings("all")
public class O13机器人的运动范围 {

    public static void main(String[] args) {
        System.out.println(new O13机器人的运动范围().movingCount(2,3,1));
    }

    /**
     * 回溯
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited,m,n,k,0,0);
    }

    private int dfs(boolean[][] visited, int m, int n, int k, int i, int j) {
        if (i>=m||j>=n||visited[i][j]||bitSum(i)+bitSum(j)>k) return 0;
        visited[i][j] = true;
        return 1+dfs(visited,m,n,k,i+1,j) +  dfs(visited,m,n,k,i,j+1);
    }

    private int bitSum(int n) {
        int sum = 0;
        while (n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }


}
