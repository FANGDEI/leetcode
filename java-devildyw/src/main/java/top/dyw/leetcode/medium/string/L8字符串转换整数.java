package top.dyw.leetcode.medium.string;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/01/02 10:42
 **/
@SuppressWarnings("all")
public class L8字符串转换整数 {

    public static void main(String[] args) {
        int i = new L8字符串转换整数().myAtoi("+000001564001");
    }

    public int myAtoi(String s) {
        int res = 0, sign = 1, i = 0;

        char[] charArray = s.toCharArray();
        while (i < charArray.length && charArray[i] == ' '){
            i++;
        }

        if (i < charArray.length && (charArray[i] == '-' || charArray[i] == '+')){
            sign = charArray[i++] == '-' ? -1 : 1;
        }

        while (i<charArray.length && charArray[i] <= '9' && charArray[i] >= '0'){
            int temp = charArray[i++] - '0';
            if (res > ((Integer.MAX_VALUE - temp) / 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + temp;

        }
        return res * sign;
    }

}
