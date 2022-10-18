package com.feng.newline.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L904水果成篮
 * @author: Ladidol
 * @description: 示例:
 * 1.
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * 2.
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * 3.
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * <p>
 * <p>
 * 提示:
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 * @date: 2022/5/22 11:48
 * @version: 1.0
 */
public class L904水果成篮 {

    class Solution1 {
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
                if (fruitFrequence[fruits[right]] == 1)
                    typeCount++;//第一次入篮子, type++;// 计算篮中每种水果出现的次数。 因为提示中说明了水果的种类数是有限的 0 <= fruits[i] < fruits.length
                while (typeCount > 2) {// 篮中超过两种水果, 就开始收缩左边界
                    fruitFrequence[fruits[left]]--;
                    if (fruitFrequence[fruits[left]] == 0) {// 等于0说明篮中已经没有fruits[left]水果，typeCount减1
                        typeCount--;
                    }
                    left++;
                }
                resultCount = Math.max(resultCount, right - left + 1);// 取窗口最大值
            }
            return resultCount;
        }
    }

    //一眼滑动窗口+哈希
    class Solution {//2022年10月17日08:54:23再做

        /**
         * 参数：[fruits]
         * 返回值：int
         * 作者： ladidol
         * 描述：窗口中只允许两种元素，一旦大于两种元素，就需要左边界收缩到两个元素为止右边界再扩大。
         * 正常通过模拟就等得到，注意指针取值先后顺序。
         * [1,2,3,2,2]
         */
        public int totalFruit(int[] fruits) {
            int n = fruits.length;
            int slow = 0;
            int fast = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;

            for (; fast < n; fast++) {
                map.put(fruits[fast], map.getOrDefault(fruits[fast], 0) + 1);
                if (map.size() <= 2) {//更新最大值。
                    ans = Math.max(ans, fast - slow + 1);
                } else {//收缩窗口了。
                    while (map.size() > 2) {
                        int cur = fruits[slow++];
                        map.put(cur, map.get(cur) - 1);
                        if (map.get(cur) == 0) {
                            map.remove(cur);
                            break;
                        }

                    }
                }
            }
            return ans;
        }
    }

    //可以通过之前做的方法：用数组模拟哈希表。


}
