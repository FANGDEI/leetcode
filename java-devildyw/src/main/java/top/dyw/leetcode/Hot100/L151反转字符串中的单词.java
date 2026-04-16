package top.dyw.leetcode.Hot100;

import java.util.*;

public class L151反转字符串中的单词 {
    public String reverseWords(String s) {
        s = s.trim();
        char[] sChar = s.toCharArray();

        reverseStr(sChar, 0, sChar.length-1);

        List<String> resultList = new ArrayList<>();
        for (int i=0; i<sChar.length; i++) {
            if (sChar[i] == ' ') {
                continue;
            } else {
                int start = i;
                while (i < sChar.length) {
                    if (sChar[i] == ' ') {
                        reverseStr(sChar, start, i-1);
                        resultList.add(new String(sChar, start, i-start));
                        break;
                    } else {
                        if (i==sChar.length-1) {
                            reverseStr(sChar, start, i);
                            resultList.add(new String(sChar, start, i-start+1));
                        }
                    }
                    i++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<resultList.size(); i++) {
            sb.append(resultList.get(i));
            if (i!=resultList.size()-1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void reverseStr(char[] sChar, int left, int right) {
        while (left < right) {
            char temp = sChar[left];
            sChar[left] = sChar[right];
            sChar[right] = temp;

            left++;
            right--;
        }
    }
}
