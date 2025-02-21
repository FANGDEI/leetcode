package top.dyw.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/02/18 09:58
 **/
@SuppressWarnings("all")
public class L2080区间内查询数字的频率 {

    public static void main(String[] args) {

    }

    class RangeFreqQuery {
        // 利用map存储 arr 数组中每个元素出现的下标位置 query 方法就等价于 在下标位置数组中查找在queryleft和right区间内的下标个数
        // map中 2 的下标记录为 [1,4,5] query 方法传参数为[3, 5 ,2] 那么3，5中有4和5 利用2分法查找到区间
        Map<Integer, List<Integer>> pos = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                pos.computeIfAbsent(arr[i], k-> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> a = pos.get(value);
            if (a==null){
                return 0;
            }
            //查找 > right 和小于left的 相减即为频率
            // > right == right + 1
            return lowerBound(a, right + 1) - lowerBound(a, left);
        }

        private int lowerBound(List<Integer> a, int target) {
            int left = -1;
            int right = a.size();

            while (left+1 < right){
                int mid = (left + right) >> 1;
                if (a.get(mid) < target){
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return right;

        }

    }
}
