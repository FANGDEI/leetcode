package com.feng.bluebridge.省赛.十三届;

/**
 * @author: ladidol
 * @date: 2022/11/19 11:39
 * @description: 这天小明正在学数数。
 * 他突然发现有些正整数的形状像一座“山”，比如 123565321、145541，它
 * 们左右对称（回文）且数位上的数字先单调不减，后单调不增。
 * 小明数了很久也没有数完，他想让你告诉他在区间 [2022, 2022222022] 中有
 * 多少个数的形状像一座“山”。
 */
public class L2山 {


    public static void main(String[] args) {
//        long ans = 0;
//        for (long i = 2022; i <= 2022222022; i++) {
//            if (isValid(i)) {
//                ans++;
//            }
//        }
//        System.out.println("ans = " + ans);//ans = 3138
        isValid(22233222);

    }

    /**
     * 作者：Ladidol
     * 描述：
     * 先判断是否是对折的
     * 如果对折就判断前半段（n为奇数，前半段包括最中间的数字）是不是单调不递减。
     */
    static boolean isValid(long i) {
        //先判断是否是回文
        String s = String.valueOf(i);
        StringBuilder sb = new StringBuilder(s);
        if (s.equals(sb.reverse().toString())) {
            //在判断能不能单调递增
            for (int j = 0; j < s.length() / 2; j++) {
//                int pre = s.charAt(j);//这是直接ascii值建议来个-'0'
//                int aft = s.charAt(j + 1);
                int pre = s.charAt(j) - '0';//这是直接ascii值建议来个Integer.valueOf
                int aft = s.charAt(j + 1) - '0';
//                System.out.println("pre = " + pre + "; aft = " + aft);//n为偶数n/2 和 n/2+1比较是只能等于的。
                if (pre > aft) return false;
            }
            System.out.println("i = " + i);
            return true;
        }
        return false;
    }

}