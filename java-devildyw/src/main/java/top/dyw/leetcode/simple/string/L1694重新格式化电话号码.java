package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-10-01-13:29
 */
@SuppressWarnings("all")
public class L1694重新格式化电话号码 {

    public static void main(String[] args) {

    }

    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
            }
        }

        /**
         * 当 n>4n>4 时，我们取出三个连续的字符，作为一个块；
         *
         * 当 n \leq 4n≤4 时，我们根据题目的要求，将剩余的 nn 个字符进行分块，并结束遍历。
         */
        int n = sb.length();
        int pt = 0;
        StringBuilder ans = new StringBuilder();
        while (n>0){
            if (n>4){
                ans.append(sb.substring(pt,pt+3)+"-");
                n-=3;
                pt+=3;

            }else{
                if (n==4){
                    ans.append(sb.substring(pt,pt+2)+"-"+sb.substring(pt+2,pt+4));
                }else{
                    ans.append(sb.substring(pt,pt+n));
                }
                break;
            }
        }
        return ans.toString();
    }
}
