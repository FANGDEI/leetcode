package com.feng.newline.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1331数组序号转换
 * @author: Ladidol
 * @description: 给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * 示例 2：
 * <p>
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * 示例 3：
 * <p>
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 * @date: 2022/7/28 14:11 每日一题
 * @version: 1.0
 */
public class L1331数组序号转换 {

    class Solution {
        //本题主要是备份,排序和去重的思想.
        public int[] arrayRankTransform(int[] arr) {
            if (arr.length == 0) {
                return arr;
            }
            if (arr.length == 1) {
                arr[0] = 1;
                return arr;
            }
            int[] clone = arr.clone();//先clone一下数组。
            Arrays.sort(clone);//将clone数组排序一下。
            int order = 1;//升序
            int preNum = clone[clone.length - 1];
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(clone[0], 1);
            for (int i = 0; i < clone.length; i++) {
                if (preNum != clone[i]) {//如果不重复就仅需放入。
                    map.put(clone[i], order++);//放入顺序。
                    preNum = clone[i];//维护前一个数字。
                }
            }
            int[] res = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                res[i] = map.get(arr[i]);
            }
            return res;
        }
    }


    //用TreeSet来直接排序去重.
//    class Solution1 {
//        public int[] arrayRankTransform(int[] arr) {
//            TreeSet<Integer> set = new TreeSet<>();
//            for (int i : arr) {
//                set.add(i);
//            }
//            int s = 1;
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int k : set) {
//                map.put(k, s++);
//            }
//            int[] ans = new int[arr.length];
//            for (int i = 0; i < arr.length; i++) {
//                ans[i] = map.get(arr[i]);
//            }
//            return ans;
//        }
//    }
}
