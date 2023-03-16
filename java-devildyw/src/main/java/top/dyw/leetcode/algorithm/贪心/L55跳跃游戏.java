package top.dyw.leetcode.algorithm.贪心;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 *
 * @author Devil
 * @since 2022-10-20-13:57
 */
@SuppressWarnings("all")
public class L55跳跃游戏 {

    public static void main(String[] args) {

    }

    /**
     * 我们每次取最大的跳跃长度，这个就是可以条约的最大范围
     * 将问题转化为跳跃覆盖范围是否可以覆盖终点
     *
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        //初始化覆盖范围为0
        int coverRange = 0;
        //在遍历数组的过程中更新最大的覆盖范围 （每次都取跳跃的最大长度）  coverRange = i+nums[i]
        //以覆盖范围的边界作为遍历的边界 也代表了跳跃的最大限度
        for (int i = 0; i <= coverRange; i++) {
            //更新覆盖范围
            coverRange = Math.max(coverRange,i+nums[i]);
            //如果覆盖范围可以到达最后一个下标
            if (coverRange>=nums.length-1){
                return true;
            }
        }

        return false;


    }

    public boolean canJump01(int[] nums) {
        if (nums.length==1){
            return true;
        }

        int coverRange = 0;

        for (int i = 0; i<=coverRange; i++){
            coverRange = Math.max(coverRange,i+nums[i]);
            if (coverRange>=nums.length-1){
                return true;
            }
        }

        return false;
    }
}
