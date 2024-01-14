package top.dyw.leetcode.simple.string;

/**
 * @author Devildyw
 * @date 2023/12/15 11:53
 **/
@SuppressWarnings("all")
public class L1768交替合并字符串 {

    public static void main(String[] args) {
        System.out.println(new L1768交替合并字符串().mergeAlternately("abcss", "pqr"));
    }

    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int n = w1.length;
        int m = w2.length;

        int i = 0, j = 0, k = 0;
        char[] newChar = new char[n + m];

        while (i<n&&j<m){
            if (k%2==0){
                newChar[k++] = w1[i++];
            }else{
                newChar[k++] = w2[j++];
            }
        }

        if (i<n){
            while (i<n){
                newChar[k++] = w1[i++];
            }
        }

        if (j<m){
            while (j<m){
                newChar[k++] = w2[j++];
            }
        }

        return new String(newChar);
    }
}
