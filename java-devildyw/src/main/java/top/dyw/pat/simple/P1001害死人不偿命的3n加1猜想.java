package top.dyw.pat.simple;

import java.util.Scanner;

/**
 *
 *
 * @author Devil
 * @since 2022-10-05-19:57
 */
@SuppressWarnings("all")
public class P1001害死人不偿命的3n加1猜想 {

    /**
     * 模拟
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int count = 0;

        while (num!=1){
            num = num%2==0? num/2: (3*num+1)/2;
            count++;
        }

        System.out.println(count);
    }
}
