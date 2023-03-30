package top.dyw.write_exam.meituan.meituan_2023_3_18;

import java.util.*;

/**
 * @author Devildyw
 * @date 2023/03/25 18:12
 **/
@SuppressWarnings("all")
public class M2k彩色区间 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }

        int index = 0;
        int ans= 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(colors[i],map.getOrDefault(colors[i],0)+1);
            while (map.size()>k){
                int num = map.get(colors[index]);
                if (num==1){
                    map.remove(colors[index]);
                }else{
                    map.put(colors[index],num-1);
                }
                index++;
            }
            ans = Math.max(ans,i-index+1);
        }

        System.out.println(ans);
    }


}
//    int left = 0, right = 0;
//    int maxLen = 0;
//    Map<Integer, Integer> count = new HashMap<>();
//        while (right < n) {
//        count.put(colors[right], count.getOrDefault(colors[right], 0) + 1);
//        while (count.size() > k) {
//        int num = count.get(colors[left]);
//        if (num == 1) {
//        count.remove(colors[left]);
//        } else {
//        count.put(colors[left], num - 1);
//        }
//        left++;
//        }
//        maxLen = Math.max(maxLen, right - left + 1);
//        right++;
//        }
//        System.out.println(maxLen);