package top.dyw.leetcode.simple.string;

/**
 * @author Devildyw
 * @date 2023/12/23 19:17
 **/
@SuppressWarnings("all")
public class L58最后一个单词的长度 {

    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        String newStr = s.trim();

        int count = 0;
        for (int i = newStr.length()-1; i >= 0; i--) {
            if (newStr.charAt(i)!=' '){
                count++;
            }else{
                break;
            }
        }

        return count;
    }
}
