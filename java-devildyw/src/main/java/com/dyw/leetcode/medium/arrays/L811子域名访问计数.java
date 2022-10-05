package com.dyw.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。
 * <p>
 * 计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。
 * <p>
 * 例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
 * 给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案。
 *
 * @author Devil
 * @since 2022-10-05-13:31
 */
public class L811子域名访问计数 {
    public static void main(String[] args) {

    }

    /**
     * 使用 hash 表存储 域名与访问次数的统计
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> list = new ArrayList<>();
        //hash 表
        Map<String, Integer> counts = new HashMap<>();

        //遍历每个字符串
        for (String cpdomain : cpdomains) {
            //找出第一个空格出现的位置 因为访问次数与域名之间隔了一个空格
            int space = cpdomain.indexOf(' ');
            //借助这个空格的位置我们可以很轻松得到访问次数的值
            int count = Integer.valueOf(cpdomain.substring(0, space));
            //通过这个空格我们也能找到第一个域名（最低级域名）
            String domain = cpdomain.substring(space + 1);
            //hash记录
            counts.put(domain, counts.getOrDefault(domain, 0) + count);

            //从前往后 遇到‘.’ 则是一个域名等级的分割点 域名等级一次增加
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    //分割域名
                    String subdomain = domain.substring(i + 1);
                    //hash表存储
                    counts.put(subdomain,counts.getOrDefault(subdomain,0)+count);
                }
            }
        }

        //将 map 输出为数组
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            String subdomain = entry.getKey();
            int count = entry.getValue();
            list.add(count+" "+subdomain);
        }
        return list;
    }
}
