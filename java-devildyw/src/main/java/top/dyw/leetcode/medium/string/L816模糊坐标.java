package top.dyw.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-11-07-10:42
 */
@SuppressWarnings("all")
public class L816模糊坐标 {

    public static void main(String[] args) {
        System.out.println(new L816模糊坐标().ambiguousCoordinates("(123)"));
    }

    /**
     * 暴力枚举
     *
     * @param s
     * @return
     */
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length() - 2;
        List<String> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1); //去除字符串两边的括号
        System.out.println(s);
        //遍历枚举
        for (int i = 1; i < n; i++) {
            List<String> lt = getPos(s.substring(0, i));
            if (lt.isEmpty()) {
                continue;
            }
            List<String> rt = getPos(s.substring(i));
            if (rt.isEmpty()) {
                continue;
            }
            for (String s1 : lt) {
                for (String s2 : rt) {
                    res.add("(" + s1 + ", " + s2 + ")");
                }
            }

        }

        return res;
    }

    private List<String> getPos(String substring) {
        List<String> pos = new ArrayList<>();
        //首先判断是否字符的第一个元素是否为0 或者整个字符串是否为0 如果第一个元素不为0 或整个字符串都是“0” 那么直接将当前字符串加入
        if (substring.charAt(0) != '0' || "0".equals(substring)) {
            pos.add(substring);
        }
        //再判断后续字符 条件判断
        for (int i = 1; i < substring.length(); i++) {
            //如果第一个元素是 0 并且i不为1 （如果 i=1 并且字符串末尾不为0 就将该字符串视为小数加入pos列表） 否则不加入
            if ((i != 1 && substring.charAt(0) == '0') || substring.charAt(substring.length() - 1) == '0') {
                continue;
            }
            pos.add(substring.substring(0, i) + "." + substring.substring(i));
        }
        //最后返回
        return pos;
    }


}
