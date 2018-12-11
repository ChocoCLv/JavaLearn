package com.choco.leetcode;

/**
 * Q123 买卖股票的最佳时机3
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfitIII {
    int M[][];

    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int[] g = new int[3];
        int[] l = new int[3];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = 2; j > 0; j--) {
                l[j] = Math.max(g[j - 1] + Math.max(diff, 0), l[j] + diff);
                g[j] = Math.max(l[j], g[j]);
            }
        }
        return g[2];
    }

    /***
     * @param day 当前是第几天
     * @param hold 当前持有的是第几天买入的股票,hold=-1表示没有股票可以卖出
     * @param num 剩余的交易次数
     * @return
     */
    private int OPT(int[] prices, int day, int hold, int num) {
        if (num == 0 || day == prices.length)
            return 0;

        if (hold != -1
                && (prices[day] > prices[hold])) {
            //只能卖出或不交易
            return Math.max(prices[day] - prices[hold] + OPT(prices, day + 1, -1, num - 1),
                    OPT(prices, day + 1, hold, num));
        } else {
            //只能买入或不交易
            if (M[day][num] != 0) {
                return M[day][num];
            }

            if (day > 0 && day < prices.length - 1) {
                if (prices[day] <= prices[day - 1] && prices[day] <= prices[day + 1])
                    M[day][num] = Math.max(OPT(prices, day + 1, day, num), OPT(prices, day + 1, -1, num));
            } else if (day == 0 && prices[day] < prices[day + 1]) {
                M[day][num] = Math.max(OPT(prices, day + 1, day, num), OPT(prices, day + 1, -1, num));
            } else {
                M[day][num] = OPT(prices, day + 1, -1, num);
            }
            return M[day][num];
        }
    }
}
