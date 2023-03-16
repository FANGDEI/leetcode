package top.dyw.pat.simple;

import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-11-12:10
 */
@SuppressWarnings("all")
public class P1011A加B和C {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            Long n1 = input.nextLong();
            Long n2 = input.nextLong();
            Long n3 = input.nextLong();
            System.out.println("Case #"+(i+1)+": "+(n3-n2<n1));
        }

    }


}
