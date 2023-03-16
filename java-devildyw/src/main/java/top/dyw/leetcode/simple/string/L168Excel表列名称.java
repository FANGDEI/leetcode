package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-20-14:48
 * <p>
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 */
@SuppressWarnings("all")
public class L168Excel表列名称 {
    public static void main(String[] args) {
        System.out.println(new L168Excel表列名称().convertToTitle(701));
    }

    /**
     * 这是一道从1开始的的26进制转换题。
     * 一般性的进制转换题目无须进行额外操作，是因为我们是在「每一位数值范围在 [0,x)的前提下进行「逢x进一」。
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        //由于columnNumber是从1开始的 所以每次进行进制转换的时候需要进行整体偏移操作
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();

        return sb.toString();
    }
}
