package top.dyw.leetcode.algorithm.sort;

/**
 * @author Devil
 * @since 2022-08-22-11:50
 */
@SuppressWarnings("all")
public class 归并排序 {
    public static void main(String[] args) {
        int[] ints = {5, 2, 4, 6, 1, 3};
        new 归并排序().mergeSort(ints,0,5);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

    /**
     * 归并排序
     * @param nums
     * @param p
     * @param r
     */
    public void mergeSort(int[] nums, int p, int r){
        if (p<r){
            int q = p+(r-p)/2;
            //通过mergeSort不断切分 直到分到最小单位
            mergeSort(nums,p,q);
            mergeSort(nums,q+1,r);
            //在通过merge函数一层一层地将数组排序
            merge(nums,p,q,r);
        }
    }

    private void merge(int[] nums, int p, int q, int r) {
        //初始化两个数组 方便后面合并 帮助nums排序
        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        //将对应区间的值存入新的数组中
        for (int i = 0; i < n1; i++) {
            L[i] = nums[p+i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = nums[q+i+1];
        }
        //为数组末尾添加哨兵牌 防止合并时越界
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        //按序合并
        for (int k = p; k <= r; k++) {
            if (L[i]<=R[j]){
                nums[k] = L[i];
                i++;
            }else{
                nums[k] = R[j];
                j++;
            }
        }
    }
}
