package com.feng.面试题;

import java.util.*;

/*
 * public class Point {
 *   int x;
 *   int y;
 *   public Point(int x, int y) {
 *     this.x = x;
 *     this.y = y;
 *   }
 * }
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 获取最大收益理财产品组合
     * @param products Point类ArrayList 理财产品数据列表
     * @param months int整型 总投入月份
     * @return Point类ArrayList
     */
    public ArrayList<Point> maxIncomeProducts(ArrayList<Point> products,
                                              int months) {
        // write code here
        int n = products.size();
        List<Integer> dp = new ArrayList<>(months + 1);
        List<List<Integer>> path = new ArrayList<>(months + 1);
        for (int i = 0; i <= months; i++) {
            dp.add(0);
            path.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = products.get(i).x; j <= months; j++) {
                if (dp.get(j - products.get(i).x) + products.get(i).y > dp.get(j)) {
                    dp.set(j, dp.get(j - products.get(i).x) + products.get(i).y);
                    path.set(j, new ArrayList<>(path.get(j - products.get(i).x)));
                    path.get(j).add(i);

                }
            }
        }
        ArrayList<Point> ans = new ArrayList<>();
        for (int i = 0; i < path.get(months).size(); i++) {
            ans.add(products.get(path.get(months).get(i)));
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Point> products = new ArrayList<>();
//        [(1,235),(3,902),(6,1873),(9,3654)],7
        products.add(new Point(1,235));
        products.add(new Point(3,902));
        products.add(new Point(6,1873));
        products.add(new Point(9,3654));
        ArrayList<Point> points = new Solution().maxIncomeProducts(products, 7);
    }
}
