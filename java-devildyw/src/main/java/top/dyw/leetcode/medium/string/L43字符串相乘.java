package top.dyw.leetcode.medium.string;

/**
 * @author Devil
 * @since 2022-08-01-10:53
 * <p>
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 */
@SuppressWarnings("all")
public class L43字符串相乘 {
    public static void main(String[] args) {
        System.out.println(new L43字符串相乘().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        //0乘任何数等于0
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }

        int m = num1.length(), n = num2.length();
        //两数相剩最大的返回就是两字符串的长度总和
        int[] ansArr = new int[m + n];
        //模拟乘法 双层循环 将num1的所有数字字符斗鱼num2相乘
        for (int i = m-1; i>=0; i--){
            int x = num1.charAt(i)-'0';
            for (int j = n-1; j>=0; j--){
                int y = num2.charAt(j) - '0';
                //模拟乘法错位
                ansArr[i+j+1] += x*y;
            }
        }

        //模拟乘法错位相加  从后往前加 计算进位
        for (int i = m+n-1; i>0; i--){
            //当前的数对10的商(进位) 加在在前一个书上
            ansArr[i-1] +=ansArr[i]/10;
            //更新当前 对10求余 只留下个位数
            ansArr[i]%=10;
        }

        //封装结果字符串
        int index = ansArr[0] == 0?1:0;
        StringBuffer ans = new StringBuffer();
        while (index<m+n){
            ans.append(ansArr[index]);
            index++;
        }

        return ans.toString();

    }
}
