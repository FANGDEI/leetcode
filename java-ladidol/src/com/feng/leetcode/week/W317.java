package com.feng.leetcode.week;

import com.feng.newline.sort.L6221最流行的视频创作者;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/30 10:36
 * @description:
 */
public class W317 {


    class Solution1 {
        public int averageValue(int[] nums) {
            int count = 0;
            int sum = 0;
            for (int num : nums) {
                if ((num & 1) == 0 && num % 3 == 0) {
                    count++;
                    sum += num;
                }
            }
            return count == 0 ? 0 : sum / count;
        }
    }

    //模拟，遍历，排序，哈希表 第317周周赛第二题。
    class Solution2 {
        /**
         * 参数：[creators, ids, views]
         * 返回值：java.util.List<java.util.List<java.lang.String>>
         * 作者： ladidol
         * 描述：
         */
        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

            //name为键，最大播放量id+最大播放量view+个人播放量总和作为联合值。
            Map<String, Solution2.IdCnt> person2cnt = new HashMap<>();
            int n = creators.length;
            for (int i = 0; i < n; i++) {
                String name = creators[i];
                String id = ids[i];
                int view = views[i];

                if (!person2cnt.containsKey(name)) {
                    person2cnt.put(name, new Solution2.IdCnt(id, view, view));
                } else {
                    //已经存在了的，那就要开始计数了
                    Solution2.IdCnt pre = person2cnt.get(name);
                    pre.sum += view;
                    if (view == pre.view) {
                        if (id.compareTo(pre.id) < 0) pre.id = id;
                    } else if (view > pre.view) {
                        pre.view = view;
                        pre.id = id;
                    }
                }
            }
            //遍历找出最大的视频播放者。
            long maxView = -1;
            List<List<String>> res = new ArrayList<>();
            for (Map.Entry<String, Solution2.IdCnt> entry : person2cnt.entrySet()) {
                String name = entry.getKey();
                Solution2.IdCnt curInCnt = entry.getValue();
                if (curInCnt.sum > maxView) {
                    //第一次出现更大的播放量，就直接生成新的list；
                    res.clear();
                    res.add(Arrays.asList(name, curInCnt.id));
                    maxView = curInCnt.sum;
                } else if (curInCnt.sum == maxView) {
                    //如果相等,就在末尾加就行了。
                    res.add(Arrays.asList(name, curInCnt.id));
                }
            }
            return res;
        }
        class IdCnt {
            String id;
            long sum;
            int view;

            public IdCnt(String id, long sum, int view) {
                this.id = id;
                this.sum = sum;
                this.view = view;
            }
        }
    }

    //寻找到每一个能被10整除的，且大于n的数，这个数还满足每位加起来不大于target。计算他们的差
    class Solution3 {
        public long makeIntegerBeautiful(long n, int target) {

            if (check(n, target)) {
                return 0;
            }

            //一个一个找最近的10被整除最小上限；
            long base = 10;
            long cur = n % base;
            for (int i = 0; i < 15; i++) {
                long remain = base - cur;
                if (check(n + remain, target)) {
                    return remain;
                }
                base *= 10;
                cur = n % base;

            }
            return -1;
        }
        boolean check(long num, int t) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum <= t;
        }
    }

    //第四题 略





}