package top.dyw.write_exam.baidu_2023_3_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/03/16 19:47
 **/
@SuppressWarnings("all")
public class B1字符串重排序 {

    /**
     * <a href="https://mp.weixin.qq.com/s?__biz=Mzg4MjkwNzQzNA==&mid=2247484564&idx=1&sn=932aee02fb0a1a2b8c6a7243df5b35f8&chksm=cf4ec4d1f8394dc7a871b45b52a27f36742510f30b827be25d9cc6b8f4877f65aa8eba52cdb7&mpshare=1&scene=23&srcid=0316rMRdVWFGWkNvYazm7Jzs&sharer_sharetime=1678966921154&sharer_shareid=6a316dd55da4a1e8c85b6fe4706c5e9a#rd">题目连接</a>
     * <p>
     * 题目描述：
     * 小红拿到了一个字符串，她想知道这个字符串能否通过重新排列组成 Baidu 字符串？
     * 注：必须大小写完全相同。共有 t 组询问。
     *-------------------------------------------------------------------------
     * 输入描述：
     * 第一行输入一个正整数 t ，代表询问次数。
     *
     * 接下来的 t 行，每行输入一个仅包含英文字母的字符串。
     *
     * 所有字符串的长度之和保证不超过 200000 。
     * -------------------------------------------------------------------------
     * 输出描述:
     * 对于每次询问，输出一行答案。如果可以通过重新排列组成 Baidu，则输出 Yes ，否则输出 No 。
     *
     */

    public static void main(String[] args) throws IOException {
        /**
         * 思路：对字符串排序，然后判断是否与”Baidu“排序之后是否相同即可
         */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t =  Integer.valueOf(input.readLine());

        final String baidu_str = "Baidu";
        char[] baidu_chars = baidu_str.toCharArray();
        Arrays.sort(baidu_chars);

        String[] input_strs = new String[t];
        for (int i = 0; i < t; i++) {
            input_strs[i] = input.readLine();
        }

        for (int i = 0; i < t; i++) {
            if (input_strs[i].equals(baidu_str)){
                System.out.println("Yes");
                continue;
            }
            char[] chars = input_strs[i].toCharArray();
            Arrays.sort(chars);
            if (Arrays.equals(chars,baidu_chars)){
                System.out.println("Yes");
                continue;
            }
            System.out.println("No");
        }



    }


}
