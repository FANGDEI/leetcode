package com.dyw.pat.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-09-13:23
 */
@SuppressWarnings("all")
public class P1007素数对猜想 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        //找出所有素数
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)){
                primes.add(i);
            }
        }
        int result = 0;
        for (int i = 0; i < primes.size()-1; i++) {
            //前一个数减后一个数
            if (primes.get(i)+2==primes.get(i+1)){
                result++;
            }
        }


        System.out.print(result);
    }

    private static boolean isPrime(int num) {
        for (int j = 2; j<=Math.sqrt(num); j++){
            if (num%j==0){
                return false;
            }
        }
        return true;
    }


}
