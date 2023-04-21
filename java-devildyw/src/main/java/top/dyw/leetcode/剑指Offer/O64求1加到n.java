package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/21 15:30
 **/
@SuppressWarnings("all")
public class O64求1加到n {

    public static void main(String[] args) {
        System.out.println(new O64求1加到n().sumNums(3));
    }

    int sum = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0; //借助&& 的性质如果前一个结果就能决定整个结果了那就不需要再往后判断了  "关键"
        sum += n;
        return sum;
    }
}
