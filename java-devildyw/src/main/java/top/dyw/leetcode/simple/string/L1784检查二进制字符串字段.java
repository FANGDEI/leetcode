package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-10-03-12:30
 */
@SuppressWarnings("all")
public class L1784检查二进制字符串字段 {

    public static void main(String[] args) {
        new L1784检查二进制字符串字段().checkOnesSegment("11");
    }

    public boolean checkOnesSegment(String s) {
        if (s.length() == 1) {
            return true;
        }
        if (s.length() == 0) {
            return false;
        }
        int indexofOne = s.lastIndexOf("1");
        int indexOfZore = s.indexOf("0");
        indexOfZore = indexOfZore == -1 ? 100 : indexOfZore;
        System.out.println(indexOfZore);
        if (indexofOne > indexOfZore) {
            return false;
        }
        return true;
    }

    public boolean checkOnesSegment01(String s) {
        return !s.contains("01");
    }
}
