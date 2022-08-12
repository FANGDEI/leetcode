package com.feng.newline.backtracking;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L332重新安排行程
 * @author: Ladidol
 * @description: 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 * 示例 1：
 * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * 输出：["JFK","MUC","LHR","SFO","SJC"]
 * 示例 2：
 * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
 * <p>
 * 简而言之就是：从jfk开始一条线把机票走完。
 * @date: 2022/8/12 13:23
 * @version: 1.0
 */
public class L332重新安排行程 {

    //这也可以用回溯法？ 其实深搜和回溯也是相辅相成的，毕竟都用递归
    //实际上确实是深搜，但这是深搜中使用了回溯的例子，在查找路径的时候，如果不回溯，怎么能查到目标路径呢。
    //出发机场和到达机场也会重复的，如果在解题的过程中没有对集合元素处理好，就会死循环。
    //困难，要命了，这题主要是对数据结构的选择。
    class Solution {
        //map<出发机场, map<到达机场, 航班次数>>，航班次数是指从该 出发机场----->到达机场 有多少次可以使用得票所以用int不用boolean来判断是否到过。
        Map<String, Map<String, Integer>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        int ticketCount;

        public List<String> findItinerary(List<List<String>> tickets) {
            this.ticketCount = tickets.size();
            //写入数据结构中。字典序最小，在这里就可以判断出来。
            //字典序，主要是对目的地进行排序。
            for (List<String> ticket : tickets) {
                Map<String, Integer> temp;
                if (!map.containsKey(ticket.get(0))) {//
                    temp = new TreeMap<>();//初始化该起点的票的目的treemap。
                    temp.put(ticket.get(1), 1);//
                } else {
                    temp = map.get(ticket.get(0));//得到该起点的目的treemap。
                    temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);//对相同机票进行累加
                }
                map.put(ticket.get(0),temp);
            }
            res.add("JFK");//起点
            backtrackingAndDFS();
            return res;

        }

        //对已经初始化的数据结构进行深搜回溯。
        boolean backtrackingAndDFS() {
            if (res.size() == ticketCount + 1) {
                return true;
            }
            String lastest = res.getLast();
            if (map.containsKey(lastest)) {//避免null空指针异常。
                for (Map.Entry<String, Integer> mapEntry : map.get(lastest).entrySet()) {//同层逻辑，从同一点出发，比遍历全部终点。
                    int curCount = mapEntry.getValue();
                    if (curCount > 0) {
                        res.add(mapEntry.getKey());
                        mapEntry.setValue(curCount - 1);//维护 目的treemap
                        if (backtrackingAndDFS()) return true;
                        res.removeLast();//回溯
                        mapEntry.setValue(curCount);//回溯
                    }
                }
            }
            return false;
        }
    }
}
