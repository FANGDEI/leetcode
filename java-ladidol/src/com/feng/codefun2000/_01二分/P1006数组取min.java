package com.feng.codefun2000._01二分;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/28 11:54
 * @description: {}
 */
public class P1006数组取min {


    public static void main(String[] args) {
        FastReader reader = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));




    }
    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}
