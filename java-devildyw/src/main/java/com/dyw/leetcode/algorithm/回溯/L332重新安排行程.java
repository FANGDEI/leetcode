package com.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * <p>
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * <p>
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 *
 * @author Devil
 * @since 2022-10-15-18:48
 */
@SuppressWarnings("all")
public class L332重新安排行程 {

    public static void main(String[] args) {

    }

    private LinkedList<String> res;

    private LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //按字典排序
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        findItineraryHelper((ArrayList) tickets, used);
        return res;
    }

    private boolean findItineraryHelper(ArrayList<List<String>> tickets, boolean[] used) {
        //总路程肯定是起点到 所有终点的总数 所以等于 tickets.size + 1
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList<>(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())){
                path.add(tickets.get(i).get(1));
                used[i] = true;

                //判断行程的终点是否访问过
                if (findItineraryHelper(tickets,used)){
                    return true;
                }

                used[i] =false;
                path.removeLast();
            }


        }
        //如果都被访问过了返回false
        return false;
    }

}
