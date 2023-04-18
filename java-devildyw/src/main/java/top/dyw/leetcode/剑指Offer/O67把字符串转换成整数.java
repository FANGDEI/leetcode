package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/13 22:31
 **/
@SuppressWarnings("all")
public class O67把字符串转换成整数 {

    public static void main(String[] args) {
        System.out.println(new O67把字符串转换成整数().strToInt("42"));
    }

    //fixme 状态机
    public int strToInt(String str) {
        int start = -1,end = -1;
        boolean symbol = true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)){
                if (start==-1){
                    start = i;
                    continue;
                }
                end = i;
            }
        }
        String substring = str.substring(start, end + 1);
        System.out.println(substring);
        return -1;
    }
}
