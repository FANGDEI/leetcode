package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-28-11:56
 * <p>
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 */
@SuppressWarnings("all")
public class L415字符串相加 {
    public static void main(String[] args) {
        System.out.println(new L415字符串相加().addStrings("11", "123"));
    }

    /**
     * 有空填零法(对较短的那个字符串进行了补零操作)
     * <p>
     * 这类题的一般思路就是
     * 初始两个指针指向末尾 初始化维护进位的变量
     * 初始化StringBuffer
     * 进行遍历相加 如果出现空位进行补零操作
     * 相加记录进位
     * 最后如果进位不为0 在进行一次相加操作.
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        //定义了两个指针分别指向两个字符串的末尾 因为相加都是以末尾对齐的 add在这里担任维护当前是否有进位
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        //这里采用了或运算 只要有一个条件满足就可以继续执行 可能会出现字符串长度不一的情况此时我们是采用补零的操作
        //如果两个字符串都已经走完 但是最后相加出现了进位 那么此时也需要在做一次循环 将进位的数加入我们的结果字符串
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        //因为append是将字符添加到字符串末尾 所以需要反转
        ans.reverse();
        //返回结果
        return ans.toString();
    }
}
