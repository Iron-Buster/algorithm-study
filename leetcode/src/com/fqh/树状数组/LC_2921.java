package com.fqh.树状数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/18 23:38
 **/
public class LC_2921 {

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
        FenwickTree ft = new FenwickTree(tset.size() + 1);
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
        int[] s = new int[5005]; // 区间和

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

//    2921. 价格递增的最大利润三元组 II
//    已解答
//            困难
//    相关标签
//            相关企业
//    提示
//    给定长度为 n  的数组 prices 和 profits （下标从 0 开始）。一个商店有 n 个商品，第 i 个商品的价格为 prices[i]，利润为 profits[i]。
//
//    需要选择三个商品，满足以下条件：
//
//    prices[i] < prices[j] < prices[k]，其中 i < j < k。
//    如果选择的商品 i, j 和 k 满足以下条件，那么利润将等于 profits[i] + profits[j] + profits[k]。
//
//    返回能够获得的 最大利润，如果不可能满足给定条件，返回 -1。

    public static void main(String[] args) {
        int[] p = {10, 2, 3, 4};
        int[] pf = {100,2,7,10};
        System.out.println(new LC_2921().maxProfit(p, pf));
    }
}
