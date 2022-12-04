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
    int res;
    /**
     * 回溯
     * @param baseCosts
     * @param toppingCosts
     * @param target
     * @return
     */
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        //获取最小值作为初始res值
        res = Arrays.stream(baseCosts).min().getAsInt();
        for (int baseCost : baseCosts) {
            dfs(toppingCosts,0,baseCost,target);
        }
        return res;
    }

    private void dfs(int[] toppingCosts, int i, int curCost, int target) {
        //res与target差值的绝对值 小于 curCost - target 的差值 直接返回
        if (Math.abs(res-target)<curCost-target){
            return;
        }else if (Math.abs(res-target)>=Math.abs(curCost-target)){
            //去最小差值的那个
            if (Math.abs(res-target)>Math.abs(curCost-target)){
                res = curCost;
            }else{
                //如果差值绝对值相同 那么取最小的（成本相对较低的）
                res = Math.min(res,curCost);
            }
        }

        //如果 指针已经走完 toppingCosts 数组 那么返回
        if (i==toppingCosts.length){
            return;
        }

        //同一种配料最多加两次
        dfs(toppingCosts,i+1,curCost+toppingCosts[i]*2,target);
        //添加多种配料
        dfs(toppingCosts,i+1,curCost+toppingCosts[i],target);
        //不添加配料的情况
        dfs(toppingCosts,i+1,curCost,target);
    }
}
