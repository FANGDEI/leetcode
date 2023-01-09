package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-28-11:58
 */

@SuppressWarnings("all")
public class BM20数组中的逆序对 {

    public static void main(String[] args) {
        System.out.println(new BM20数组中的逆序对().InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }

    /**
     * 暴力
     * @param array
     * @return
     */
//    public int InversePairs(int [] array) {
//        int mod = 1000000007;
//
//        int result = 0;
//        int n = array.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (array[i]>array[j]){
//                    result++;
//                }
//            }
//        }
//        return result%mod;
//    }


    int mod = 1000000007;
    /**
     * 利用归并排序来计算逆序对
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        int n = array.length;
        int[] res = new int[n];
        return mergeSort(0,n-1,array,res);
    }

    private int mergeSort(int left, int right, int[] data, int[] temp) {

        //停止划分
        if (left>=right){
            return 0;
        }
        //取中间
        int mid = (right-left)/2+left;
        //左右划分
        int res = mergeSort(left,mid,data,temp)+mergeSort(mid+1,right,data,temp);
        //防止溢出
        res%=mod;
        int i = left,j=mid+1;
        for (int k=left;k<=right;k++){
            temp[k] = data[k];
        }

        for (int k = left; k <= right; k++) {
            if (i==mid+1){
                data[k] = temp[j++];
            }else if (j==right+1||temp[i]<=temp[j]){
                data[k] =temp[i++];
            }
            //左边比右边大，答案增加
            else{
                data[k] = temp[j++];
                //统计逆序对
                res+=mid-i+1;
            }
        }
        return res%mod;
    }
}
