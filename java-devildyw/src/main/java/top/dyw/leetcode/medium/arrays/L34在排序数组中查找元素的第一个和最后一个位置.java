package top.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-08-28-10:25
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 */
@SuppressWarnings("all")
public class L34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        System.out.println(new L34在排序数组中查找元素的第一个和最后一个位置().searchRange02(new int[]{1,3,4}, 2));
    }

    /**
     * 查找第一个元素
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1, second = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                first = mid;
                right = mid - 1;
            }
        }
        if (first==-1){
            return new int[]{first, second};
        }
        for (int i = first; i < nums.length; i++) {
            if (nums[i] == target) {
                second = i;
            }
        }

        System.out.println(first + " " + second);
        return new int[]{first, second};
    }

    /**
     * 查找边界法 查找不包括target的左右区间
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange01(int[] nums, int target) {
        int left = getLeftBorder(nums, target);
        int right = getRightBorder(nums,target);
        System.out.println(left+" "+right);
        //target不在数组中 并且target在的大小在数组的边界外 就会出现某一个边界为-2 直接返回-1,-1
        if (left==-2||right==-2){
            return new int[]{-1,-1};
        }
        //right - left >1 所以right 与 left之间至少有一个数 这个数就是target 返回结果
        if (right - left > 1){
            return new int[]{left+1,right-1};
        }
        //target不在数组中 并且target的大小在数组的范围内
        return new int[]{-1,-1};
    }

    /**
     * 查找不包含target的右区间
     * @param nums
     * @param target
     * @return
     */
    private int getRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int rightBorder = -2;

        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]>target){
                right = mid-1;
            }else{ //当nums[mid]<=target时更新 rightBorder target在当前mid的右侧 我们要寻找到它右侧边界 又因为rightBorder为left+1 所以循环退出时 rightBorder一定是target右边的那个数字  左边界同理
                left = mid+1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    /**
     * 查找不包含target的左区间
     * @param nums
     * @param target
     * @return
     */
    private int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int leftBorder = -2;

        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]>=target){
                right = mid-1;
                leftBorder = right;
            }else{
                left = mid+1;
            }
        }
        return leftBorder;
    }

    public int[] searchRange02(int[] nums, int target) {
        //1. 分析边界条件（三种情况）
        // 寻找左右边界
        int rightBorder = searchRangeRight(nums, target);
        int leftBorder = searchRangeLeft(nums, target);
        System.out.println(leftBorder+" "+ rightBorder);
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }

        if (rightBorder - leftBorder > 1){
            return new int[]{leftBorder + 1, rightBorder - 1};
        }

        return new int[]{-1, -1};
    }

    private int searchRangeLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] >= target){
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }

    private int searchRangeRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
}
