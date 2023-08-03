package top.dyw.leetcode.medium.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author Devildyw
 * @date 2023/08/03 12:00
 **/
@SuppressWarnings("all")
public class L12整数转罗马数字 {

    public static void main(String[] args) {

    }


    int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] symbols = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            //将罗马数字对应字符的值举出在从大到小去遍历 当前值大于等于某一罗马数字时记录该字符，数字并减去相应的值 当数字为0时跳出
            String symbol = symbols[i];
            while (num>=values[i]){
                num-=values[i];
                res.append(symbol);
            }

            if (num==0){
                break;
            }
        }

        return res.toString();

        


    }
}
