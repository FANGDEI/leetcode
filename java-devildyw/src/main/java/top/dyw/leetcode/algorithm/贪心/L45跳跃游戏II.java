package top.dyw.leetcode.algorithm.贪心;

/**
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author Devil
 * @since 2022-10-20-14:18
 */
@SuppressWarnings("all")
public class L45跳跃游戏II {

    public static void main(String[] args) {
        System.out.println(new L45跳跃游戏II().jump(new int[]{1, 2, 1, 1, 1}));
    }


    /**
     * 参考了L55跳跃游戏 思路相似 都是求覆盖范围 但这道题更难
     * <p>
     * 贪心： 局部最优：当前可移动的距离尽可能多走，如果还没到终点，步数再加一。整体最优：一步尽可能多走，从而达到最小步数。
     * <p>
     * 从覆盖范围出发，不管怎么跳，覆盖范围是一定可以跳到的，以最小的步数增加覆盖范围，覆盖范围一旦覆盖了终点，那么得到的就一定是最小步数、
     * <p>
     * 如果移动下标达到了当前这一步的最大覆盖范围的最远距离了，还没有到终点的话，就必须再增加一个步数来增加覆盖范围，直到覆盖范围覆盖终点
     * <p>
     * 注意：这里的覆盖范围里面的每一个点都可以是你的一步可以到达的地方，所以每次当移动下标到达当前这一步的最大覆盖范围时，还没有到达终点时，就必须新走一步来更新覆盖范围了。 这一步是从当前这步覆盖范围内的某一个位置走的
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        //记录跳跃次数
        int count = 0;
        //当前这一步覆盖的最大区域
        int curDistance = 0;
        //下一步能走到的最大覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新下一步能走到的最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }

            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

}
