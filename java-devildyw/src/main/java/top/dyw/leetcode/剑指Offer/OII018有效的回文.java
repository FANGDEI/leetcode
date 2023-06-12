package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/06/07 19:52
 **/
@SuppressWarnings("all")
public class OII018有效的回文 {

    public static void main(String[] args) {
        System.out.println(new OII018有效的回文().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)||Character.isLetter(c)){
                stringBuilder.append(Character.toLowerCase(c));
            }
        }

        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}
