package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-07-05-11:30
 * <p>
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 * <p>
 * 如果perm[i] < perm[i + 1]，那么s[i] == 'I'
 * 如果perm[i] > perm[i + 1]，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 */
@SuppressWarnings("all")
public class L942增减字符串匹配 {
    public static void main(String[] args) {
        int[] idids = new L942增减字符串匹配().diStringMatch("DDI");
        for (int idid : idids) {
            System.out.print(idid + " ");
        }
    }

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int index = 0;
        int last = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = index++;
                last = index;
            } else {
                res[i] = n--;
                k++;
            }
        }
        res[n] = last;
        return res;
    }
}
