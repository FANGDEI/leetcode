package com.feng.newline.month._9_datastructure;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/9/29 19:17
 * @description: 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，
 * 其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 * 提示：
 * <p>
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 */
public class L1707与数组中元素的最大异或值 {


    //人麻了，字典树，cv的。
    class Solution {
        // 0-1字典树+排序：
        // 思路很简单，就是字典树 + 排序
        // 用0-1字典树存储可进行异或的值，按照题目要求的将nums中不大于m的元素插入字典树中
        class Trie{
            // boolean isEnd;
            //初始化一个表示0，1的字典树
            Trie[] childs = new Trie[2];
        }
        private void insert(int x){
            Trie cur = node;
            //对10^9，即30位加入字典树
            for(int i = 30; i >= 0; i--){
                if(((1 << i) & x) != 0){
                    if(cur.childs[1] == null) cur.childs[1] = new Trie();
                    cur = cur.childs[1];
                }else{
                    if(cur.childs[0] == null) cur.childs[0] = new Trie();
                    cur = cur.childs[0];
                }
            }
        }
        //从30位 -> 0位查找最符合异或结果最大的数
        private int query(int x){
            Trie cur = node;
            int ans = 0;
            for(int i = 30; i >= 0; i--){
                if(((1 << i) & x) != 0){
                    if(cur.childs[0] != null){
                        cur = cur.childs[0];
                    }else{
                        cur = cur.childs[1];
                        ans |= 1 << i;
                    }
                }else{
                    if(cur.childs[1] != null){
                        cur = cur.childs[1];
                        ans |= 1 << i;
                    }else{
                        cur = cur.childs[0];
                    }
                }
            }
            return ans;
        }
        Trie node;
        public int[] maximizeXor(int[] nums, int[][] qs) {
            //先排序
            Arrays.sort(nums);
            int n = nums.length;
            int len = qs.length;
            int[] ans = new int[len];
            //用idx记录qs的原坐标
            Integer[] idx = new Integer[len];
            for(int i = 0; i < len; i++) idx[i] = i;
            //先对记录的原坐标排序，再按照m从小到大排序
            Arrays.sort(idx, (a, b) -> qs[a][1] - qs[b][1]);
            Arrays.sort(qs, (a, b) -> a[1] - b[1]);
            this.node = new Trie();
            int r = 0;
            for(int i = 0; i < len; i++){
                int x = qs[i][0], m = qs[i][1];
                //将所有不大于m的nums[r]加入字典树
                while(r < n && nums[r] <= m) insert(nums[r++]);
                //如果字典树为空，则当前没有可进行异或的元素，返回-1
                if(r == 0) ans[idx[i]] = -1;
                else{
                    //查找最佳可异或值
                    int xor = query(x);
                    ans[idx[i]] = xor ^ x;
                }
            }

            return ans;
        }
    }
}