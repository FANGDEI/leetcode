package com.feng.draft.template.rangesum;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template.rangesum
 * @className: 并查集
 * @author: Ladidol
 * @description:
 * @date: 2022/9/16 16:15
 * @version: 1.0
 */
public class 并查集 {

    //*********************普遍版本******************************************************************
    int n = 10000;

    int[] father = new int[n];

    void init(int n) {
        for (int i = 1; i < n; ++i)
            father[i] = i;
    }

    //find方法（朴素模样）
    int find淘汰了(int x) {
        if (father[x] == x)//根节点标志：其父节点就是自己本身；
            return x;
        else
            return find淘汰了(father[x]);//往父节点方向寻找根节点
    }

    //find方法（路径压缩v1）
    int find1(int x) {
        if (x == father[x])
            return x;
        else {
            father[x] = find1(father[x]);  //父节点设为根节点
            return father[x];         //返回父节点
        }
    }

    //find方法（路径压缩v2：简约版）
    int find(int x) {
        return x == father[x] ? x : (father[x] = find(father[x]));
    }


    //合并
    void union1(int i, int j) {
        father[find(i)] = find(j);
    }

    public void union(int x, int y) {
        int fatherX = find(x);
        int fatherY = find(y);

        if (fatherX != fatherY) {//去重，其实没有必要的
            father[fatherX] = fatherY;
        }
    }


    //*********************更强版本******************************************************************
    // 按秩合并（略）
    class unionSet2 {
        int[] father;
        int[] rank;
        //按秩合并初始化
        public void init(int n){
            for (int i = 0; i < n; i++) {
                father[i] = i;
                rank[i] = 0;
            }
        }

        public void union2 ( int x, int y){
            int fatherX = find(x);
            int fatherY = find(y);
            if (fatherX == fatherY) {
                return;
            }
            if (rank[fatherX] < rank[fatherY]) {
                father[fatherX] = fatherY;
            } else {
                father[fatherY] = fatherX;
                if (rank[fatherX] == rank[fatherY]) {
                    rank[fatherX]++;
                }
            }
        }
    }


}
