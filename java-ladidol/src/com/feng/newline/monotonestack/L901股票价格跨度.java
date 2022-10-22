package com.feng.newline.monotonestack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: ladidol
 * @date: 2022/10/21 21:27
 * @description: 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * 示例：
 * <p>
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 * <p>
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 * 提示：
 * <p>
 * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
 * 每个测试用例最多可以调用  10000 次 StockSpanner.next。
 * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
 * 此问题的总时间限制减少了 50%。
 */
public class L901股票价格跨度 {
    //单调栈
    class StockSpanner {

        Deque<Integer> stack;
        List<Integer> prePrices;
        int index = -1;

        public StockSpanner() {
            stack = new ArrayDeque<>();
            prePrices = new ArrayList<>();
        }

        /**
         * 参数：[price]
         * 返回值：int
         * 作者： ladidol
         * 描述：为啥我第一感觉是要通过翻转一下数组，再进行寻找下一个最大的数字。
         * 看了眼题解，正序，stack里面维护比当前值大的最近值。如果不满足就把stack给抛出
         */
        public int next(int price) {
            while (!stack.isEmpty() && prePrices.get(stack.peek()) <= price) {//stack中只保留大值
                stack.pop();
            }
            int preIndex = stack.isEmpty() ? -1 : stack.peek();
            index++;
            stack.push(index);//维护单调栈
            prePrices.add(price);
            return index - preIndex;
        }
    }
}