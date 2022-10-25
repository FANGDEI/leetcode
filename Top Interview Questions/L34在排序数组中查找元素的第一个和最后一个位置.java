public class L34在排序数组中查找元素的第一个和最后一个位置 {
    class Solution {
        //    public int[] searchRange(int[] nums, int target) {
//        int[] ans = {-1, -1};
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                ans[0] = i;
//                break;
//            }
//        }
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] == target) {
//                ans[1] = i;
//                break;
//            }
//        }
//        return ans;
//    }
//    public int[] searchRange(int[] nums, int target) {
//        int[] ans = {-1, -1};
//        int l = 0, r = nums.length - 1, mid = -1;
//        while (l < r) {
//            mid = l + (r - l) / 2;
//            if (nums[mid] == target) {
//                break;
//            } else if (nums[mid] > target) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        if (mid != -1) {
//            r = mid;
//            l = mid;
//            while (nums[r] == target) {
//                r++;
//            }
//            ans[1] = r - 1;
//            while (nums[l] == target) {
//                l--;
//            }
//            ans[0] = l + 1;
//        }
//        return ans;
//    }

        public int[] searchRange(int[] nums, int target) {
            int leftIdx = binarySearch(nums, target, true);
            int rightIdx = binarySearch(nums, target, false) - 1;
            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
                return new int[]{leftIdx, rightIdx};
            }
            return new int[]{-1, -1};
        }

        public int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }

    }
}
