package com.dyw.leetcode.medium.graphics;

import java.util.*;

/**
 * @author Devil
 * @since 2022-08-14-10:45
 * <p>
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * <p>
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 * <p>
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 */
@SuppressWarnings("all")
public class L841钥匙和房间 {
    public static void main(String[] args) {

    }

    /**
     * 广度优先遍历
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        Deque<Integer> deque = new LinkedList<>();
        //初始化标识数组 用来标识已有钥匙的房间
        boolean[] vis = new boolean[n];
        vis[0] = true;

        deque.offer(0);
        while (!deque.isEmpty()){
            int x = deque.poll();
            //计数 如果最后计数器等于n则代表能够进入所有房间
            num++;
            for (Integer integer : rooms.get(x)) {
                //如果房间还没标识为可进入 则将其修改为true 防止重复记录（容易超时）
                if (!vis[integer]){
                    vis[integer] = true;
                    deque.offer(integer);
                }
            }
        }
        return num==n;
    }
}
