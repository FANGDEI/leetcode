package com.feng.面试题.美团.M23年春.M0318;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/18 9:54
 * @description: {
 * 小美在玩一项游戏。该游戏的目标是尽可能抓获敌人。
 * <p>
 * 敌人的位置将被一个二维坐标 (x, y) 所描述。
 * <p>
 * 小美有一个全屏技能，该技能能一次性将若干敌人一次性捕获。
 * <p>
 * 捕获的敌人之间的横坐标的最大差值不能大于A，纵坐标的最大差值不能大于B。
 * <p>
 * 现在给出所有敌人的坐标，你的任务是计算小美一次性最多能使用技能捕获多少敌人。
 * }
 */
public class M1 {
    /**
     * 1、横纵坐标分别找到人数最多的宽度为2A和2B，先找纵坐标，再找横坐标
     * 怎么快速定位呢？
     * 2、或者直接暴力，人一步一步走，寻找判断
     * 封装到一个Map中，key为横坐标，value是list，存有该横坐标的全部纵坐标
     * 拿到一个返回后，通过priority队列来进行合并，然后再通过滑动窗口计算窗口中做大的值
     *
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt(), A = scan.nextInt(), B = scan.nextInt();
//        scan.nextLine();
//        int xMax = 0;
//        int xMin = 1005;
//        int yMax = 0;
//        int yMin = 1005;
//
//
//
//
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        //维护最大边界和map
//        for (int i = 0; i < n; i++) {
//            int x = scan.nextInt(), y = scan.nextInt();
//            xMax = Math.max(x + 1, xMax);
//            xMin = Math.min(x, xMin);
//            yMax = Math.max(y + 1, yMax);
//            yMin = Math.min(y, yMin);
//            List<Integer> orDefault = map.getOrDefault(x, new ArrayList<>());
//            orDefault.add(y);
//            map.put(x, orDefault);
//            scan.nextLine();
//        }
//        int ans = 0;
//        for (int i = xMin; i < xMax - A; i++) {
//            int over = over(map, i, A, B);
//            ans = Math.max(ans, over);
//        }
//        System.out.println(ans);
//    }


//    static int over(Map<Integer, List<Integer>> map, int curI, int A, int B) {
//        PriorityQueue<Integer> yQueue = new PriorityQueue<>();
//        for (int i = curI; i < curI + A; i++) {
//            List<Integer> orDefault = map.getOrDefault(curI, new ArrayList<>());
//            for (int j = 0; j < orDefault.size(); j++) {
//                yQueue.offer(orDefault.get(j));
//            }
//        }
//        //得到排好序的y，我们需要进行窗口计数
//        List<Integer> list = new ArrayList<>();
//        while (!yQueue.isEmpty()) {
//            list.add(yQueue.poll());
//        }
////        System.out.println("list = " + list);
//        for (int i = 0; i < list.size(); i++) {
//            //滑动窗口取值
//        }
//        return 3;
//    }


    //二维前缀和
    public static void main(String[] args) {

        class preSum二维{

            int[][] preSum;//前缀和数组
            int[][] matrix;
            int n,m;
            int x1,x2,y1,y2;
            int ans;

            /*============二维前缀和模板==============*/
            // 预处理前缀和数组
            {
                preSum = new int[n + 1][m + 1];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        // 当前格子(和) = 上方的格子(和) + 左边的格子(和) - 左上角的格子(和) + 当前格子(值)【和是指对应的前缀和，值是指原数组中的值】
                        preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                    }
                }
            }

            // 首先我们要令左上角为 (x1, y1) 右下角为 (x2, y2)
            // 计算 (x1, y1, x2, y2) 的结果
            {
                // 前缀和是从 1 开始，原数组是从 0 开始，上来先将原数组坐标全部 +1，转换为前缀和坐标
                x1++; y1++; x2++; y2++;
                // 记作 22 - 12 - 21 + 11，然后 不减，减第一位，减第二位，减两位
                // 也可以记作 22 - 12(x - 1) - 21(y - 1) + 11(x y 都 - 1)
                ans = preSum[x2][y2] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1] + preSum[x1 - 1][y1 - 1];
            }
        }



    }



}
