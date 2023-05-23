package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/13 22:58
 **/
@SuppressWarnings("all")
public class O39数组中出现次数超过一半的数字 {

    public static void main(String[] args) {

    }

    /**
     * 摩尔投票
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums) {
            //找出出现次数最多的那个数 投票法
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }

        for (int num : nums) {
            if (x == num) count++;
        }
        return count > nums.length / 2 ? x : 0;
    }

    /**
     * 摩尔投票复盘
     * @param nums
     * @return
     */
    public int majorityElement_re(int[] nums) {
        int x = 0, votes = 0, count = 0;
        //投票 投票得到的x是在整个数组中出现次数最多的数字（众数）
        for (int num : nums) {
            if (votes==0) x = num; //初始化
            votes += x==num ? 1:-1;
        }

        //找出这个出现最多的数在数组中的出现次数
        for (int num : nums) {
            if (num==x) count++;
        }

        //如果count>数组长度的一半则返回
        return count>nums.length/2?x:0;
    }
}
