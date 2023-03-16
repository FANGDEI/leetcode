package top.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-12-02-11:38
 */
@SuppressWarnings("all")
public class L1769移动所有球到每个盒子所需的最小操作数 {
    public static void main(String[] args) {
        int[] rse = new L1769移动所有球到每个盒子所需的最小操作数().minOperations("110");
        for (int i : rse) {
            System.out.print(i+" ");
        }
    }

    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int[] res = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            int sum = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j]=='1'){
                    sum += Math.abs(i-j);
                }
            }
            res[i] = sum;
        }

        return res;
    }

}
