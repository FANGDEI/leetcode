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


    /**
     * <img src="https://pic.leetcode-cn.com/9dda886441be8d249abb76e35f53f29fd6e780718d4aca2ee3c78f947fb76e75-image.png">
     * <br>
     * <img src="https://pic.leetcode-cn.com/1613584667-AQpTlK-Picture2.png">
     * <br>
     * 反推法
     * 通过最终删除位置的下标推出最终删除的元素在起始数组中的下标位置
     * 最后出圈的一定是最后一个元素 也就是最后下标为0的元素，通过这一个信息反推出下标为0的元素在初始状态时位于哪里
     * 记f(1) = 0;f(n)表示 当剩余n个元素时最终出队的那个元素的下标
     * f(2) = (f(1)+m)%2; 反推即上一个结果加上m再对当时的长度取余即使当时的下标位置
     * f(3)= (f(2)+m)%3;
     * ....
     * f(n) =(f(n-1)+m)%n;
     *
     * 因为n其实可以看作一个从0开始的数组 所以得到的下标就是结果
     *
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_re(int n, int m) {
        int idx = 0;
        //从还剩两个元素时开始反推
        for (int i = 2; i <= n; i++) {
            idx = (idx+m)%i;
        }
        return idx;
    }

}
