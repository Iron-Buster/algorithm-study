package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/3 16:21
 **/
public class LC_1475 {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] right = new int[n];
        var stk = new ArrayDeque<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && prices[stk.peek()] > prices[i]) {
                stk.pop();
            }
            right[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        for (int i = 0; i < n; i++) {
            prices[i] = right[i] == -1 ? prices[i] : prices[i] - prices[right[i]];
        }
        return prices;
    }

//    1475. 商品折扣后的最终价格
//    第 28 场双周赛
//            Q1
//    1212
//    相关标签
//            相关企业
//    提示
//    给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
//
//    商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
//
//    请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
//
//
//
//    示例 1：
//
//    输入：prices = [8,4,6,2,3]
//    输出：[4,2,4,2,3]
//    解释：
//    商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
//    商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
//    商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
//    商品 3 和 4 都没有折扣。
}
