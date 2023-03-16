package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-24-14:20
 * <p>
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 */
@SuppressWarnings("all")
public class L704二分查找 {
    public static void main(String[] args) {
        System.out.println(new L704二分查找().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        //初始化left 和 right
        int left = 0, right = n - 1;
        //left不能大于right
        while (left <= right) {
            //计算出mid值
            int mid = (left + right) / 2;
            //如果nums[mid]小于target则说明target再mid右边的部分 则增大left至mid+1
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) { //如果nums[mid]大于target则说明target再mid左边的部分 则增大right至mid-1
                right = mid - 1;
            } else {//相等则返回下标即mid
                return mid;
            }
        }
        //没有找到返回-1
        return -1;
    }
}
