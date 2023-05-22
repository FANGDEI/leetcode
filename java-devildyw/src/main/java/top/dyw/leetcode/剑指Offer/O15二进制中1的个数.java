package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/09 21:46
 **/
@SuppressWarnings("all")
public class O15二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(new O15二进制中1的个数().hammingWeight(11));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count+=n&1;
            n>>>=1;
        }
        return count;
    }
}
