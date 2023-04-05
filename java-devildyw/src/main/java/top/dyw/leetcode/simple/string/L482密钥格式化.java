package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-29-12:33
 * <p>
 * 给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。
 * 字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
 * <p>
 * 我们想要重新格式化字符串s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，
 * 但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
 * <p>
 * 返回 重新格式化的许可密钥 。
 */
@SuppressWarnings("all")
public class L482密钥格式化 {
    public static void main(String[] args) {
        System.out.println(new L482密钥格式化().licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    /**
     * 先将字母字符收集 再更具间隙加"-"
     *
     * @param s
     * @param k
     * @return
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '-') {
                //只添加字母字符
                continue;
            }
            //小写转化为大写 如果是大写就不变
            sb.append((c >= 'a' && c <= 'z') ? (char) (c - 32) : c);
        }
        int len = sb.length() - k;
        while (len > 0) {
            sb.insert(len, "-");
            len -= k;
        }

        return sb.toString();
    }
}
