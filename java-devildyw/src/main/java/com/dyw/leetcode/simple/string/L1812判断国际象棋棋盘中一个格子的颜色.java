package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-12-08-13:40
 */
@SuppressWarnings("all")
public class L1812判断国际象棋棋盘中一个格子的颜色 {

    public static void main(String[] args) {
        System.out.println(new L1812判断国际象棋棋盘中一个格子的颜色().squareIsWhite("h3"));
    }

    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0)-96)%2) != ((coordinates.charAt(1)-'0')%2);
    }
}
