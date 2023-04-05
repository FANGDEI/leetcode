package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-08-29-11:16
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
@SuppressWarnings("all")
public class L26删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2};
        int i = new L26删除有序数组中的重复项().removeDuplicates(ints);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.println(ints[j]);
        }
    }

    /**
     * 双指针 两层for循环时间复杂度较高
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //画图就很好理解
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow]!=nums[fast]){
                nums[++slow] = nums[fast];
            }
        }
        return ++slow;
    }
}
