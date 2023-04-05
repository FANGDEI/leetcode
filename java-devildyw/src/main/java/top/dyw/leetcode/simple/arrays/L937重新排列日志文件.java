package top.dyw.leetcode.simple.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Devil
 * @since 2022-07-03-11:46
 * <p>
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 * <p>
 * 有两种不同类型的日志：
 * <p>
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * <p>
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 */
@SuppressWarnings("all")
public class L937重新排列日志文件 {
    public static void main(String[] args) {
        String[] strings = new L937重新排列日志文件().reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * 笨方法, 将是字符串的标识符和主体分开存储到二维数组中 如果是数字那么就是保持顺序存在另一个一维数组中
     * 在自定义排序方法 排序字符串的二维数组+
     *
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String[][] array1 = new String[n][2];
        String[] array2 = new String[n];
        int k = 0, m = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(logs[i].charAt(logs[i].length() - 1))) {
                int index = logs[i].indexOf(" ");
                array1[k][0] = logs[i].substring(0, index);
                array1[k][1] = logs[i].substring(index + 1, logs[i].length());
                k++;
            } else {
                array2[m++] = logs[i];
            }
        }


        //排序
        Arrays.sort(array1, 0, k, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (!o1[1].equals(o2[1])) {
                    return o1[1].compareTo(o2[1]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
        int index = 0;
        for (int i = 0; i < k; i++) {
            logs[index++] = array1[i][0] + " " + array1[i][1];
        }

        for (int i = 0; i < m; i++) {
            logs[index++] = array2[i];
        }

        return logs;
    }

    /**
     * leetcode评论区方法
     *
     * @param logs
     * @return
     */
    public String[] reorderLogFiles01(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //找到第一个空格后面的那个字符的下标 主要是为了判断除了标识符 是否是数字或是字母
                int s1 = o1.indexOf(" ") + 1;
                int s2 = o2.indexOf(" ") + 1;
                //如果都为数字那么就返回0 表示不交换
                if (Character.isDigit(o1.charAt(s1)) && Character.isDigit(o2.charAt(s2))) {
                    return 0;
                } else if (Character.isDigit(o1.charAt(s1))) {
                    //如果只有o1是数字 o2是字符串 数字应当放在后面 所以这里返回1 表示o1大于o2
                    return 1;
                } else if (Character.isDigit(o2.charAt(s2))) {
                    //如果只有o1是字符串 o2是数字 数字应当放在后面 所以这里返回-1 表示o2大于o1
                    return -1;
                } else {
                    //如果都不是那么按照正常字符串匹配 如果除去标识符都相等那么比较标识符
                    int cmp = o1.substring(s1).compareTo(o2.substring(s2));
                    if (cmp == 0) {
                        return o1.compareTo(o2);
                    }
                    return cmp;
                }
            }
        });
        return logs;
    }
}
