package top.dyw.leetcode.medium.graphics;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Devil
 * @since 2022-08-14-10:19
 *
 * 给你一个 有向无环图， n个节点编号为 0到 n-1，以及一个边数组 edges，其中 edges[i] = [fromi, toi]表示一条从点fromi到点toi的有向边。
 *
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 *
 * 你可以以任意顺序返回这些节点编号。
 *
 */
@SuppressWarnings("all")
public class L1557可以到达所有点的最少点数目 {
    public static void main(String[] args) {

    }

    /**
     * 找出入度为0的点
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        //找出所有入度不为0的点
        for (List<Integer> edge : edges) {
            set.add(edge.get(1));
        }

        //从总节点中剔除入度不为0的点 得到的就是入度为0的点
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
