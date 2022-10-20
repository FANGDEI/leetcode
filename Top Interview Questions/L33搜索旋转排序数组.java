public class L33搜索旋转排序数组 {
    class Solution {
        int target;
        int[] nums;
        int ans=-1;
        public int search(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
            int left = 0, right = nums.length - 1;
            process(left,right);
            return ans;
        }

        public void process(int left, int right) {
            int mid = left + (right - left) / 2;
            if(left>right){
                return;
            }
            // System.out.print(mid);
            if (nums[mid] == target) {
                ans=mid;
            } else if (nums[mid] < nums[right]) {
                if (mid<nums.length-1&&nums[mid + 1] <= target && nums[right] >= target) {
                    process(mid+1,right);
                }else{
                    process(left,mid-1);
                }
            } else if (nums[mid] > nums[right]  ) {
                if(mid>0&&nums[mid -1] >= target && nums[left] <= target){
                    process(left,mid-1);
                }else{
                    process(mid+1,right);
                }
            }
        }
    }
}
