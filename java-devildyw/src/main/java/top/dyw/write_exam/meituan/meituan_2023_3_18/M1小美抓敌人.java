package top.dyw.write_exam.meituan.meituan_2023_3_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Devildyw
 * @date 2023/03/25 17:16
 **/
@SuppressWarnings("all")
public class M1小美抓敌人 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 1;
        int[][]loc = new int[n][2];
        for (int i=0;i<n;i++){
            loc[i][0] = sc.nextInt();
            loc[i][1] = sc.nextInt();
        }
        //先根据 x 轴进行降序排序/y左边降序排序也行只是下面的操作相反而已

        Arrays.sort(loc,(o1,o2)->o1[0]-o2[0]);
        for (int i = 0; i < n; i++) { //双层for循环
            int x1 = loc[i][0];
            ArrayList<int[]> list = new ArrayList<>();
            for (int j = i; j < n; j++) {//记录满足坐标差不超过 a 的左边
                int x2 = loc[j][0];
                if (x2 - x1 > a){
                    break;
                }
                list.add(loc[j]);
            }
            //现在我们找到了横轴上满足要求的坐标了，固定了横坐标返回，现在来找纵坐标,将纵坐标进行降序排序
            Collections.sort(list,((o1, o2) -> o1[1]-o2[1]));
            int cnt = 0;
            int index = 0;
            for (int j = 0; j < list.size(); j++) {
                int y2 = list.get(j)[1];
                while (y2-list.get(index)[1]>b){ //狭义滑动窗口（保证差值不超过b）
                    index++;
                    cnt--;
                }
                cnt++;
                ans = Math.max(ans,cnt);
            }
        }
        System.out.println(ans);

    }


}
