package com.feng.bluebridge.校赛.第十四届;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/17 10:52
 * @description: {}
 */
public class MainD {
    //单调栈来做，剩余两个测试点内存超限
    //2022/12/17 可以试下先排序，取最大值
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] high = new long[n];
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            high[i] = scan.nextInt();
            power[i] = scan.nextInt();
        }

        //可以和上面的进行合并操作
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int[] rightRes = new int[n];
        int[] leftRes = new int[n];
        Arrays.fill(rightRes, n);
        Arrays.fill(leftRes, -1);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && high[stack.peek()] < high[i]) {
                rightRes[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && high[stack.peek()] < high[i]) {
                leftRes[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            if (rightRes[i] >= 0 && rightRes[i] < n) res[rightRes[i]] += power[i];
            if (leftRes[i] >= 0 && leftRes[i] < n) res[leftRes[i]] += power[i];
        }
        Arrays.sort(res);
        System.out.println(res[res.length - 1]);
        //原来如此，这个stream有时候会影响效率
//        System.out.println(Arrays.stream(res).max().getAsLong());
    }
}
