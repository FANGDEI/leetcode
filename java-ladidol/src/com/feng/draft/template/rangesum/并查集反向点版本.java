package com.feng.draft.template.rangesum;

/**
 * @author: ladidol
 * @date: 2022/10/16 13:30
 * @description:
 */
public class 并查集反向点版本 {
    //*********************反向点版本******************************************************************
    int n = 4010;

    int[] father = new int[2*n];

    void init() {
        for (int i = 1; i < 2 * n; ++i)//反向点。
            father[i] = i;
    }


    //find方法（路径压缩v2：简约版）
    int find(int x) {
        return x == father[x] ? x : (father[x] = find(father[x]));
    }


    //合并
    void union(int i, int j) {
        father[find(i)] = find(j);
    }

    //查询
    boolean query(int x, int y) {
        return find(x) == find(y);
    }
}