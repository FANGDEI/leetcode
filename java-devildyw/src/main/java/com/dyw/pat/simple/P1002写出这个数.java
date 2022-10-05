package com.dyw.pat.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-05-20:04
 */
@SuppressWarnings("all")
public class P1002写出这个数 {


    public static void main(String[] args) {
        String[] StringArray = new String[]{"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};


        Scanner input = new Scanner(System.in);

        String str = input.nextLine();

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        List<String> list = new ArrayList<>();
        while (sum!=0){
            list.add(StringArray[sum%10]);
            sum/=10;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = list.size()-1; i >=0 ; i--) {
            sb.append(list.get(i));
            if (i!=0){
                sb.append(' ');
            }
        }
        System.out.println(sb.toString());

    }
}
