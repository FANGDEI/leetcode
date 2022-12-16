package com.jirafa.蓝桥杯.十一届;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                for (int j = 0; j < str.charAt(i)-'0'; j++) {
                    sb.append(str.charAt(i-1));
                }
            }else{
                if(i<str.length()-1&&str.charAt(i+1)<'0'||str.charAt(i+1)>'9')
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
