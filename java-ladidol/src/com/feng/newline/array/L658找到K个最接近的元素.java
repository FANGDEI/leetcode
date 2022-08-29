package com.feng.newline.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L658找到K个最接近的元素
 * @author: Ladidol
 * @description: 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 * @date: 2022/8/26 19:33
 * @version: 1.0 每日一题，emm有点难懂。
 */
public class L658找到K个最接近的元素 {
    //方法一：双指针
    //我们要想找到K个最接近的元素，可以删除n-k的元素来达到目的。
    //由于数组是有序的，因此最接近的k个元素一定是在数组中连续的，因此我们维护两个左右指针
    //若x - arr[left] <= arr[right] - x，则移动右指针，否则移动左指针，直到删除n-k个元素
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //数组长度
        int n = arr.length;
        //左右指针
        int left = 0, right = n - 1;
        //要删除的个数
        int delCnt = n - k;
        while (delCnt > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            delCnt--;
        }
        //从左到右添加元素
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
