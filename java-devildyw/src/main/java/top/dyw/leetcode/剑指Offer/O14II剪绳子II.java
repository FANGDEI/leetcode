package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/24 19:51
 **/
@SuppressWarnings("all")
public class O14II剪绳子II {

    public static void main(String[] args) {

    }

    /**
     * 贪心算法 由O14剪绳子贪心做法得出
     */
    public int cuttingRope(int n) {
        if (n<=3){
            return n-1;
        }

        long res = 1;
        //当n>4时 尽可能多的剪长度为3的绳子
        while (n>4){ //n>4 是为了防止n最后为0
            res*=3;
            res%=1000000007;
            n-=3;
        }

        return (int)(res*n%1000000007);
    }
}
