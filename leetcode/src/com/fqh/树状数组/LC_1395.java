package com.fqh.树状数组;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/18 22:19
 **/
public class LC_1395 {

    public int numTeams(int[] rating) {
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : rating) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        FenwickTree ft = new FenwickTree(tset.size() + 1);
        int ans = 0;
        // 枚举 i k
        for (int i = 0; i < rating.length; i++) {
            int a = map.get(rating[i]);
            for (int j = i + 1; j < rating.length; j++) {
                int b = map.get(rating[j]);
                if (a < b) {
                    ans += ft.query(b - 1) - ft.query(a);
                } else {
                    ans += ft.query(a - 1) - ft.query(b);
                }
                ft.change(b, 1);
            }
            for (int j = i + 1; j < rating.length; j++) {
                int index = map.get(rating[j]);
                ft.change(index, -1);
            }
        }
        return ans;
    }

    class FenwickTree {
        int n;
        long[] s = new long[100005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
        }

        public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
            return x & -x;
        }

        public void change(int x, int k) {    // 向后修
            while (x <= n) {
                s[x] += k;
                x += lowbit(x);
            }
        }
        public int query(int x) { // 向前查（前缀和）
            int t = 0;
            while (x > 0) {
                t += s[x];
                x -= lowbit(x);
            }
            return t;
        }
    }

//    1395. 统计作战单位数
//            已解答
//    第 182 场周赛
//            Q2
//1344
//    相关标签
//            相关企业
//    提示
//    n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
//
//    每 3 个士兵可以组成一个作战单位，分组规则如下：
//
//    从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
//    作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
//    请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
//
//
//
//    示例 1：
//
//    输入：rating = [2,5,3,4,1]
//    输出：3
//    解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
}
