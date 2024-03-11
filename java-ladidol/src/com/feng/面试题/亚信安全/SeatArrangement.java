package com.feng.面试题.亚信安全;

public class SeatArrangement {
    public static int calculateMaxOccupiedSeats(String[] pos) {
        int maxOccupiedSeats = 0;
        int consecutiveEmptySeats = 0;

        // 遍历座位数组
        for (int i = 0; i < pos.length; i++) {
            if (pos[i].equals("B")) {
//                consecutiveEmptySeats++;
                // 如果当前位置和相邻的左右位置都是空位，则可以坐人
                if ((i == 0 || pos[i - 1].equals("B")) && (i == pos.length - 1 || pos[i + 1].equals("B"))) {
                    maxOccupiedSeats++;
                    pos[i] = "A";
                }
            } else {
//                consecutiveEmptySeats = 0;
            }
        }

        return maxOccupiedSeats;
    }

    public static void main(String[] args) {
        String[] pos = {"B", "B", "B",  "B",  "B", "A"};

        int maxOccupiedSeats = calculateMaxOccupiedSeats(pos);
        System.out.println("最多可坐人数：" + maxOccupiedSeats);
    }
}