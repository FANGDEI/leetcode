package com.dyw.leetcode.TOP面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-11-29-12:24
 */
@SuppressWarnings("all")
public class L22括号生成 {
    public static void main(String[] args) {
        System.out.println(new L22括号生成().generateParenthesis(3));
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    /**
     * 回溯
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        trackBacking(0,0,n);
        return res;
    }

    /**
     * 建议画出回溯 树形图做了解。
     * @param open 左括号数量
     * @param close 右括号数量
     * @param max 最多括号数
     */
    private void trackBacking(int open,int close, int max) {
        //如果字符串长度（左右括号总数）满足了最大括号数的两倍 代表满足条件 加入结果集
        if (sb.length()==max*2){
            res.add(sb.toString());
            return;
        }

        //如果左边括号数小于最大括号总数
        if (open<max){
            //添加左括号
            sb.append('(');
            trackBacking(open+1,close,max);
            System.out.println(sb.toString());
            sb.deleteCharAt(sb.length()-1);
        }

        //如果右边括号数小于左边括号总数
        if (close<open){
            //添加右括号
            sb.append(')');
            trackBacking(open,close+1,max);
            System.out.println(sb.toString());
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
