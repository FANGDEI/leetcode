package top.dyw.leetcode.simple.arrays;

import java.util.HashSet;

/**
 * @author Devildyw
 * @date 2023/12/26 12:23
 **/
@SuppressWarnings("all")
public class L1275找出井字棋的获胜者 {

    public static void main(String[] args) {
        System.out.println(new L1275找出井字棋的获胜者().tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}));
    }

    public String tictactoe(int[][] moves) {
        boolean blank = moves.length == 9;

        int[][] matrix = new int[3][3];

        for (int i = 0; i < moves.length; i++) {
            if (i%2==0){
                matrix[moves[i][0]][moves[i][1]] = 1;
            }else{
                matrix[moves[i][0]][moves[i][1]] = 2;
            }
        }

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            StringBuffer heng = new StringBuffer();
            for (int j = 0; j < matrix[0].length; j++) {
                heng.append(matrix[i][j]);
            }

            StringBuffer zong = new StringBuffer();
            for (int j = 0; j < matrix[0].length; j++) {
                zong.append(matrix[j][i]);
            }

            set.add(heng.toString());
            set.add(zong.toString());
        }

        StringBuffer duijiao1 = new StringBuffer();
        StringBuffer duijiao2 = new StringBuffer();
        for (int j = 0; j < matrix[0].length; j++) {
            duijiao1.append(matrix[j][j]);
            duijiao2.append(matrix[matrix.length-j-1][j]);
        }

        set.add(duijiao1.toString());
        set.add(duijiao2.toString());

        boolean Awin = set.contains("111");
        boolean Bwin = set.contains("222");

        if (Awin){
            return "A";
        }

        if (Bwin){
            return "B";
        }

        if (blank){
            return "Draw";
        }
        return "Pending";
    }

    /**
     * 法二 时间复杂度更低
     *
     */
    class Solution {
        public String tictactoe(int[][] moves) {
            int n = moves.length;
            int[][] map = new int[3][3];
            int type = 1;
            for (int[] ele : moves) {
                map[ele[0]][ele[1]] = type;
                type = -type;
            }
            boolean flag = true;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length - 1; j++) {
                    if (map[i][j] != map[i][j + 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (map[i][0] == 1) {
                        return "A";
                    } else if (map[i][0] == -1) {
                        return "B";
                    }
                }
                flag = true;
                for (int j = 0; j < map[0].length - 1; j++) {
                    if (map[j][i] != map[j + 1][i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (map[0][i] == 1) {
                        return "A";
                    } else if (map[0][i] == -1) {
                        return "B";
                    }
                }
                flag = true;
            }
            if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                if (map[0][0] == 1) {
                    return "A";
                } else if (map[0][0] == -1) {
                    return "B";
                }
            } else if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
                System.out.println("什么");
                if (map[0][2] == 1) {
                    return "A";
                } else if (map[0][2] == -1) {
                    return "B";
                }
            }
            if(n<9){
                return "Pending";
            }
            return "Draw";
        }
    }
}
