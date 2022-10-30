package com.feng.newline.sort;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/30 12:38
 * @description: 给你两个字符串数组 creators 和 ids ，和一个整数数组 views ，所有数组的长度都是 n 。平台上第 i 个视频者是 creator[i] ，视频分配的 id 是 ids[i] ，且播放量为 views[i] 。
 * 视频创作者的 流行度 是该创作者的 所有 视频的播放量的 总和 。请找出流行度 最高 创作者以及该创作者播放量 最大 的视频的 id 。
 * 如果存在多个创作者流行度都最高，则需要找出所有符合条件的创作者。
 * 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id 。
 * 返回一个二维字符串数组 answer ，其中 answer[i] = [creatori, idi] 表示 creatori 的流行度 最高 且其最流行的视频 id 是 idi ，可以按任何顺序返回该结果。
 * 示例 1：
 * <p>
 * 输入：creators = ["alice","bob","alice","chris"], ids = ["one","two","three","four"], views = [5,10,5,4]
 * 输出：[["alice","one"],["bob","two"]]
 * 解释：
 * alice 的流行度是 5 + 5 = 10 。
 * bob 的流行度是 10 。
 * chris 的流行度是 4 。
 * alice 和 bob 是流行度最高的创作者。
 * bob 播放量最高的视频 id 为 "two" 。
 * alice 播放量最高的视频 id 是 "one" 和 "three" 。由于 "one" 的字典序比 "three" 更小，所以结果中返回的 id 是 "one" 。
 * 示例 2：
 * <p>
 * 输入：creators = ["alice","alice","alice"], ids = ["a","b","c"], views = [1,2,2]
 * 输出：[["alice","b"]]
 * 解释：
 * id 为 "b" 和 "c" 的视频都满足播放量最高的条件。
 * 由于 "b" 的字典序比 "c" 更小，所以结果中返回的 id 是 "b" 。
 * 提示：
 * <p>
 * n == creators.length == ids.length == views.length
 * 1 <= n <= 105
 * 1 <= creators[i].length, ids[i].length <= 5
 * creators[i] 和 ids[i] 仅由小写英文字母组成
 * 0 <= views[i] <= 105
 */
public class L6221最流行的视频创作者 {


    //模拟，遍历，排序，哈希表 第317周周赛第二题。
    class Solution123 {
        /**
         * 参数：[creators, ids, views]
         * 返回值：java.util.List<java.util.List<java.lang.String>>
         * 作者： ladidol
         * 描述：
         */
        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

            //name为键，最大播放量id+最大播放量view+个人播放量总和作为联合值。
            Map<String, IdCnt> person2cnt = new HashMap<>();
            int n = creators.length;
            for (int i = 0; i < n; i++) {
                String name = creators[i];
                String id = ids[i];
                int view = views[i];

                if (!person2cnt.containsKey(name)) {
                    person2cnt.put(name, new IdCnt(id, view, view));
                } else {
                    //已经存在了的，那就要开始计数了
                    IdCnt pre = person2cnt.get(name);
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
            for (Map.Entry<String, IdCnt> entry : person2cnt.entrySet()) {
                String name = entry.getKey();
                IdCnt curInCnt = entry.getValue();
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
}