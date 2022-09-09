package com.feng.draft;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template
 * @className: PriorityQueue一些操作
 * @author: Ladidol
 * @description:
 * @date: 2022/9/7 16:51
 * @version: 1.0
 */
public class PriorityQueue一些操作 {



    PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
        if (a.getValue() != b.getValue()) return b.getValue() - a.getValue();// 按词频的降序。
        return a.getKey().compareTo(b.getKey());// 按照字典序升序。
    });



}
