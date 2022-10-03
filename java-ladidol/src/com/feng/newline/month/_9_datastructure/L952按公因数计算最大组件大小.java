package com.feng.newline.month._9_datastructure;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L952按公因数计算最大组件大小
 * @author: Ladidol
 * @description: 给定一个由不同正整数的组成的非空数组nums ，考虑下面的图：
 * <p>
 * 有nums.length个节点，按从nums[0]到nums[nums.length - 1]标记；
 * 只有当nums[i]和nums[j]共用一个大于 1 的公因数时，nums[i]和nums[j]之间才有一条边。
 * 返回 图中最大连通组件的大小 。
 * 示例 1：
 * 输入：nums = [4,6,15,35]
 * 输出：4
 * 示例 2：
 * 输入：nums = [20,50,9,63]
 * 输出：2
 * 示例 3：
 * 输入：nums = [2,3,6,7,4,12,21,39]
 * 输出：8
 * @date: 2022/9/16 11:17
 * @version: 1.0
 */
public class L952按公因数计算最大组件大小 {


    class Solution {
        int n = (int) (1e5 + 7);
        int[] primes = new int[n];//
        boolean[] notPrime = new boolean[n];//i是不是合数
        int[] father = new int[n];

        public int largestComponentSize(int[] nums) {
            //欧拉筛，找出1-n的所有质数，返回当前所求范围内质数个数。
            int k = eulerScreen(n);
            //初始化并查集
            init(n);
            //遍历nums中的每个数,和他们的质因数连接
            for (int num : nums) {
                //商
                int quotient = num; //quotient的值会根据新筛选出的质因数变化。
                //遍历nums中的每个数,和他们的质因数连接
                for (int j = 0; j < k && primes[j] * primes[j] <= quotient; j++) {
                    if (quotient % primes[j] == 0) {
                        //表示找到最小质因数primes[i]
                        union(num, primes[j]);//全都加在num的族里面
                        while (quotient % primes[j] == 0) {//将同样的质因数都去掉。
                            quotient /= primes[j];
                        }
                    }
                }
                // 假如剩下了一个质因数，也和num连接
                if (quotient > 1) {
                    union(quotient, num);
                }
            }
            //每一组的人数
            int[] cnt = new int[n];
            int ans = 0;
            for (int num : nums) {
                //找到期间出现的最大值。
                ans = Math.max(ans, ++cnt[find(num)]);
            }
            return ans;
        }
        // 并查集init
        void init(int n) {
            for (int i = 1; i < n; ++i)
                father[i] = i;
        }

        // 并查集find方法（路径压缩v2：简约版）
        int find(int x) {
            return x == father[x] ? x : (father[x] = find(father[x]));
        }

        // 并查集union合并
        void union(int i, int j) {
            father[find(i)] = find(j);
        }

        // 欧拉筛求质数
        int eulerScreen(int n) {
            int k = 0;
            for (int i = 2; i < n; i++) {
                if (!notPrime[i]) {
                    primes[k++] = i;
                }
                for (int j = 0; primes[j] * i < n; j++) {
                    notPrime[primes[j] * i] = true;
                    if (i % primes[j] == 0) {
                        break;
                    }
                }
            }
            return k;//返回个数
        }
    }
}
