package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L904水果成篮
 * @author: Ladidol
 * @description: 提示
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 * @date: 2022/5/22 11:48
 * @version: 1.0
 */
public class L904水果成篮 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new L904_by_移动窗口().totalFruit(nums));
    }
}

class L904_by_移动窗口 {
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }
        int right = 0;
        int left = 0;
        int resultCount = 2;
        int typeCount = 0;//如果数组length大于2就从零开始计数
        int[] fruitFrequence = new int[fruits.length];
        for (right = 0; right < fruits.length; right++) {
            fruitFrequence[fruits[right]]++;//对相应的水果种类, 个数++;// 入篮
            if (fruitFrequence[fruits[right]]==1) typeCount++;//第一次入篮子, type++;// 计算篮中每种水果出现的次数。 因为提示中说明了水果的种类数是有限的 0 <= fruits[i] < fruits.length
            while(typeCount>2){// 篮中超过两种水果
                fruitFrequence[fruits[left]]--;
                if (fruitFrequence[fruits[left]]==0){// 等于0说明篮中已经没有fruits[left]水果，typeCount减1
                    typeCount--;
                }
                left++;
            }
            resultCount = Math.max(resultCount, right-left+1);// 取窗口最大值
        }
        return resultCount;
    }
}
