package top.dyw.leetcode.simple.string;

/**
 * @author Devildyw
 * @date 2023/12/21 20:40
 **/
@SuppressWarnings("all")
public class L28找出字符串中第一个匹配项的下标 {

    public static void main(String[] args) {
        System.out.println(new L28找出字符串中第一个匹配项的下标().strStr("leetcode","leeto"));
    }

    public int strStr(String haystack, String needle) {
        char[] hysArr = haystack.toCharArray();
        char[] ndArr = needle.toCharArray();

        for (int i = 0; i < hysArr.length; i++) {
            if (hysArr[i]==ndArr[0]){
                for (int j = 0; j < ndArr.length && i+j<hysArr.length; j++) {
                    if (hysArr[j+i]!=ndArr[j]){
                        break;
                    }
                    if (j==ndArr.length-1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
