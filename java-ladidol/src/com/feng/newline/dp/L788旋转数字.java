package com.feng.newline.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L788旋转数字
 * @author: Ladidol
 * @description: 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字，则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；
 * 2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 现在我们有一个正整数N, 计算从1 到N 中有多少个数X 是好数？
 * 示例：
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * @date: 2022/9/25 21:21
 * @version: 1.0
 */
public class L788旋转数字 {


    // 利用 n 的范围为 1e4，我们可以直接检查 [1, n]的每个数。
    // 由于每一个位数都需要翻转，因此如果当前枚举到的数值 x 中包含非有效翻转数字（非 0125689）则必然不是好数；
    // 而在每一位均为有效数字的前提下，若当前枚举到的数值 x 中包含翻转后能够发生数值上变化的数值（2569），则为好数。
    class Solution1 {
        public int rotatedDigits(int n) {
            int ans = 0;
            xiaoxiao:
            for (int i = 1; i <= n; i++) {
                int x = i;
                boolean isGood = false;//当前数默认是坏数。
                while (x != 0) {
                    int cur = x % 10;
                    x = x / 10;
                    if (cur == 2 || cur == 5 || cur == 6 || cur == 9) isGood = true;//表示只要翻转合规，就会出现不一样的两个数，就是true了
                    else if (cur != 1 && cur != 8 && cur != 0) continue xiaoxiao;
                }
                if (isGood) ans++;//是正确的的就加一
            }
            return ans;
        }
    }


    //数位dp，我后面再来做吧嘤嘤嘤
    class Solution {
        public int rotatedDigits(int n) {
            return 0;
        }
    }
}
