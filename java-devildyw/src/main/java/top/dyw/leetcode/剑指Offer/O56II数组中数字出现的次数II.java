package top.dyw.leetcode.剑指Offer;

import java.util.HashMap;

/**
 * @author Devildyw
 * @date 2023/05/23 19:26
 **/
@SuppressWarnings("all")
public class O56II数组中数字出现的次数II {
    public static void main(String[] args) {

    }


    /**
     * 位运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];//用于记录每一位上的统计结果
        //统计每一位上的出现次数
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSum[i] += num&1; //a&1 = a;
                num>>>=1;
            }
        }
        //统计结果如果有一位上的统计结果%3不为0则说明 res 在该位上为1 遍历所有统计结果位得到最终结果
        int res = 0;
        //恢复只出现一次的数字
        for (int i = 0; i < 32; i++) {
            if (bitSum[i]%3!=0){
                res|=(1<<i); //拼装结果
            }
        }
        return res;
    }


}
