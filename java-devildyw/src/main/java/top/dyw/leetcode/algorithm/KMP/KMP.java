package top.dyw.leetcode.algorithm.KMP;

/**
 * @author Devil
 * @since 2022-09-15-20:21
 */
public class KMP {

    /**
     * 构造next数组
     * @param next next数组
     * @param str 模式串
     */
    private void getNext(int[] next,String str){
        int j = 0;
        next[0] = j;

        for (int i = 1; i < str.length(); i++) {
            while (j>0 && str.charAt(i)!=str.charAt(j)){
                j = next[j-1];
            }
            if (str.charAt(i)==str.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {

        System.out.println(new KMP().strStr("aabaabaaf", "aabaaf"));

    }

    public int strStr(String haystack,String needle){
        if (needle.length()==0){
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next,needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j>0&&needle.charAt(j)!=haystack.charAt(i)){
                j = next[j-1];
            }
            if (needle.charAt(j)==haystack.charAt(i)){
                j++;
            }
            if (j==needle.length()){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

}
