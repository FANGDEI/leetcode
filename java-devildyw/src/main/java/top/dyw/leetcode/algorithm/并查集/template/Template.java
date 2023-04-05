package top.dyw.leetcode.algorithm.并查集.template;

/**
 * @author Devil
 * @since 2022-12-16-23:11
 */
public class Template {

    int[] fa;

    public void init(int n){
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    public int find(int x){
        return x==fa[x]?x:(fa[x] = find(fa[x]));
    }

    public void merge(int i,int j){
        fa[find(i)] = find(j);
    }
}
