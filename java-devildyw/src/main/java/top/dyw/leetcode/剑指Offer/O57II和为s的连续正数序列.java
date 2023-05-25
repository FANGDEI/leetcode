package top.dyw.leetcode.剑指Offer;

import top.dyw.leetcode.algorithm.dp.完全背包;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/05/25 19:13
 **/
@SuppressWarnings("all")
public class O57II和为s的连续正数序列 {

    public static void main(String[] args) {

    }


    /**
     * 滑动窗口
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1; //滑动窗口左边界
        int right =1; //滑动窗口右边界
        int sum = 0;
        int[][] result = new int[target][];
        int index = 0;

        while (left<=target/2){ //左边界小于target/2才能保证有连续子序列满足target
            if (sum<target){//sum小于target 右指针移动
                sum+=right++;
            } else if (sum > target) {
                sum-=left++; //sum大于target 左指针移动
            }else{
                int[] temp = new int[right-left]; //临时数组记录当前结果
                for (int i = left; i < right; i++) {
                    temp[i-left] = i;
                }
                result[index++] = temp;
                sum-=left;//窗口右移计算下一个结果
                left++;
            }

        }

        return Arrays.copyOfRange(result,0,index);
    }
}
