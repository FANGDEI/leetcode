package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-28-14:05
 */
@SuppressWarnings("all")
public class BM22比较版本号 {

    public static void main(String[] args) {

    }

    public int compare (String version1, String version2) {
        // write code here
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0, j = 0;
        //直到两个字符串结束
        while (i<n1||j<n2){
            long num1 = 0;
            //从下一个点前截取数字 如果此时该字符串已经结束 那么得到的 num1 就为0 符合题意
            while (i<n1&&version1.charAt(i)!='.'){
                num1 = num1*10+(version1.charAt(i)-'0'); //这种方式可以取出前导零
                i++;
            }
            //跳过点
            i++;
            long num2 = 0;
            //从下一个点前截取数字
            while (j<n2&&version2.charAt(j)!='.'){
                num2 = num2*10+(version2.charAt(j)-'0');
                j++;
            }
            //跳过点
            j++;
            //比较数字大小
            if (num1>num2){
                return 1;
            }
            if (num2>num1){
                return -1;
            }
        }
        //版本号相同
        return 0;
    }
}
