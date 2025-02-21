package top.dyw.leetcode.simple.arrays;

/**
 * @author dingyangwei001
 * @description 有序数组中出现次数超过25%的元素
 * @date 2025/02/17 10:11
 **/
@SuppressWarnings("all")
public class L1287有序数组中出现次数超过25的元素 {

    public static void main(String[] args) {
        System.out.println(new L1287有序数组中出现次数超过25的元素().findSpecialInteger(new int[]{1,2,3,3}));
    }

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;

        int cur = arr[0], cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == cur) {
                cnt++;
                if (cnt * 4 > n){
                    return cur;
                }
            } else {
                cnt = 1;
                cur = arr[i];
            }
        }
        return -1;
    }

}

