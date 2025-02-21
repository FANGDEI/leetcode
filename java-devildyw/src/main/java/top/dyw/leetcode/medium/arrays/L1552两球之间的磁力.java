package top.dyw.leetcode.medium.arrays;

import java.util.Arrays;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/02/14 10:10
 **/
@SuppressWarnings("all")
public class L1552两球之间的磁力 {

    public static void main(String[] args) {

    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1; // 最小距离最大磁力
        int hi = (position[position.length-1] - position[0]) / (m-1); //最小距离最大磁力
        int ans = 0;
        while (lo <= hi){
            int mid = lo + ((hi - lo) >> 2);
            //如果mid磁力值下能放置多余m个球 那么往右寻找
            if (check(position, m, mid)){
                ans = mid;
                lo = mid +1;
            }else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int[] position, int m, int mid) {
        int count = 1; //第一个位置放置一颗球
        int prev = position[0]; //放在 i=0 的为孩子

        for (int i =1; i < position.length; i++) {
            if (position[i] - prev >= mid){ //间距每隔mid就放置一颗球
                count ++;//记录放置的球的个数
                prev = position[i]; //更新prev
                if (count >= m){ //如果可以放置多余m个球 返回true
                    return true;
                }
            }
        }
        return count>=m;
    }

}
