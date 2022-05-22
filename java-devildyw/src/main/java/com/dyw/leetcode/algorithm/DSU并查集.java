package com.dyw.leetcode.algorithm;

/**
 * @author Devil
 * @date 2022-05-22-14:55
 */
@SuppressWarnings("all")
public class DSU并查集 {
    int[] fa;

    /**
     * 初始化
     * @param n 数组大小
     */
    public void init(int n){
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    /**
     * 查找代表元素(根节点)
     * @param x
     * @return 根节点
     */
    public int find(int x){
        //如果x就是根节点直接返回x 否者先将fa[x]赋值为它的根节点的值再将值返回.
        return fa[x] == x ? x: (fa[x] = find(fa[x]));
    }

    /**
     * 将i所在的集合并入集合j中
     * @param i 元素i
     * @param j 元素j
     */
    public void merge(int i, int j){
        //找到i所在集合的代表元素指定为j所在集合中的代表元素
        // find(i)找到根节点又因为根节点fa[x]==x 所以使用fa[find(i)]将根节点值置为find(j)
        fa[find(i)] = find(j);
    }


    public static void main(String[] args) {
        DSU并查集 dsu = new DSU并查集();
        dsu.init(10);
        dsu.merge(2,1);
        System.out.println(dsu.find(2));
    }
}
