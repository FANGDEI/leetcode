package com.feng.面试题.途虎;

import java.util.ArrayList;
import java.util.List;

public class ServiceSelection {
    private int maxPrice; // 最大的总价格
    private List<Integer> selectedServices; // 已选择的服务
    
    public List<Integer> selectServices(int[] value, int[] time, int A, int B) {
        maxPrice = 0;
        selectedServices = new ArrayList<>();
        dfs(value, time, A, B, 0, 0, new ArrayList<>());
        return selectedServices;
    }
    
    private void dfs(int[] value, int[] time, int A, int B, int totalPrice, int totalTime, List<Integer> currentSelection) {
        // 到达终止条件，即超过了给定金额或时间
        if (totalPrice > A || totalTime > B) {
            return;
        }
        // 更新最大总价格和已选择的服务
        if (totalPrice > maxPrice) {
            maxPrice = totalPrice;
            selectedServices = new ArrayList<>(currentSelection);
        }
        // 遍历每个服务
        for (int i = 0; i < value.length; i++) {
            // 选择当前服务
            currentSelection.add(i);
            // 递归搜索下一个服务
            dfs(value, time, A, B, totalPrice + value[i], totalTime + time[i], currentSelection);
            // 撤销选择当前服务，进行回溯
            currentSelection.remove(currentSelection.size() - 1);
        }
    }

    public static void main(String[] args) {

    }


}
































