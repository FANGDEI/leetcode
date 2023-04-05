package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-12-01-13:54
 */
@SuppressWarnings("all")
public class L1779找到最近的有相同X或Y坐标的点 {

    public static void main(String[] args) {
        System.out.println(new L1779找到最近的有相同X或Y坐标的点().nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDis = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0]==x||points[i][1]==y){
                int distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (minDis>distance){
                    minDis = distance;
                    minIdx = i;
                } else if (minDis==distance&&minIdx>i){
                    minIdx = i;
                }

            }
        }
        return minDis==Integer.MAX_VALUE?-1:minIdx;
    }
}
