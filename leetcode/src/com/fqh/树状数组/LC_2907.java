package com.fqh.树状数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 10:28
 **/
public class LC_2907 {

//    2907. 价格递增的最大利润三元组 I
//    中等
//            相关标签
//    相关企业
//            提示
//    给定两个长度为 n 的 下标从 0 开始 的数组 prices 和 profits。商店里有 n 件商品，其中第 i 件商品的价格为 prices[i]，利润为 profits[i]。
//
//    我们必须按照以下条件选择三件商品：
//
//    prices[i] < prices[j] < prices[k]，其中 i < j < k。
//    如果我们选择满足上述条件的索引 i，j 和 k 的商品，那么利润就是 profits[i] + profits[j] + profits[k]。
//
//    返回我们能得到的最大利润，如果无法选择三件满足条件的商品，则返回 -1。
//
//
//
//    示例 1：
//
//    输入： prices = [10,2,3,4], profits = [100,2,7,10]
//    输出： 19
//    解释： 我们不能选择索引为 i=0 的商品，因为不存在索引 j 和 k 满足条件。
//    所以我们能选择的唯一三元组是索引为 1，2 和 3 的商品，这是一个有效的选择，因为 prices[1] < prices[2] < prices[3]。
//    答案就是它们的利润之和，即 2 + 7 + 10 = 19。

    // 一样的题目：2921. 价格递增的最大利润三元组 II
    public int maxProfit(int[] prices, int[] profits) {
        int n = prices.length;
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : prices) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        int[] left = new int[n];
        int[] right = new int[n];
        LC_2921.FenwickTree ft = new LC_2921.FenwickTree(tset.size() + 1);
        for (int i = 0; i < n - 1; i++) {
            int index = map.get(prices[i]);
            left[i] = ft.query(index - 1);
            ft.change(index, profits[i]);
        }
        Arrays.fill(ft.s, 0);
        // 从后往前枚举，rank大的在前面被change并且维护最大值，
        // 然后rank小的往前查可以查询到前面rank维护的最大值
        for (int i = n - 1; i >= 1; i--) {
            int r = tset.size();
            int index = map.get(prices[i]);
            index = r - index + 1;
            right[i] = ft.query(index - 1);
            ft.change(index, profits[i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (left[i] == 0 || right[i] == 0) {
                continue;
            }
            ans = Math.max(ans, left[i] + right[i] + profits[i]);
        }
        return ans == 0 ? -1 : ans;
    }


    class FenwickTree {
        int n;
        int[] s = new int[2005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
        }

        public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
            return x & -x;
        }

        public void change(int x, int k) {    // 向后修
            while (x <= n && k > s[x]) {
                s[x] = k;
                x += lowbit(x);
            }
        }
        public int query(int x) { // 向前查（前缀和）
            int t = 0;
            while (x > 0) {
                t = Math.max(t, s[x]);
                x -= lowbit(x);
            }
            return t;
        }
    }


}
