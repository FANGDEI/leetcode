package com.dyw.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-12-04-12:51
 */
@SuppressWarnings("all")
public class L1774最接近目标价格的甜点成本 {

    public static void main(String[] args) {

    }

    //todo: 以后做
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int minAbs = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(baseCosts);
        Arrays.sort(toppingCosts);

        for (int i = 0; i < baseCosts.length; i++) {
            for (int j = 0; j < toppingCosts.length; j++) {
                result += toppingCosts[j];
            }
        }
        return 0;
    }
}
