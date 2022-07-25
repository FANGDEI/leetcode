package com.dyw.leetcode.simple.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Devil
 * @since 2022-07-25-10:56
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
@SuppressWarnings("all")
public class L136只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(new L136只出现一次的数字().singleNumber01(new int[]{2, 2, 1}));
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer)==1){
                return integer;
            }
        }
        return -1;
    }

    /**
     * 异或运算
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     *
     * @param nums
     * @return
     */
    public int singleNumber01(int[] nums) {
        int sigle = 0;
        for (int num : nums) {
            sigle ^= num;
        }
        return sigle;
    }
}
