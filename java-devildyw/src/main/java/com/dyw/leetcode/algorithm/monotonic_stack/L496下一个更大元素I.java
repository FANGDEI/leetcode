package com.dyw.leetcode.algorithm.monotonic_stack;

import java.util.*;

/**
 * @author Devil
 * @since 2022-11-25-12:15
 */
@SuppressWarnings("all")
public class L496下一个更大元素I {
    public static void main(String[] args) {
        int[] res = new L496下一个更大元素I().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int re : res) {
            System.out.print(re+" ");
        }
    }

    /**
     * 单调栈：
     * 将nums1的元素与下标关系存入map中 因为nums1的元素是nums2的子集 所以对nums2构建单调栈 当遇到出栈的情况就代表当前遍历元素是第一个大于栈顶元素的值
     * 取出栈顶元素对应的nums2的元素 根据map中的num1与下标的关系 更新ans 结果集中的结果
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        /**
         * 通过map 记录nums1中元素与下标的映射关系
         */
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],i);
        }
        int[] ans =new int[n];
        //将ans 数组填充为 -1
        Arrays.fill(ans,-1);

        //声明栈
        Deque<Integer> deque = new LinkedList<>();
        //栈中只记录下标
        deque.push(0);
        for (int i = 1; i < m; i++) {
            //单调栈 单调顺序为栈顶到栈底为递增 这里满足条件加入栈中
            if (nums2[i]<=nums2[deque.peek()]){
                deque.push(i);
            }else{
                //满足栈不为空且当前遍历元素大于栈顶元素
                while (!deque.isEmpty()&&nums2[i]>nums2[deque.peek()]){
                    //取出元素值
                    int pre = nums2[deque.pop()];
                    //通过map判断是否在nums1中
                    if (map.containsKey(pre)){
                        //如果存在 填入结果数组
                        ans[map.get(pre)] = nums2[i];
                    }
                }
                deque.push(i);
            }
        }


        //返回
        return ans;

    }
}
