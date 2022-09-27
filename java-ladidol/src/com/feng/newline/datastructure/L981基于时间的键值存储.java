package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L981基于时间的键值存储
 * @author: Ladidol
 * @description: 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
 * 实现 TimeMap 类：
 * <p>
 * TimeMap() 初始化数据结构对象
 * void set(String key, String value, int timestamp) 存储键 key、值 value，以及给定的时间戳 timestamp。
 * String get(String key, int timestamp)
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp 。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 * 示例：
 * <p>
 * 输入：
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * 输出：
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 * <p>
 * 解释：
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1
 * timeMap.get("foo", 1);         // 返回 "bar"
 * timeMap.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
 * timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4
 * timeMap.get("foo", 4);         // 返回 "bar2"
 * timeMap.get("foo", 5);         // 返回 "bar2"
 * 提示：
 * <p>
 * 1 <= key.length, value.length <= 100
 * key 和 value 由小写英文字母和数字组成
 * 1 <= timestamp <= 107
 * set 操作中的时间戳 timestamp 都是严格递增的
 * 最多调用set 和 get 操作 2 * 105 次
 * @date: 2022/9/3 13:57
 * @version: 1.0
 */
public class L981基于时间的键值存储 {
    // 个人简单暴力版本
    class TimeMap1 {
        HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> curMap = map.getOrDefault(key, new TreeMap<>());// 取出map
            curMap.put(timestamp, value);
            map.put(key, curMap);// 放回map
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> curMap = map.getOrDefault(key, new TreeMap<>());
            String res = "";
            while (timestamp >= 0 && res.equals("")) {
                res = curMap.getOrDefault(timestamp, "");
                timestamp--;
            }
            return res;
        }
    }


    // 2022年9月27日14:09:34，再做这一题。根据提示就是map套map
    class TimeMap {

        HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();// 第一层键为key，第二层键为timestamp。

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> curTree = map.getOrDefault(key, new TreeMap<>());
            curTree.put(timestamp, value);
            map.put(key, curTree);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> curTree = map.getOrDefault(key, new TreeMap<>());
            String ans = "";
//            int littleTime = timestamp;
            while (!curTree.isEmpty() && timestamp >= 0) {
                if (!curTree.getOrDefault(timestamp, "*").equals("*")) {
                    ans = curTree.get(timestamp);
                    break;
                }
                timestamp--;
            }
            return ans;
        }
    }


    // 取上界二分法（有个案例超时？？TLE）
    class TimeMap2 {
        HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> curMap = map.getOrDefault(key, new TreeMap<>());// 取出map
            curMap.put(timestamp, value);
            map.put(key, curMap);// 放回map
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> curMap = map.getOrDefault(key, new TreeMap<>());
            String res = curMap.getOrDefault(timestamp, "");
            if (res.equals("")) {
                List<Integer> times = new ArrayList<>(curMap.keySet());
                int l = 0, r = times.size();
                // 寻找第一个大于
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (times.get(mid) <= timestamp) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (l == 0) return res;//最后一个小零
                res = curMap.getOrDefault(times.get(l - 1), "");
            }
            return res;
        }
    }

    // 什么神仙代码。
    class TimeMap3 {
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            Map.Entry<Integer, String> entry = map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
