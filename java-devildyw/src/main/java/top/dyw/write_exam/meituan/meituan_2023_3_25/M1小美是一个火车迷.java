package top.dyw.write_exam.meituan.meituan_2023_3_25;


import java.util.*;

/**
 * @author Devildyw
 * @date 2023/03/25 18:59
 **/

/**
 * 题目描述：
 * 小美是一个火车迷。最近她在观察家附近火车站的火车驶入和驶出情况，发现火车驶入和驶出的顺序并不一致。经过小美调查发现，原来这个火车站里面有一个类似于栈的结构，如下图所示：
 *
 * 例如可能1号火车驶入了火车站中的休息区s，在驶出之前2号火车驶入了。那么在这种情况下，1号火车需要等待2号火车倒车出去后才能出去（显然被后面驶入的2号火车挡住了，这个休息区s只有一个出入口）。
 *
 * 出于好奇，小美统计了近些天的火车驶入驶出情况，开始统计和结束统计时休息区s中均是空的。由于中途疏忽，小美觉得自己好像弄错了几个驶入驶出顺序，想请你帮她验证一下。值得注意的是，小美虽然可能弄错了顺序，但对火车的记录是不重不漏的。
 *
 * 形式化地来形容休息区s，我们视其为一个容量无限大的空间，假设两列火车 i 和 j 同时处于休息区s中，驶入时刻Tin满足Tin(i)<Tin(j)，则驶出时间Tout必定满足Tout(i)>Tout(j)，即，先进后出。
 *
 *
 *
 * 输入描述
 * 第一行一个整数T表示数据组数。
 *
 * 对每组测试而言：
 *
 * 第一行一个整数n，表示观察到的火车数量。
 *
 * 第二行n个整数x1,x2,...,xn，表示小美记录的火车驶入休息区s的顺序。
 *
 * 第三行n个整数y1,y2,...,yn，表示小美记录的火车驶出休息区s的顺序。
 *
 * 1≤T≤10,1≤n≤50000,1≤xi,yi≤n, 且{xn} 、{yn} 均为{1,2,3,...,n}的一个排列，即1~n这n个数在其中不重不漏恰好出现一次。
 *
 * 输出描述
 * 对每组数据输出一行：如果小美记录的驶入和驶出顺序无法被满足则输出No，否则输出Yes。
 *
 * 样例输入
 * 3
 * 3
 * 1 2 3
 * 1 2 3
 * 3
 * 1 2 3
 * 3 2 1
 * 3
 * 1 2 3
 * 3 1 2
 * 样例输出
 * Yes
 * Yes
 * No
 *
 * 提示
 * 对第一组数据：
 *
 * 每辆火车刚驶入便立刻驶出即可满足此记录。
 *
 * 对第二组数据：
 *
 * [ <- 休息区出口  （空 初始状态）
 *
 * [1  <- 休息区出口 （1号驶入）
 *
 * [1 2 <- 休息区出口 （2号驶入）
 *
 * [1 2 3 <- 休息区出口 （3号驶入）
 *
 * [1 2 <- 休息区出口 （3号驶出）
 *
 * [1 <- 休息区出口 （2号驶出）
 *
 * [ <- 休息区出口 （1号驶出）
 *
 * 记录可以被此种方案满足。
 *
 * 对第三组数据：
 *
 * [ <- 休息区出口  （空 初始状态）
 *
 * [1  <- 休息区出口 （1号驶入）
 *
 * [1 2 <- 休息区出口 （2号驶入）
 *
 * [1 2 3 <- 休息区出口 （3号驶入）
 *
 * [1 2 <- 休息区出口 （3号驶出）
 *
 * 发现1号被2号堵住，无法先于2号驶出。
 *
 * 可以证明，亦不存在其他驶入驶出方案使得第三组数据满足要求。
 */
@SuppressWarnings("all")
public class M1小美是一个火车迷 {

    /**
     * leetcode 原题
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt(); //数据组数
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[] train_in = new int[n];
            int[] train_out = new int[n];

            LinkedHashMap<Integer, int[]> map = new LinkedHashMap<>();
            for (int j = 0; j < n; j++) {
                train_in[j] = input.nextInt();
            }

            for (int j = 0; j < n; j++) {
                train_out[j] = input.nextInt();
            }

            //模拟出栈入栈
            Deque<Integer> stack = new ArrayDeque<>();
            int pointer = 0;
            for (int j = 0; j < n; j++) {
                stack.push(train_in[j]);
                while (!stack.isEmpty()&&stack.peek()==train_out[pointer]){
                    stack.pop();
                    pointer++;
                }
            }

            if (stack.isEmpty()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }


        }

    }
}
