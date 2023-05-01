package com.feng.draft.template.输入输出;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        //基本输入
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String s = br.readLine();
//        String[] tmp = br.readLine().split(" ");
//        long a = Long.parseLong(tmp[0]);
//        long b = Long.parseLong(tmp[1]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] s = bufferedReader.readLine().split(" ");
        System.out.println(Arrays.toString(s));


    }
}