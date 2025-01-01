package top.dyw.leetcode.medium.math;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/01/01 16:37
 **/
@SuppressWarnings("all")
public class L7整数反转 {

    public static void main(String[] args) {
        System.out.println(new L7整数反转().reverse(123));
    }

    /**
     * 题目本身挺简单的，但是吧简单的题做好也不是一件简单的事情
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x >= -9 && x <= 9){
            return x;
        }
        int res = 0;

        while (x != 0){
            int temp = x%10;
            //优化吧算是 因为题目规定了传入的是一个int类型但是可能会应为反转导致反转后的数字超过范围 所以这里就是一个优化了
            //Integer最大值时2147483647 那么如果res已经大于214748364了 下次再往后放数字时无论如何都会大于2147483647
            if (res > 214748364 || (res == 214748364 && temp > 7)){
                return 0;
            }

            //同理
            if (res < -214748364 || (res == -214748364 && temp < -8)){
                return 0;
            }

            res = res * 10 +temp;
            x /= 10;
        }
        return res;
    }
}
