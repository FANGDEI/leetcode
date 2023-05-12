package top.dyw.leetcode.剑指Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Devildyw
 * @date 2023/05/08 22:29
 **/
@SuppressWarnings("all")
public class O61扑克牌中的顺子 {

    public static void main(String[] args) {

    }

    /**
     * 构成顺子 要求就是要连续，并且大小王可以代替任何数 要满足这个
     * 1. 最大牌和最小牌之差小于5(不能单纯为4 因为还有大小王)
     * 2. 不能重复(不能构成顺子)
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num==0) continue; //跳过大小王
            max = Math.max(max,num); //最大牌
            min = Math.min(min,num);//最小牌
            if (repeat.contains(num)) return false; //若有重复，提前返回false
            repeat.add(num);
        }
        return max - min<5;
    }
}
