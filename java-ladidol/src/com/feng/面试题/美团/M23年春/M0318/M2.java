package com.feng.面试题.美团.M23年春.M0318;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/18 10:14
 * @description: 第一行两个整数N, K，以空格分开，分别表示彩带有N厘米长，你截取的一段连续的彩带不能超过K种颜色。
 * <p>
 * 接下来一行N个整数，每个整数表示一种色彩，相同的整数表示相同的色彩。
 * <p>
 * 1≤N,K≤5000，彩带上的颜色数字介于[1, 2000]之间。
 */
public class M2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), k = scan.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = scan.nextInt();
        }
//        System.out.println("colors = " + Arrays.toString(colors));
        //滑动窗口
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        while (right < n) {
            map.put(colors[right], map.getOrDefault(colors[right], 0) + 1);//维护窗口内的计数
            if (map.size()<=k){
                ans = Math.max(ans, right - left + 1);
            }else {
                //维护map的大小。
                while (map.size() > k) {
                    map.put(colors[left], map.get(colors[left]) - 1);
                    if (map.get(colors[left]) == 0) {
                        map.remove(colors[left]);
                        left++;
                        continue;
                    }
                    left++;
                }
            }
            right++;
        }
        System.out.println(ans);
    }
}
