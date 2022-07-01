package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-01-12:27
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
@SuppressWarnings("all")
public class L541反转字符串II {
    public static void main(String[] args) {
        System.out.println(new L541反转字符串II().reverseStr01("abcdefg", 2));
    }

    /**
     * 模拟
     * 条件判断 StringBuffer 搭配String类型的substring方法完成
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        StringBuffer sb = new StringBuffer();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (n - i >= 2 * k) {
                StringBuffer reverse = new StringBuffer();
                reverse.append(s.substring(i, i + k)).reverse();
                reverse.append(s.substring(i + k, i + 2 * k));
                sb.append(reverse);

                i += 2 * k - 1;
            } else if (n - i >= k && n - i < 2 * k) {
                StringBuffer reverse = new StringBuffer();
                reverse.append(s.substring(i, i + k)).reverse();
                reverse.append(s.substring(i + k, n));
                sb.append(reverse);
                i += n - i - 1;
            } else if (n - i < k) {
                StringBuffer reverse = new StringBuffer();
                reverse.append(s.substring(i, n)).reverse();
                sb.append(reverse);
                i += n - i - 1;
            }
        }
        return sb.toString();
    }


    /**
     * 这是在数组的基础上进行更改
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr01(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        //每次偏移2k的索引 因为当字符串大于2k时会反转前k个字符但是后k个字符是不变得 大于等于k小于2k也是同样 意会联系题意
        for (int i = 0; i < n; i += 2 * k) {
            //Math.min是为了防止数组的长度不足k
            //这里的最右边的参数 就是每次反转的索引的end 中间的i则为每次反转的start 如果i+k超过了数组的长度则表示剩余字符小于了k 按题意得应当全部反转 所以加上了Math.min来判断这中情况
            //防止从i开始的剩余字符串小于k的长度 而reverse只是单纯的负责反转指定区间的全部字符
            reverse(chars, i, Math.min(i + k, n) - 1);
        }
        return new String(chars);
    }

    /**
     * 反转前k个字符 或是不足k个的字符
     *
     * @param arr
     * @param left
     * @param right
     */
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
