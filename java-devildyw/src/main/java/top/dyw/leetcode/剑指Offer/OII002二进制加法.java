package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/27 18:27
 **/
@SuppressWarnings("all")
public class OII002二进制加法 {

    public static void main(String[] args) {
        System.out.println(new OII002二进制加法().addBinary("11", "10"));
    }

    public String addBinary(String a, String b) {
        int add = 0;
        int n = a.length(), m = b.length();

        int i = n-1, j = m-1;
        StringBuilder result = new StringBuilder();
        while (i>=0||j>=0||add!=0){
            int num1 = i>=0?a.charAt(i)-'0':0;
            int num2 = j>=0?b.charAt(j)-'0':0;
            int sum = num1 + num2 + add;

            result.append(sum%2);
            add = sum/2;
            i--;
            j--;
        }

        return result.reverse().toString();
    }
}
