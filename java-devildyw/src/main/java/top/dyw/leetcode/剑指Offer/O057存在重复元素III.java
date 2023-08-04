package top.dyw.leetcode.剑指Offer;

import java.util.Map;
import java.util.TreeSet;

/**
 * @author Devildyw
 * @date 2023/08/04 15:03
 **/
@SuppressWarnings("all")
public class O057存在重复元素III {

    public static void main(String[] args) {

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            //ceiling 找出大于等于给定元素的最小元素  |nums[i]-nums[j]|<=t  ==>  nums[i]-t<=nums[j]<=nums[i]+t
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling!=null && ceiling <= (long) nums[i] + (long) t){
                return true;
            }

            set.add((long) nums[i]);
            if (i>=k){ //滑动窗口  控制 Math(i-j) <= k
                set.remove((long) nums[i-k]);
            }

        }

        return false;

    }
}
