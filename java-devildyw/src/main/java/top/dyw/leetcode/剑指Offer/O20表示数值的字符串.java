package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/13 22:17
 **/
@SuppressWarnings("all")
public class O20表示数值的字符串 {

    public static void main(String[] args) {

    }

    //fixme 状态机
    public boolean isNumber(String s) {
        s.trim();
        //true 代表是正号 false代表是符号
        boolean symbol = true;
        int start = 0;//初始位置
        char sym = s.charAt(start);
        for (int i = 0; i < s.length(); i++) {
            char op = s.charAt(i);
            if (i==0){
                if (op=='-'){
                    symbol = false;
                }else if (op == '+'){
                    symbol = true;
                }
            }
        }

        return false;
    }
}
