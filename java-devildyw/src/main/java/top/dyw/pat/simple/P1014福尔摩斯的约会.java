package top.dyw.pat.simple;

import java.util.Scanner;

/**
 * 1014 福尔摩斯的约会 (20分)
 *
 * @author: ChangSheng
 * @date: 2019年12月15日 下午3:32:17
 */
public class P1014福尔摩斯的约会 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] weeks = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        String line01 = s.nextLine();
        String line02 = s.nextLine();
        String line03 = s.nextLine();
        String line04 = s.nextLine();
        // 1.找出周几和第几钟头
        boolean isFindWeek = false;
//        boolean isFindHour = false;
        for (int i = 0; i < line01.length() && i < line02.length(); i++) {
            char ch1 = line01.charAt(i);
            char ch2 = line02.charAt(i);
            if (ch1 == ch2) {
                if (!isFindWeek && ch2 >= 'A' && ch2 <= 'G') {
                    System.out.print(weeks[ch2 - 'A'] + " ");
                    isFindWeek = true;
                    continue; //跳过当前循环 防止下面查找小时遇到重复计算
                }
                if (isFindWeek) {//找到了周几 现在找小时
                    if (ch2 >= '0' && ch2 <= '9') {
                        System.out.printf("%02d:", (ch2 - '0'));
                        break;
                    } else if (ch2 >= 'A' && ch2 <= 'N') {
                        System.out.print((ch2-55)+":");
                        break;
                    }
                }

            }
        }
        // 2.找出分钟
        for (int i = 0; i < line03.length() && i < line04.length(); i++) {
            char ch = line03.charAt(i);
            char ch2 = line04.charAt(i);
            if (ch==ch2){
                if ((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')){
                    System.out.printf("%02d",i);
                    return;
                }
            }
        }
    }
}
