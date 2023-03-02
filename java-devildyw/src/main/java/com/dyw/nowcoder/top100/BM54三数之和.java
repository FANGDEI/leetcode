package com.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Devil
 * @since 2023-02-06-14:12
 */
@SuppressWarnings("all")
public class BM54三数之和 {

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int n = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(num);
        for (int first = 0; first < n; first++) {
            if (first>0&&num[first]==num[first-1]){
                continue;
            }

            int third = n-1;
            int target = -num[first];

            for (int second = first+1; second < n; second++) {
                if (second!=first+1&&num[second]==num[second-1]){
                    continue;
                }

                while (second<third&&num[second]+num[third]>target){
                    third--;
                }

                if (second==third){
                    break;
                }

                if (num[second]+num[third]==target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[first]);
                    list.add(num[second]);
                    list.add(num[third]);
                    result.add(list);
                }

            }
        }
        return result;

    }
}
