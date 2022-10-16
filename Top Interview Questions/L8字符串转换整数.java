public class L8字符串转换整数 {
    class Solution {
        public int myAtoi(String s) {
            int sign = 1, ans = 0, index = 0;
            char[] array = s.toCharArray();
            while (index < array.length && array[index] == ' ') {
                index ++;
            }
            if (index < array.length && (array[index] == '-' || array[index] == '+')) {
                sign = array[index++] == '-' ? -1 : 1;
            }
            while (index < array.length && array[index] <= '9' && array[index] >= '0') {
                int digit = array[index++] - '0';
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans = ans * 10 + digit;
            }
            return ans * sign;
        }
    }
}
