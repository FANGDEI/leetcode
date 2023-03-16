package top.dyw.leetcode.simple.arrays;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-07-02-15:11
 * <p>
 * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个'.' 或 '+' 。
 * <p>
 * 例如，在alice@leetcode.com中，alice是 本地名 ，而leetcode.com是 域名 。
 * 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
 * <p>
 * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com”会转发到同一电子邮件地址。
 * 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
 * <p>
 * 例如 m.y+name@email.com 将转发到 my@email.com。
 * 可以同时使用这两个规则。
 * <p>
 * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
 */
@SuppressWarnings("all")
public class L929独特的电子邮件地址 {
    public static void main(String[] args) {
        System.out.println(new L929独特的电子邮件地址().numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"}));
    }

    /**
     * 没啥技巧
     *
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            set.add(doEmails(emails[i]));
        }

        return set.size();
    }

    public String doEmails(String email) {
        String[] split = email.split("@");
        StringBuffer sb = new StringBuffer();
        String s = split[0];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '.') {
                continue;
            } else if (c == '+') {
                break;
            } else {
                sb.append(c);
            }
        }

        sb.append("@" + split[1]);
        return sb.toString();
    }
}
