package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/16 20:03
 **/
@SuppressWarnings("all")
public class O46把数字翻译成字符串 {

    public static void main(String[] args) {

        System.out.println(new O46把数字翻译成字符串().translateNum(123));
    }

    //fixme:不懂 先硬背
    public int translateNum(int num) {
        /**
         * 类似与斐波那契数列，比如我们要知道2位的数字有多少中表示方式 比如 12 就有两种方式 m(12) 或者 bc (1和2分开算)
         * 又例如：123 ===> bcd (三个分开算) 还有一种是，12 和 3 分开算(md)， 1 和 23 一起算(bx)，还有 (123) 一起算
         *
         * 注意：隐含条件：翻译的数字不能超过25
         */
        String str = String.valueOf(num);
        int[] dp = new int[str.length()+1];

        //只有零个数字也算一种表示 1也算一种表示
        dp[0] = dp[1] = 1;

        /**
         * 如果第 i-1 位和 第 i 位组合的数字是在 10 ~ 25 之间的那么就可以作为一个组合进行翻译
         */
        for (int i = 2; i <= str.length(); i++) {
            String tmpStr = str.substring(i - 2, i);
            if (tmpStr.compareTo("10")>=0&&tmpStr.compareTo("25")<=0){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[str.length()];

    }
}
