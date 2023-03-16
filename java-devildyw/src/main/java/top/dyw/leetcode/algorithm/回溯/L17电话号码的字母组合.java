package top.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author Devil
 * @since 2022-10-10-12:30
 */
@SuppressWarnings("all")
public class L17电话号码的字母组合 {

    public static void main(String[] args) {
        System.out.println(new L17电话号码的字母组合().letterCombinations("2"));
    }

    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    String[] number = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n==0){
            return result;
        }
        letterCombinationsHelper(n,digits,0);

        return result;
    }

    private void letterCombinationsHelper(int n, String digits, int startIndex) {
        if (path.length()==n){
            result.add(path.toString());
        }
        if (startIndex>=digits.length()){
            return;
        }
        Integer index = digits.charAt(startIndex)-'0';
        String str = number[index];
        for (int i = 0; i<str.length(); i++){
            path.append(str.charAt(i));
            letterCombinationsHelper(n,digits,startIndex+1);
            path.deleteCharAt(path.length()-1);
        }
    }


}
