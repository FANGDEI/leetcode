package top.dyw.leetcode.medium.string;

/**
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 *
 * @author Devil
 * @since 2022-10-02-12:09
 */
@SuppressWarnings("all")
public class L777在LR字符串中交换相邻字符 {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i<n&&j<n){
                if (start.charAt(i)!=end.charAt(j)){
                    return false;
                }
                char c = start.charAt(i);
                /**
                 * 如果一个字符 \text{`L'}‘L’ 左侧的相邻字符是 \text{`X'}‘X’，则将字符 \text{`L'}‘L’ 向左移动一位，将其左侧的 \text{`X'}‘X’ 向右移动一位；
                 *
                 * 如果一个字符 \text{`R'}‘R’ 右侧的相邻字符是 \text{`X'}‘X’，则将字符 \text{`R'}‘R’ 向右移动一位，将其右侧的 \text{`X'}‘X’ 向左移动一位。
                 *
                 */
                if ((c=='L'&&i<j)||(c=='R'&&i>j)){
                    return false;
                }
                i++;
                j++;
            }
        }
        /**
         * 如果 ii 和 jj 中有一个下标大于等于 nn，则有一个字符串已经遍历到末尾，继续遍历另一个字符串中的其余字符，如果其余字符中出现非 \text{`X'}‘X’ 的字符，则该字符不能与任意字符匹配，返回 \text{false}false。
         */
        while (i<n){
            if (start.charAt(i)!='X'){
                return false;
            }
            i++;
        }

        while (j<n){
            if (end.charAt(j)!='X'){
                return false;
            }
            j++;
        }

        /**
         * 如果 \textit{start}start 和 \textit{end}end 遍历结束之后没有出现不符合移动操作的情况，则可以经过一系列移动操作将 \textit{start}start 转换成 \textit{end}end，返回 \text{true}true。
         */
        return true;
    }
}
