package top.dyw.pat.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-11-12:19
 */
@SuppressWarnings("all")
public class P1012数字分类 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] A = new int[6];
        boolean[] isExist = new boolean[6];
        int length = input.nextInt();
        int index = 0,count4 = 0;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = input.nextInt();
        }


        for (int i = 0; i < length; i++) {
            int n = array[i];
            if (n%5==0){
                if (n%2==0){
                    isExist[1] = true;
                    A[1]+=n;
                }
            } else if (n%5==1){
                isExist[2] = true;
                if ((index%2)!=0){
                    A[2]-=n;
                }else{
                    A[2]+=n;
                }
                index++;
            } else if (n % 5 == 2) {
                isExist[3] = true;
                A[3]++;
            } else if (n % 5 == 3) {
                isExist[4] = true;
                A[4]+=n;
                count4++;
            } else if (n % 5 == 4) {
                isExist[5] = true;
                if (n>A[5]){
                    A[5] = n;
                }
            }
        }

        for (int i = 1; i < 4; i++) {
            if (isExist[i]) {
                System.out.print(A[i] + " ");
            } else {
                System.out.print("N ");
            }
        }
        if (isExist[4]) {
            System.out.printf("%.1f" + " ", (double)A[4]/count4);
        } else {
            System.out.print("N ");
        }
        if (isExist[5]) {
            System.out.print(A[5]);
        } else {
            System.out.print("N");
        }
    }


}
