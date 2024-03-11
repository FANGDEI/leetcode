package top.dyw.leetcode.simple.arrays;

/**
 * @author Devildyw
 * @date 2023/12/27 18:48
 **/
@SuppressWarnings("all")
public class L1672最富有客户的资产总量 {

    public static void main(String[] args) {

    }

    public int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;
        int n = accounts.length;

        for (int i = 0; i < n; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth+=accounts[i][j];
            }
            maximumWealth = Math.max(maximumWealth,wealth);
        }
        return maximumWealth;
    }

}
