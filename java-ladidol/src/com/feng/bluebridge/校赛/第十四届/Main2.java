package com.feng.bluebridge.校赛.第十四届;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/17 9:11
 * @description: {}
 */
public class Main2 {

    //现在有10个不同的篮子排成一排，你手中有30个相同的苹果，请问有多少种不同的分配方案，可以使得每个篮子里至少有一个苹果？
    //请注意，这是一个结果填空题，答案为一个整数，不允许出现包括空格在内的多余字符。
    public static void main(String[] args) {
        int n = 20;
        //对20个苹果进行分配，递归回溯暴力
        for (int i = 0; i <= 20; i++) {
            dfs(20-i,0);
        }
        System.out.println(paths);
    }
    // 10015005，但是我这里求出来是两倍的关系。因为是求组合不是排列，需要除以2.
    static long paths = 0;
    static void dfs(int shengyu, int deep){
        if (deep==10&&shengyu==0) {
            paths++;
            return;
        }
        if (deep==10||shengyu<=0) return ;
        for (int i = 0; i <= shengyu; i++) {
            dfs(shengyu-i,deep+1);
        }
    }


}
