package top.dyw.leetcode.simple.math;

/**
 * @author Devildyw
 * @date 2023/08/09 14:48
 **/
@SuppressWarnings("all")
public class L1281整数的各位积和之差 {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }


    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n!=0){
            int temp = n%10;
            n/=10;
            sum+=temp;
            product*=temp;
        }

        return product-sum;
    }

}
