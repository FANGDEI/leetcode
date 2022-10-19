package com.feng.pat;



import java.io.*;
import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/18 14:33
 * @description: 输入：
 * 3
 * Joe Math990112 89
 * Mike CS991301 100
 * Mary EE990830 95
 * 输出：
 * Mike CS991301
 * Joe Math990112
 */
public class P1004成绩排名 {

    static class Student {
        String name;
        String number;
        int mark;

        public Student(String name, String number, int mark) {
            this.name = name;
            this.number = number;
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        public int getMark() {
            return mark;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    ", mark=" + mark +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Student> list = new LinkedList<>();


        Map<String, String> map = new HashMap<>();//key：学号；value：名字。
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            list.add(new Student(strs[0], strs[1], Integer.parseInt(strs[2])));
        }
        list.sort((a,b)->a.getMark()-b.getMark());
        System.out.println(list.get(n-1).getName()+" "+list.get(n-1).getNumber());
        System.out.println(list.get(0).getName()+" "+list.get(0).getNumber());

    }

}