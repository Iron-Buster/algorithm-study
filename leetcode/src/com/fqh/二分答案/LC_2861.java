package com.fqh.二分答案;

import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/27 09:34
 **/
public class LC_2861 {

//    2861. 最大合金数
//    https://leetcode.cn/problems/maximum-number-of-alloys/?envType=daily-question&envId=2024-01-27
//
//    输入：n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,0], cost = [1,2,3]
//    输出：2
//    解释：最优的方法是使用第 1 台机器来制造合金。
//    要想制造 2 份合金，我们需要购买：
//            - 2 份第 1 类金属。
//            - 2 份第 2 类金属。
//            - 2 份第 3 类金属。
//    总共需要 2 * 1 + 2 * 2 + 2 * 3 = 12 的金钱，小于等于预算 15 。
//    注意，我们最开始时候没有任何一类金属，所以必须买齐所有需要的金属。
//    可以证明在示例条件下最多可以制造 2 份合金。
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long ans = 0;
        for (List<Integer> cc : composition) {
            long l = 0;
            long r = (long) 1e10;
            while (l < r) {
                long mid = (l + r + 1) >> 1;
                long s = 0;
                for (int i = 0; i < n; i++) {
                    long tot = mid * cc.get(i) - stock.get(i); // 制作m个i合金需要 m * cc[i] - stock[i]个金属
                    if (tot <= 0) continue;
                    s += tot * cost.get(i);
                }
                if (s > budget) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            ans = Math.max(ans, l);
        }
        return (int) ans;
    }

}
