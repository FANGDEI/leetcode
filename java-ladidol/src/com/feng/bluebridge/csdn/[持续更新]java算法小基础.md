---
title: java算法小知识点
date: 2022-03-20 16:23:44
tags: 
  - 算法
  - 技巧
categories:
  - 算法
cover: https://qiniu.ladidol.top/img/t01defc109c446643ce.png
---





# 前言:

csdn整理的算法技能树[戳这里](https://bbs.csdn.net/skill/algorithm)

回声实验室的算法路线[传送门](https://git.pyhub.club/star/list/-/blob/main/AlgorithmStudyList.md)

这里主要是一些小小知识点,希望以后能不断完善并总结更系统更有条理的...





# 片段:

## java的一个快速输入:

**通过BufferedReader来实现(一般就用这个就行):**

//注意要引入这个**java.io.***包
//同时还有异常要抛出

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //基本输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] tmp = br.readLine().split(" ");
        long a = Long.parseLong(tmp[0]);
        long b = Long.parseLong(tmp[1]);
    }
}
```





## 日期差简单运算:

```java
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author Ladidol
 * @Date: 2022/3/20 15:49
 * @Version 1.0
 */
public class 日期处理 {
    public static void main(String[] args) throws Exception {
        //基本输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //通过SimpleDateFormat来解析设置日期格式:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        /*天数差*/
        Date fromDate = sdf.parse("2022-03-20 12:00");
        Date toDate = sdf.parse("2090-03-20 12:00");
        long from = fromDate.getTime();
        long to = toDate.getTime();
        int days = (int) ((to - from)/(1000*60*60*24));
        System.out.println("两个时间之间的天数差为: " + days);
    }
}
```

## 简单的类的排序:

**通过新建一个实现了Comparable的类:**

```java
import java.io.*;
import java.util.Arrays;

public class Main {

    static class Student implements Comparable<Student> {
        //注意static
        String name;
        Integer totalFenShu;

        public Student(String name, Integer totalFenShu) {
            this.name = name;
            this.totalFenShu = totalFenShu;
        }
        
        @Override
        public int compareTo(Student o) {
            //一定重写compareTo这个方法
            return totalFenShu.compareTo(o.totalFenShu);
        }
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", totalFenShu=" + totalFenShu +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        //基本输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];


        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");

            String name = tmp[0];
            Integer totalFenShu = Integer.parseInt(tmp[1]);

            students[i] = new Student(name,totalFenShu);

        }
        //调用Arrays.sort()对数组进行排序
        Arrays.sort(students);

        for (Student i: students) {
            System.out.println(i);
        }
    }
}
```

结果:

```shell
4
feng 123
xiao 122
qiang 112
quan 1166
Student{name='qiang', totalFenShu=112}
Student{name='xiao', totalFenShu=122}
Student{name='feng', totalFenShu=123}
Student{name='quan', totalFenShu=1166}
```

## 常用进制转换:

**十进制转十六进制:**

```java
Integer.toHexString(shu)//shu是十进制int型
```

**十六进制转十进制**:

```java
Long.parseLong(hex,16)//这个hex是String字符串类型
```





## 最大公约数的寻找:

```java
static int gongYueShu(int A, int B){
    return B == 0? A: gongYueShu(B, A % B);
}
```



## 二分查找:

目标值小了就去左侧找,大了就去右侧找

```java
    
    public static int binarySearch(int[] arr, int target){
        //
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            //
            int indexOfMid = (right - left) >> 1;
            int mid = arr[indexOfMid];
            if (target > mid){
                //从右侧找,就要把左边界给缩小;
                left = indexOfMid + 1;
            }else if(target < mid){
                //从左侧找,就要把右边界给缩小;
                right = indexOfMid - 1;
            }else{
                //说明找到了,那就返回坐标;
                return indexOfMid;
            }
        }
        return -1;
    }
    
```



## java中有一种大数:

**BigInteger**

例题题目:

```
求两个超大数的最大公因数
输入:
12 16
输出:
4
```

```java
import java.io.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        
        BigInteger a = new BigInteger(tmp[0]);
        BigInteger b = new BigInteger(tmp[1]);
        System.out.println(yueFen(a,b));
    }

    public static BigInteger yueFen(BigInteger a, BigInteger b) {
        //注意,这里return b==0 ? a : yueFeng(b, a.mod(b));
        //注意等于用b.equals(BigInteger.ZERO)
        return b.equals(BigInteger.ZERO) ? a : yueFen(b,a.mod(b));
    }
}
```



