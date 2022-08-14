package com.dyw.leetcode.simple.graphics;

/**
 * @author Devil
 * @since 2022-08-14-10:09
 * <p>
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 * <p>
 * 如果小镇法官真的存在，那么：
 * <p>
 * 小镇法官不会信任任何人。
 * 每个人（除了小镇法官）都信任这位小镇法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * <p>
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 */
@SuppressWarnings("all")
public class L997找到小镇的法官 {
    public static void main(String[] args) {
        System.out.println(new L997找到小镇的法官().findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
    }

    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for (int[] ints : trust) {
            count[ints[1]]++;
            count[ints[0]]--;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
