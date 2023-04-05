package top.dyw.leetcode.simple.arrays;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-12-31-13:28
 */
@SuppressWarnings("all")
public class L2037使每位学生都有座位的最少移动次数 {

    public static void main(String[] args) {
        System.out.println(new L2037使每位学生都有座位的最少移动次数().minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6}));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int n = seats.length;

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(seats[i]-students[i]);
        }

        return result;

    }
}
