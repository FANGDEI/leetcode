package com.feng.codefun2000._01二分;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/28 11:18
 * @description: {https://codefun2000.com/p/P1236}
 */
public class P1236分糖果 {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt(), a = reader.nextInt(), b = reader.nextInt();
            int left = 1;
            int right = Math.max(a, b);
            // 如果最多能发的人数多于n,则收缩左端点
            while (left < right) {
                int mid = right + left + 1 >> 1;
                if (a / mid + b / mid >= n) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            out.println(left);
            out.flush();//注意要刷盘
        }
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



