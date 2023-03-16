package top.dyw.pat.simple;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-08-12:54
 */
@SuppressWarnings("all")
public class P1006换个格式输出整数 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] count = new int[3];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (num!=0){
            count[index++] = num%10;
            num/=10;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i]-->0){
                if (i==0){
                    sb.append(count[i]+1);
                }else if (i==1){
                    sb.append("S");
                }else{
                    sb.append("B");
                }
            }
        }

        System.out.println(sb.reverse().toString());
    }

}
