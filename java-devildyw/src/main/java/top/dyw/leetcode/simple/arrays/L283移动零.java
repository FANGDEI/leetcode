package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-03-12:36
 * <p>
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
@SuppressWarnings("all")
public class L283移动零 {

    public static void main(String[] args) {
        new L283移动零().moveZeroes_re(new int[]{0,1,0,3,12});
    }

    /**
     * <p>
     * 通过第一次遍历将非零元素将非零元素覆盖整个数组 再通过第二次遍历将index(覆盖后的数组中非零元素的下一个下标)后的元素全部变为0
     * </p>
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        //记录覆盖后数组的非零元素的下表
        int index = 0;
        //遍历数组 覆盖元素
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        //将index后的元素填为0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public void moveZeroes01(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        //结尾填零
        while (index++ < nums.length) {
            nums[index] = 0;
        }
    }

    /**
     * 将非零元素全部按顺序全部移到最前面 然后在末尾添0 双指针
     * @param nums
     */
    public void moveZeroes02(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=0){
                nums[slow++] = nums[fast];
            }
        }

        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }

    }

    public void moveZeroes_re(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public void moveZeroes03(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }

        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }

    public void moveZeroes04(int[] nums) {
        int k = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[k++] = nums[fast];
            }
        }
        for (; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}
