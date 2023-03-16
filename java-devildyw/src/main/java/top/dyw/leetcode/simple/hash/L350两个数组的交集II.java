package top.dyw.leetcode.simple.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * @author Devil
 * @since 2022-09-08-11:09
 */
@SuppressWarnings("all")
public class L350两个数组的交集II {
    public static void main(String[] args) {

    }

    /**
     * map
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] ans = new int[nums1.length];
        int index = 0;

        for (int i : nums2) {
            if (map.getOrDefault(i,0)!=0){
                ans[index++] = i;
                map.put(i,map.get(i)-1);
            }
        }

        return Arrays.copyOfRange(ans,0,index);
    }
}
