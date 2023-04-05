package top.dyw.nowcoder.top100;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2023-02-06-13:13
 */
@SuppressWarnings("all")
public class BM53缺失的第一个正整数 {

    public static void main(String[] args) {

    }

    public int minNumberDisappeared (int[] nums) {
        // write code here
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }
        int res = 1;
        while (map.containsKey(res)){
            res++;
        }
        return res;
    }
}
