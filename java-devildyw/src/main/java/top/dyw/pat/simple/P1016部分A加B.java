package top.dyw.pat.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-16-12:44
 */
@SuppressWarnings("all")
public class P1016部分A加B {

    public static void main(String[] args) throws IOException {
        //BufferedReader读取 防止超时
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String ab[] = bf.readLine().split("\\s+");
        bf.close();
        BigInteger a, b, q, r;
        a = new BigInteger(ab[0]);
        b = new BigInteger(ab[1]);
        q = a.divide(b);   //商
        r = a.mod(b);      //余数
        System.out.println(q+ " "+ r);
    }
}
