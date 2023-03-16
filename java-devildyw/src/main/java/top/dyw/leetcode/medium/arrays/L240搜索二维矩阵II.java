package top.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-28-11:48
 * <p>
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
@SuppressWarnings("all")
public class L240搜索二维矩阵II {
    public static void main(String[] args) {

    }

    /**
     * 二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int index = search(ints, target);
            if (index>=0){
                return true;
            }
        }
        return false;
    }

    private int search(int[] ints, int target) {
        int low = 0, high = ints.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ints[mid] == target) {
                return mid;
            } else if (ints[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
