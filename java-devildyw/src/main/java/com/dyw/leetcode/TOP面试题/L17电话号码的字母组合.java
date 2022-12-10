package com.dyw.leetcode.TOP面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-12-09-18:04
 */
@SuppressWarnings("all")
public class L17电话号码的字母组合 {

    public static void main(String[] args) {

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
        if (startIndex==digits.length()){
            return;
        }
        int index = digits.charAt(startIndex) - '0';
        String str = number[index];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            letterCombinationsHelper(n,digits,startIndex+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
