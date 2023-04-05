package top.dyw.leetcode.TOP面试题;

/**
 * @author Devil
 * @since 2022-12-08-14:31
 */
@SuppressWarnings("all")
public class L14最长公共前缀 {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0){
            return "";
        }

        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix,strs[i]);
            if (prefix.length()==0){
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String prefix, String str) {
        int length = Math.min(prefix.length(),str.length());
        int index = 0;
        while (index<length&&prefix.charAt(index)==str.charAt(index)){
            index++;
        }
        return str.substring(0,index);
    }
}
