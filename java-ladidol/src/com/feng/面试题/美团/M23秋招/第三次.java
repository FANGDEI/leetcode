package com.feng.面试题.美团.M23秋招;

import java.text.DateFormat;
import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/26 10:50
 * @description: {}
 */
public class 第三次 {


    static int count = 1;

    public static void main(String[] args) {


//        List<String> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        System.out.println(list1.getClass().equals(list2.getClass()));

        DateFormat df;
        Date date = new Date();
        df = DateFormat.getInstance();
        String s = df.format(date);
        Thread.yield();




    }

    private  void 第三题() {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {

            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        int count = 0;//操作次数
        for (int i = n - 2; i >= 0; i--) {//一直取改变后的最大和第二大
            int sum = nums[i] * nums[i + 1];
            count++;
            nums[i + 1] = 1;
            nums[i] = sum;//这里通过将最大值赋值给邻居，达到传递。
            if (count >= k) break;

        }
        System.out.println(Arrays.stream(nums).sum());
    }

    private static void 第二题() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        int count = 1;//人数计数
        for (int i = 0; i < n; i++) {
            int k = scan.nextInt(), c = scan.nextInt();
            count = Math.max(count, k);
            int cast = (int) Math.ceil((double) c / k);//向上取整
            for (int j = 0; j < k - 1; j++) {
                int tmp = scan.nextInt();
                map.put(tmp, map.getOrDefault(tmp, 0) + cast);
            }
        }
        for (int i = 0; i < count - 1; i++) {
            System.out.print(map.getOrDefault(i + 1, 0) + " ");
        }
    }


    private static void 第二题用数组() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] array = new int[50005]; // 使用大小为50005的数组代替Map

        int count = 1; // 人数计数
        for (int i = 0; i < n; i++) {
            int k = scan.nextInt(), c = scan.nextInt();
            count = Math.max(count, k);
            int cast = (int) Math.ceil((double) c / k); // 向上取整
            for (int j = 0; j < k - 1; j++) {
                int tmp = scan.nextInt();
                array[tmp] = array[tmp] + cast; // 更新数组元素的值
            }
        }
        for (int i = 0; i < count - 1; i++) {
            System.out.print(array[i + 1] + " "); // 输出数组元素的值
        }
    }


}
