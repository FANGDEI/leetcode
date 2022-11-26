package com.jirafa.luogu.chuanZhi;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    List<Integer> result= new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = n - 1; i >= 0; i--) {
            a[i] = scanner.nextInt();
        }
        for (int i = m - 1; i >= 0; i--) {
            b[i] = scanner.nextInt();
        }
        List<Integer> result = new B().setResult(a, b);

        StringBuilder stringBuilder = new StringBuilder();
        for (int k = result.size()-1; k >= 0 ; k--) {
            stringBuilder.append(result.get(k));
            if(k!=0) stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
    }

    private List<Integer> setResult(int[] a,int[] b){
        int pre = 0;
        int i = 0;
        int j = 0;
        while ( i < a.length && j < b.length) {
            int system = i + 2;
            int sum = a[i] + b[j] + pre;
            int delta = sum - system;
            if (delta < 0) {
                pre=0;
                result.add(sum);
            }
            else {
                result.add(delta);
                pre = 1;
            }
            i++;
            j++;
        }
        if (a.length >= b.length) {
            add(a,i,pre);
        } else {
            add(b,j,pre);
        }
        if (pre != 0)
            result.add(1);

        return result;
    }

    private void add(int[] ints,int i,int pre){
        for (int k = i; k < ints.length; k++) {
            int system = k + 2;
            int sum = ints[k] + pre;
            int delta = sum - system;
            if (delta < 0) {
                result.add(sum);
                pre = 0;
            } else {
                result.add(delta);
                pre = 1;
            }
        }
    }
}

