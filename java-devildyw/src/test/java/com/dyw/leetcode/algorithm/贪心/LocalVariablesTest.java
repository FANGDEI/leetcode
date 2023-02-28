package com.dyw.leetcode.algorithm.贪心;

import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Devil
 * @since 2023-01-31-18:06
 */
@SuppressWarnings("all")
public class LocalVariablesTest {





    //练习

    static HashSet<Integer> set = new HashSet<Integer>();
    public static void main(String[] args) {



    }

    @Test
    public void test(){
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 199; j>=199-i; j--) {
                if ((i+j)>199){
                    System.out.println(i+" "+j);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
