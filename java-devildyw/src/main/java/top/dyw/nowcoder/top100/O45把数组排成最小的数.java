package top.dyw.nowcoder.top100;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/05/04 20:57
 **/
@SuppressWarnings("all")
public class O45把数组排成最小的数 {

    public static void main(String[] args) {
        System.out.println(new O45把数组排成最小的数().minNumber(new int[]{3,30,34,5,9}));
    }

    /**
     * 排序问题 要求能够排序出最小的数
     * 若拼接字符串 x+y > y+x，则 x 大于 y
     * 反之 若 x+y < y+x 则 x 小于 y
     * 我们要的是数组总数的升序排序，这样才能组装成最小的数
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(x,y)->{
            return (x+y).compareTo(y+x);
        });
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
