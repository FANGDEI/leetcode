package com.feng.面试题.奇安信.选择题;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static List<Point> maxIncomeProducts(List<Point> products, int months) {
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

        List<Point> ans = new ArrayList<>();
        for (int i = 0; i < path.get(months).size(); i++) {
            ans.add(products.get(path.get(months).get(i)));
        }

        return ans;
    }


    public static void main(String[] args) {
        List<Point> products = new ArrayList<>();
        products.add(new Point(1, 2));
        products.add(new Point(2, 3));
        products.add(new Point(3, 4));
        products.add(new Point(4, 5));
        int months = 6;

        List<Point> result = maxIncomeProducts(products, months);
        for (Point p : result) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}