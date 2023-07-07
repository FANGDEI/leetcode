package top.dyw.leetcode.剑指Offer;

import java.util.Collections;
import java.util.List;

/**
 * @author Devildyw
 * @date 2023/07/07 11:21
 **/
@SuppressWarnings("all")
public class OII035最小时间差 {

    public static void main(String[] args) {

    }

    public int findMinDifference(List<String> timePoints) {
        //先排序
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0)); //获取分钟数 这里我们都把字符串转换为分钟数
        int preMinutes = t0Minutes;

        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans,minutes-preMinutes);
            preMinutes = minutes;
        }

        ans = Math.min(ans,t0Minutes+1440-preMinutes); //首尾时间的时间差 可能首尾之间差了一天 1440 刚好是一天的分钟数
        return ans;
    }

    private int getMinutes(String t) {
        return ((t.charAt(0)-'a')*10+(t.charAt(1)-'0'))*60+(t.charAt(3)-'0')*10+(t.charAt(4)-'0');
    }
}
