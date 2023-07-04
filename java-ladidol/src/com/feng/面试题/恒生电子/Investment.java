package com.feng.面试题.恒生电子;

public class Investment {
    public static void main(String[] args) {
        double money = 10000;  // 初始资金
        double[] price = {1, 2, 1, 2, 2, 3, 2};  // 股票价格
        int k = 2;  // 最大交易次数
        double profit = 0;  // 投资收益
        for (int i = 0; i < price.length - 1; i++) {
            if (price[i + 1] > price[i]) {  // 股票价格上涨，购买股票
                double buyNum = Math.min(money, money / price[i]);  // 购买股票的数量
                profit -= buyNum * price[i];  // 购买股票的花费
                money -= buyNum * price[i];  // 购买股票后的剩余资金
            } else if (price[i + 1] < price[i]) {  // 股票价格下跌，卖出股票
                double sellNum = Math.min(k, money / price[i]);  // 卖出股票的数量
                profit += sellNum * price[i];  // 卖出股票的收益
                money += sellNum * price[i];  // 卖出股票后的剩余资金
                k--;  // 已经卖出一次股票
            }
            if (k == 0) {  // 已经达到最大交易次数，停止交易
                break;
            }
        }
        System.out.println("最终资产为: " + (profit + money));
    }
}