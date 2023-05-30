package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/29 21:17
 **/
@SuppressWarnings("all")
public class OII005单词长度的最大乘积 {

    public static void main(String[] args) {
        System.out.println(1<<('w'-'a'));
        new OII005单词长度的最大乘积().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});
    }

    public int maxProduct(String[] words) {
        //我们将它对应的二进制位设为 1，然后将所有的二进制位按位或运算，得到的结果就是该字符串对应的二进制数。
        int[] bitSum = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                // 用位运算记录每个单词中出现的字母 计算得到字符串的二进制位
                bitSum[i] |= 1 << (c - 'a');
            }
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < bitSum.length; j++) {
                if ((bitSum[i]&bitSum[j])==0){//判断是否有交集
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
