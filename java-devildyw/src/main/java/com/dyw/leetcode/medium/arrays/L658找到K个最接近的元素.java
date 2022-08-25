package com.dyw.leetcode.medium.arrays;

import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Devil
 * @since 2022-08-25-11:06
 */
@SuppressWarnings("all")
public class L658找到K个最接近的元素 {
    public static void main(String[] args) {
        System.out.println(new L658找到K个最接近的元素().findClosestElements01(new int[]{1, 2, 3, 4, 5}, 1, 3));
    }

    /**
     * 排序
     *
     * 按照题目要求进行排序
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }

        Collections.sort(list,(a,b)->{
            if (Math.abs(a-x)!=Math.abs(b-x)){
                return Math.abs(a-x) - Math.abs(b-x);
            }else{
                return a-b;
            }
        });

        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }

    /**
     * 二分查找 + 双指针
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements01(int[] arr, int k, int x) {
        /*
        将数组分为两个部分 一部分小于x 另一部分大于等于x 通过二分查找找到这个大于等于的点即right 而在它附近 right-1就是另一个区间 left
        因为数组已经排好序了,我们只需要从中间向外扩延 找到差值最小的元素下标范围即可
         */
        int right = binarySearch(arr,x);
        int left = right - 1;
        System.out.println(left+" "+right);
        while (k-->0){
            //如果left已经小于0了 便只需要增加right即可
            if (left<0){
                right++;
                //如果right范围越界了 也只需要减小left
            }else if (right>=arr.length){
                left--;
            }//除去上面两种情况 根据插值扩大某一边的范围
            else if (x-arr[left]<=arr[right]-x){
                left--;
            }else{
                right++;
            }
        }
        //获得范围后将结果存在list中 返回
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left+1; i < right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    private int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low<high){
            int mid = low + (high - low) /2;
            if (arr[mid]>=x){
                high = mid;
            }else if (arr[mid] < x){
                low = mid+1;
            }
        }
        return low;
    }
}
