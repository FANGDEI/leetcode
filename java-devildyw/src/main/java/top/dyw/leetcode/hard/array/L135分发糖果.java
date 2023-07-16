package top.dyw.leetcode.hard.array;

/**
 * @author Devildyw
 * @date 2023/07/16 11:28
 **/
@SuppressWarnings("all")
public class L135分发糖果 {

    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        //从左往右遍历，遇到分数更高的+1;
        for (int i = 0; i < n; i++) {
            if (i>0&&ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }else {
                left[i] = 1;
            }
        }

        //从右往左遍历，遇到分数更高的+1;
        for (int i = n-1; i>=0; i--){
            if (i<n-1&&ratings[i]>ratings[i+1]){
                right[i] = right[i+1]+1;
            }else{
                right[i] = 1;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.max(left[i],right[i]);
        }

        return result;
    }
}
