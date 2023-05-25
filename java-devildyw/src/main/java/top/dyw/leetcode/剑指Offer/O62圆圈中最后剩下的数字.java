package top.dyw.leetcode.剑指Offer;

import java.util.ArrayList;

/**
 * @author Devildyw
 * @date 2023/05/25 20:15
 **/
@SuppressWarnings("all")
public class O62圆圈中最后剩下的数字 {

    public static void main(String[] args) {
        System.out.println(new O62圆圈中最后剩下的数字().lastRemaining(5, 3));

    }


    /**
     * 约瑟夫环基本做法，但是性能较差
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        //每次的起始位置 也是上一次的删除位置(第一次之后)
        int idx = 0, result = 0;
        while (!list.isEmpty()){
            idx = (idx+m-1)%list.size();
            result = list.remove(idx);
        }
        return result;
    }

}
