import java.util.Arrays;

public class L62不同路径 {
//class Solution {
//    public int uniquePaths(int m, int n) {
//        return process(0,0);
//    }
//    public int process(int M,int N,int m,int n){
//        int ans=0;
//        if(M>=m||N>=n){
//            return 0;
//        }
//        if(M==m-1&&N==n-1){
//            return 1;
//        }else{
//            ans+=process(M+1,N,m,n);
//            ans+=process(M,N+1,m,n);
//        }
//        return ans;
//    }
//}


    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] ans = new int[m][n];
            ans[0][0] = 0;
            Arrays.fill(ans[0], 1);
            for (int i = 0; i < m; i++) {
                ans[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                }
            }
            return ans[m-1][n-1];
        }

    }
}
