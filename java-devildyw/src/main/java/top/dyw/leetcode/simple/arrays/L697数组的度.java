package top.dyw.leetcode.simple.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Devil
 * @date 2022-05-24-13:46
 * <p>
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 */
@SuppressWarnings("all")
public class L697数组的度 {
    public static void main(String[] args) {
        System.out.println(new L697数组的度().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    /**
     * 利用hashmap存储元素出现的次数 要找到最短连续子数组 该子数组至少需要要包含全部的 数组的 度对应的元素 即数组中该元素第一次出现的位置和最后一次位置
     * hashmap key存储元素 值为一个length=3的数组 分别存储元素出现的次数 第一次出现的位置 和最后一次的位置
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = nums.length;

        //遍历数组
        for (int i = 0; i < n; i++) {
            //如果map中有该元素则更新最后一次出现的位置和出现次数
            if (map.containsKey(nums[i])) {
                //出现次数加一
                map.get(nums[i])[0]++;
                //最后一次出现的位置更新为i
                map.get(nums[i])[2] = i;
            } else { //map中没有该元素 初始化添入 第一次出现的位置 和最后一次的位置都设置为i
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxNum = -1, minLen = 0;
        //遍历map 找到数组的度 和最小连续子数组
        for (Map.Entry<Integer, int[]> integerEntry : map.entrySet()) {
            int[] value = integerEntry.getValue();
            //更新数组的度 和最小连续子数组长度
            if (maxNum < value[0]) {
                maxNum = value[0];
                minLen = value[2] - value[1] + 1;
            } else if (maxNum == value[0]) {//需要判断有两个出现相同次数的元素
                minLen = Math.min(minLen, value[2] - value[1] + 1); //更新最小连续子数组长度
            }
        }
        return minLen;
    }


}
