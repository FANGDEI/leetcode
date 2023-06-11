package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/06/11 13:47
 **/
@SuppressWarnings("all")
public class OII019最多删除一个字符得到回文 {
    public static void main(String[] args) {
        System.out.println(new OII019最多删除一个字符得到回文());
    }

    public boolean validPalindrome(String s) {
        int low = 0,high = s.length()-1;
        while (low<high){
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1==c2){//双指针 如果两个指针指向的字符串都相同就向中间逼近
                ++low;
                --high;
            }else{ //如果有不同的情况，就判断删除两个指针指向的其中一个字符串是否是回文串
                return check(s,low,high-1)||check(s,low+1,high);
            }
        }
        //如果一直相同则最终返回true
        return true;
    }

    private boolean check(String s,int low,int high) {
        for (int i = low,j=high; i < j; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
