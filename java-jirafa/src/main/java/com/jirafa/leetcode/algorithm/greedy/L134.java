package com.jirafa.leetcode.algorithm.greedy;

/**
 * https://leetcode.cn/problems/gas-station/
 */
public class L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum=0,sum=0;
        int start=0;
        for (int i = 0; i < gas.length; i++) {
            curSum+=gas[i]-cost[i];
            sum+=gas[i]-cost[i];
            if(curSum<0){
                curSum=0;
                start=(i+1)% gas.length;
            }
        }
        return sum>=0?start:-1;
    }

    public static void main(String[] args) {
        System.out.println(new L134().canCompleteCircuit(new int[]{1,2,3,4,5},
                new int[]{3,4,5,1,2}));
    }
}
