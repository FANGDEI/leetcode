package com.feng.newline.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L1640能否连接形成数组
 * @author: Ladidol
 * @description: 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 3：
 * <p>
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * @date: 2022/9/22 23:00
 * @version: 1.0
 */
public class L1640能否连接形成数组 {
    class Solution {

        // 雀氏是直接用哈希表来做就行，这里面读题认真一点（pieces中的第二层基本单位是内层数组），对内层数组进行指纹录入作为key
        // 显然这样做事做不出来的，因为你不知道arr数组该怎么分割字符串成内层数组。

        // 看了一波提示发现：没有准确利用内层数组顺序是固定的条件：
        // 我们维护一张哈希表，存放每个数组的首个元素作为key，遍历到新数组后，开始逐个匹配数组中的后边元素是否完全匹配。
        public boolean canFormArray(int[] arr, int[][] pieces) {
            HashMap<Integer, int[]> map = new HashMap<>();
            // 先维护一个哈希表，方便通过首元素快速找到比对列表；
            for (int[] piece : pieces) {
                map.put(piece[0], piece);
            }
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    return false;//不存在这个首元素，return false
                }
                int[] curArr = map.get(arr[i]);
                for (int shu : curArr) {//内存数组比对
                    if (shu != arr[i++]) {
                        return false;
                    }
                }
                i--;//如果出来需要恢复一个
            }
            return true;
        }
    }
}
