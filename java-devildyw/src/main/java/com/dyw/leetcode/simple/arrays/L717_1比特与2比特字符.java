package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-25-12:48
 *
 * 有两种特殊字符：
 *
 * 第一种字符可以用一比特0 表示
 * 第二种字符可以用两比特（10或11）表示
 * 给你一个以 0 结尾的二进制数组bits，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * 思路: 就是遍历数组 一直遍历到最后判断是否最后一个0 是否与前面的元素组成两比特 如果不能就是1bit(10和11情况下才能组成两bit)
 *
 */
@SuppressWarnings("all")
public class L717_1比特与2比特字符 {
    public static void main(String[] args) {
        new L717_1比特与2比特字符().isOneBitCharacter01(new int[]{1,1,0,0});
    }

    /**
     * 方式一
     * 因为1肯定要连着下一个，所以遇见1，走两步，遇见0，走一步
     * 1 1 1 0 这种就不是以一比特结尾的  1 1 0 0 这种的才是
     * 然后判断这样的情况i能不能刚好直到最后一个元素 而不是跳过 (如n-2出 bit[n-2]=1 按照我们的算法是会跳两步的就会变成i=n
     * 这样就会跳过n-1 就不能达到 除非n-2处的1已经与前面的1组成两比特 否者最后一位就不可能是一比特)
     */
    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        int i = 0;
        while (i<length){
            //要是刚好能走到最后一个元素那么表示最后一位是1bit字符
            if (i==length-1){
                return true;
            }
            if (bits[i]==1){
                i +=2;
            }else {
                i++;
            }
        }
        //要是在遇到1跳两步的过程中恰好走完整个数组 那么最后一位就不是1bit字符
        return false;
    }

    /**
     * 方式二
     * 与方式一思路相同 但是更巧妙的是利用bit数组的1和0的特性修改i的值
     */
    public boolean isOneBitCharacter01(int[] bits) {
        int n = bits.length;
        int i = 0;
        //遍历数组 一直遍历到n-2的索引
        while (i<n-1){
            i+= bits[i]+1; //如果是i就跳两个 如果是0就跳一格
        }
        //i>=n-1 跳出循环 判断此时的i是否是和n-1(最后一个元素)相等的
        return i==n-1;
    }
}
