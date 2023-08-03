package top.dyw.leetcode.medium.string;

import java.util.ArrayList;

/**
 * @author Devildyw
 * @date 2023/08/03 12:21
 **/
@SuppressWarnings("all")
public class L6N字形变换 {

    public static void main(String[] args) {

    }

    /**
     * 模拟
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows<2) return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        //这里的rows用来存储每一层应当遍历得到的字符串 模拟时存储
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        //模拟 i表示当前遍历字符应当时第几层的，flag用来控制z字上下方向
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i==0||i==numRows-1) flag = -flag;
            i+=flag;
        }
        //最后将每一层的遍历结果拼接即可
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}

