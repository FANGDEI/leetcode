package top.dyw.leetcode.medium.string;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/01/02 10:42
 **/
@SuppressWarnings("all")
public class L8字符串转换整数 {

    public static void main(String[] args) {
        System.out.println(new L8字符串转换整数().myAtoi("-21474836482"));
    }

    public int myAtoi(String s) {
        int ans = 0, sign = 1, index = 0;

        char[] charArray = s.toCharArray();
        while (index < charArray.length && charArray[index] == ' ') {
            index++;
        }

        if (index < charArray.length && (charArray[index] == '-' || charArray[index] == '+')) {
            sign = charArray[index++] == '-' ? -1 : 1;
        }

        while (index < charArray.length && charArray[index] >= '0' && charArray[index] <= '9') {
            int temp = charArray[index++] - '0';
            if (sign == 1){
                if (ans > 214748364 || (ans == 214748364 && temp >= 7)){
                    return Integer.MAX_VALUE;
                }
            }else {
                if (ans > 214748364 || (ans == 214748364 && temp >= 8)){
                    return Integer.MIN_VALUE;
                }
            }
            ans = ans * 10 + temp;
        }

        return ans * sign;
    }

}
