package com.dyw.pat.simple;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-16-12:56
 */
@SuppressWarnings("all")
public class P1017A除以B {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        BigDecimal A = new BigDecimal(input.next());
        BigDecimal B = new BigDecimal(input.next());

        BigDecimal Q = A.divide(B);
        BigDecimal R = A.remainder(B);

        System.out.println(Q.toString()+" "+R.toString());

    }
}
