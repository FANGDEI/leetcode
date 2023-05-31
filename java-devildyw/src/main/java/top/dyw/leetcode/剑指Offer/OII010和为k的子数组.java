package top.dyw.leetcode.剑指Offer;

import java.util.HashMap;

/**
 * @author Devildyw
 * @date 2023/05/31 20:19
 **/
@SuppressWarnings("all")
public class OII010和为k的子数组 {

    public static void main(String[] args) {
        System.out.println(new OII010和为k的子数组().subarraySum(new int[]{1,2,3}, 3));
    }

    /**
     * 前缀和+哈希表
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum+=num;
            //具体来说，如果当前累加和 sum 减去目标值 k 的结果已经在 map 中出现过，则说明从上一个出现该结果的位置到当前位置的子数组和为 k
            //如果出现了map中某个值对应的值大于1 可能是中间出现了减的操作
            if (map.containsKey(sum-k)){
                result+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
