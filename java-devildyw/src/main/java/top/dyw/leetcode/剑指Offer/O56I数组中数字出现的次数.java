package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/22 20:15
 **/
@SuppressWarnings("all")
public class O56I数组中数字出现的次数 {

    public static void main(String[] args) {
        int[] ints = new O56I数组中数字出现的次数().singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});
    }

    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums)               // 1. 遍历异或 因为 a^a^b^b^x^y = x^y
            n ^= num;
        while((n & m) == 0)               // 2. 循环左移，计算 m 找到x^y第一个为1的二进制位 也就代表x和y在这一位上他们是不同的
            m <<= 1;
        for(int num: nums) {              // 3. 根据m遍历 nums 分组将nums分为两组 一组在x上是m位上位1的，一组是在m为上为0的 其余相同两个数都在同一组内
            if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0 再利用a^a^b^b^x = x 得到x
            else y ^= num;                // 4. 当 num & m == 0 再利用a^a^b^b^y = y 得到y
        }
        return new int[] {x, y};          // 5. 返回出现一次的数字
    }
}
