package top.dyw.leetcode.medium.arrays;

import cn.hutool.core.lang.hash.Hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/03/12 09:51
 **/
@SuppressWarnings("all")
public class L904水果成篮 {

    public static void main(String[] args) {
        System.out.println(new L904水果成篮().totalFruit(new int[]{1,2,3,2,1}));
    }

    public int totalFruit(int[] fruits) {
        // 判断在滑动窗口的范围内 是否只有两种类型的果树并且果树的数量最大
        int res = Integer.MIN_VALUE;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.entrySet().size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            // 待窗口移动后再更新结果 因为移动后才能确保窗口内的元素只有两类
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
