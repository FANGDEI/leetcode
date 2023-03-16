package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-09-12:12
 * <p>
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回true；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 */
@SuppressWarnings("all")
public class L859亲密字符串 {
    public static void main(String[] args) {
        System.out.println(new L859亲密字符串().buddyStrings("ab", "ba"));
    }

    /**
     * 枚举
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean buddyStrings(String s, String goal) {
        //判断是否长度相同 不同直接返回false
        if (s.length() != goal.length()) {
            return false;
        }
        //长度相同 直接判断是否两个字符串相同 相同则判断是否有2个或两个以上的字符 这样如果交换这个两个字符就还是相同的字符
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                //计数
                count[s.charAt(i) - 'a']++;
                //如果有一个字符出现两次或以上就返回true
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            //否则返回false 因为只有一个的话交换后是必然不会相同的
            return false;
        } else {
            //如果两个字符串长度相同长度不同 那么需要找到里面不同的两个字符
            int first = -1, second = -1; //初始化指针
            for (int i = 0; i < goal.length(); i++) {
                //通过这个找到两个不同的字符
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else { //如果能找到第三个那么也不能通过交换得到了 直接返回false
                        return false;
                    }
                }
            }
            //最后判断这两个不同字符交换是否能够使得两个字符串相等
            return (second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
        }
    }

}
