package top.dyw.pat.simple;

import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-12-19:58
 */
@SuppressWarnings("all")
public class P1013数素数 {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        boolean[] visit = new boolean[100001];
        int[] prime = new int[10001];
        int cn = 0;
        for (int i = 2; i<=100000; i++){
            if (!visit[i]){
                prime[cn++]=i;
            }
            for (int j=0; j<cn&&i*prime[j]<=100000; j++){
                visit[i*prime[j]]=true;
                if (i%prime[j]==0){
                    break;
                }
            }
        }


        int count = 0;
        for (int i = n; i <= m; i++) {
            System.out.print(prime[i-1]);
            if ((++count)%10==0){
                System.out.println();
            }else if (i!=m){
                System.out.print(" ");
            }
        }

    }


}
