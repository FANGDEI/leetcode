package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-26-12:49
 */
@SuppressWarnings("all")
public class BM17二分查找I {

    public static void main(String[] args) {
        System.out.println(Math.pow(2,24));
    }

    public int search (int[] nums, int target) {
        // write code here
        int left = 0, right = nums.length-1;
        while (left<=right){
            int mid = (right-left)/2 + left;
            if (nums[mid]<target){
                left = mid+1;
            }else if (nums[mid]>target){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
