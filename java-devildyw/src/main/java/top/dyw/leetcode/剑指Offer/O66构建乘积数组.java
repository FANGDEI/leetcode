package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/23 19:58
 **/
@SuppressWarnings("all")
public class O66构建乘积数组 {

    public static void main(String[] args) {

    }


    /**
     * 左右乘积列表
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a==null||a.length==0) return new int[0];

        int length = a.length;

        //L 和 R 是两个左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] result = new int[length];
        //计算得到左侧乘积列表 (左到右前缀乘积 0 位置为1 方便计算当a[i] i=0 时的乘积)
        L[0] = 1;
        for (int i = 1; i < a.length; i++) {
            L[i] = a[i-1]*L[i-1];
        }

        //计算得到右侧乘积列表 (右到左前缀乘积 length-1 位置为1 方便计算当a[i] i=length 时的乘积)
        R[length-1] = 1;
        for (int i = length - 2; i >= 0; i++) {
            R[i] = R[i+1] * a[i+1];
        }

        for (int i = 0; i < a.length; i++) {
            result[i] = L[i]*R[i];
        }

        return result;
    }
}
