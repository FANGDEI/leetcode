//package com.feng.面试题.奇安信;
//
//import java.util.*;
//
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param planks int整型一维数组
//     * @return bool布尔型
//     */
//    public boolean CheckSquare(int[] planks) {
//        // write code here
//
//
//        return false;
//    }
//
//    private static boolean 暴力2(int[] planks) {
//        Arrays.sort(planks);
//        int ans = 0;
//        for (int i = 3; i < planks.length; i++) {
//            if (planks[i - 3] == planks[i - 2] && planks[i] == planks[i - 1] && planks[i] == planks[i - 2]) {
//                return true;
//            }
//        }
////        return ans;
//        return false;
//    }
//
//    private static boolean 暴力不行(int[] planks) {
//        Arrays.sort(planks);
//        int ans = 0;
//        for (int i = 0; i < planks.length; ) {
//            for (int j = i; j < i + 3 && j < planks.length; j++) {
//                if (planks[j] != planks[j + 1]) {
//                    ans++;
//                    i++;
//                    break;
//                }
//                if (j == i + 2) {
////                    return true;
//                    i += 4;
//                }
//            }
//        }
////        System.out.println("ans = " + ans);
////        return ans;
//        return ans < 4;
//    }
//
//    public ArrayList<Point> maxIncomeProducts(ArrayList<Point> products, int months) {
//        // write code here
//        int n = products.size();
//        List<Integer> dp = new ArrayList<>(months + 1);
//        List<List<Integer>> path = new ArrayList<>(months + 1);
//        for (int i = 0; i <= months; i++) {
//            dp.add(0);
//            path.add(new ArrayList<>());
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = products.get(i).x; j <= months; j++) {
//                if (dp.get(j - products.get(j).x) + products.get(i).y > dp.get(j)) {
//                    dp.set(j, dp.get(j - products.get(i).x) + products.get(i).y);
//                    path.set(j, new ArrayList<>(path.get(j - products.get(i).x)));
//                    path.get(j).add(i);
//                }
//            }
//        }
//        List<Point> ans = new ArrayList<>();
//        for (int i = 0; i < path.get(months).size(); i++) {
//            ans.add(products.get(path.get(months).get(i)));
//        }
//
//        return ans;
//    }
//}
//
//
//}