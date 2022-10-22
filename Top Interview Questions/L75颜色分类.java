public class L75颜色分类 {
    class Solution {

        public void sortColors(int[] nums) {
            int k=nums.length;
            while(k!=0){
                int max=0;
                for(int i=0;i<k;i++){
                    if(nums[max]>nums[i]){
                        int a=nums[i];
                        nums[i]=nums[max];
                        nums[max]=a;
                        max=i;
                    }else{
                        max=i;
                    }
                }
                k--;
            }
        }
    }
//    题解
//    class Solution {
//        public void sortColors(int[] nums) {
//            int N = nums.length;
//            int zero = -1;
//            int two = N;
//            int i = 0;
//            while (i < two) {
//                if (nums[i] < 1) {
//                    swap(nums, i++, ++zero);
//                } else if (nums[i] > 1) {
//                    swap(nums, i, --two);
//                } else {
//                    i++;
//                }
//            }
//        }
//
//        private static void swap(int[] nums, int i, int j) {
//            int tmp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = tmp;
//        }
//    }

}
