package top.dyw.leetcode.Hot100;

public class L4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        // 将两个数组统一划分为左边和右边两半 左边至少比右边多一个（奇数）
        int m = nums1.length;
        int n = nums2.length;

        // 左边总个数
        int totalLeft = (m + n + 1) / 2;
        // 找到了i在哪里 就能确定j 所以这里再nums1中找就行 (i+j = (m + n + 1)/2) i,j 分别为两个数组在右边元素的第一个值
        int left = 0;
        int right = m;

        while (left < right) {
            // +1 防止死循环
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;

            if (nums1[i-1] > nums2[j]) {
                right = i-1;
            } else {
                // 在满足条件的情况下尽可能让i多贡献一点 防止出现 nums[j-1] > nums[i] 的情况
                // nums1[i-1] <= nums2[j] 如果你 left = i+1 可能就大于了
                left = i;
            }
        }
        // left的位置就是i的位置
        int i = left;
        int j = totalLeft - i;

        // 处理边界值
        int nums1LeftMax =  (i==0)? Integer.MIN_VALUE : nums1[i-1];
        int nums1RightMin = (i==m)? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = (j==0) ? Integer.MIN_VALUE : nums2[j-1];
        int nums2RightMin = (j==n) ? Integer.MAX_VALUE : nums2[j];

        // 找出左边阵营最大值
        int maxLeft = Math.max(nums1LeftMax, nums2LeftMax);

        if ((m+n)%2==1) {
            return (double) maxLeft;
        }

        int minRight = Math.min(nums1RightMin, nums2RightMin);

        return (maxLeft + minRight) / 2.0;

    }
}
