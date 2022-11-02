package com.dyw.leetcode.medium.arrays;

import java.util.PriorityQueue;

/**
 * @author Devil
 * @since 2022-11-02-10:20
 */
@SuppressWarnings("all")
public class L1620网络信号最好的坐标 {

    public static void main(String[] args) {
        System.out.println(new L1620网络信号最好的坐标().bestCoordinate(new int[][]{{32,36,27},{17,22,43},{8,11,41},{46,28,7},{22,4,35},{41,8,33},{32,29,4},{44,32,16},{33,20,16},{3,38,35},{17,47,23},{33,0,29},{29,19,6},{4,50,46},{19,47,6},{48,6,41},{20,26,35}}, 4));
    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        int m = towers.length;
        int n = towers[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if (a[2]==b[2]){
                if (a[0]==b[0]){
                    return a[1] - b[1];
                }
                return a[0]-b[0];
            }
            return b[2]-a[2];
        });

        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int qual = 0;

                for (int[] tower : towers) {
                    double sqrt = Math.sqrt(Math.pow(tower[0] - i, 2) + Math.pow(tower[1] - j, 2));
                    if (sqrt<=radius){
                        qual += (int)(tower[2] / (1 + sqrt));
                    }

                }
                queue.offer(new int[]{i,j,qual});
            }
        }


        int[] poll = queue.poll();
        return new int[]{poll[0],poll[1]};
    }
}
