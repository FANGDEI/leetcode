package top.dyw.leetcode.sort;

public class 快速排序 {

    public static void main(String[] args) {
        int[] nums = {5, 1, 6, 2, 4, 3};

        quickSortLite(nums, 0, nums.length-1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i<j) {
            while (i<j && nums[j] >= pivot) {
                j--;
            }

            while (i<j && nums[i] <= pivot) {
                i++;
            }

            if (i<j) {
                swap(nums, i, j);
            }
        }

        nums[left] = nums[i];
        nums[i] = pivot;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void quickSortLite(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = nums[left];
        int i = left;
        int j = right;

        while (i<j) {
            while (i<j && nums[j] >= pivot) {
                j--;
            }

            while (i<j && nums[i] <= pivot) {
                i++;
            }

            if (i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[left] = nums[i];
        nums[i] = pivot;

        quickSortLite(nums, left, i-1);
        quickSortLite(nums, i+1, right);
    }



}
