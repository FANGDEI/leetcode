package com.feng.newline.dfs;

/**
 * @author: ladidol
 * @date: 2022/10/16 12:30
 * @description: 给定一组n人（编号为1, 2, ..., n），我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 给定整数 n和数组 dislikes，其中dislikes[i] = [ai, bi]，表示不允许将编号为 ai和bi的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * 示例 1：
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * <p>
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 */
public class L886可能的二分法 {

    //第一感觉通过快慢指针，判断链表有没有环就行，好像这个不是一条路的链表，不能通过二倍得到。
    //同时感觉不好生成链表。
    class Solution1234 {
        /**
         * 参数：[n, dislikes]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：
         */
        public boolean possibleBipartition(int n, int[][] dislikes) {
            return false;
        }
    }

    //反向点+并查集
    class Solution {
        /**
         * 参数：[n, dislikes]
         * 返回值：boolean
         * 作者： ladidol
         * 描述： 我超，反向点是啥，呜呜呜呜；初步感觉就是集合A的num的反向点就是在另一个集合B中num的另一个对应值，该对应值不是集合A中的其他值。这里用num+n来表示反向值。
         * 反向点在这里充当的角色就是替代正向点来连接其他数字。
         * <p>
         * 由题意我们知道：对于 ds[i] = (a, b) 而言，点 a 和点 b 必然位于不同的集合中，
         * 同时由于只有两个候选集合，因此这样的关系具有推断性：即对于 (a, b) 和 (b, c) 可知 a 和 c 位于同一集合。
         * 宫水三叶的题解：
         * 我们可以使用「并查集」维护所有点的连通性：边维护变检查每个 ds[i] 的联通关系，若 ds[i] = (a, b)联通，必然是其反向点联通所导致。反向点在这里充当的角色就是替代正向点来连接其他数字。
         */
        public boolean possibleBipartition(int n, int[][] dislikes) {

            init();
            for (int[] dis : dislikes) {
                int a = dis[0], b = dis[1];
                if (query(a, b)) return false;
                union(a, b + n);
                union(b, a + n);
            }
            return true;
        }


        //*********************反向点版本******************************************************************
        int n = 4010;

        int[] father = new int[2 * n];

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

}