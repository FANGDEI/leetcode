package top.dyw.pat.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-10-13:56
 */
@SuppressWarnings("all")
public class P1010一元多项式求导 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        while (input.hasNext()){
            int a = input.nextInt(),b = input.nextInt();

            if (b!=0) ans.append((a*b)+" "+(b-1)+" ");
        }
        if ("".equals(ans.toString())) ans.append("0 0");

        System.out.print(ans.toString().trim());
    }
}
