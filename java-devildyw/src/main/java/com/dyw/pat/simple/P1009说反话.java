package com.dyw.pat.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-10-13:31
 */
@SuppressWarnings("all")
public class P1009说反话 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();
        List<String> strs = new ArrayList<>();

        int lastIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' '){
                strs.add(str.substring(lastIndex,i));
                lastIndex = i+1;
            }
        }
        strs.add(str.substring(lastIndex));

        for (int i = strs.size()-1; i >= 0; i--) {
            System.out.print(strs.get(i));
            if (i!=0){
                System.out.print(" ");
            }
        }
    }

}
