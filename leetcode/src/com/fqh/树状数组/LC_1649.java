package com.fqh.树状数组;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/17 23:25
 **/
public class LC_1649 {
    static final int MOD = 1000000007;

//    我们可以通过树状数组来统计小于x的元素个数，以及大于x的元素个数。
//    设x离散化后的下标为L:
//            1.小于x的元素个数 = query(L - 1)
//            2.大于x的元素个数 = query(R) - query(L-1)

    public int createSortedArray(int[] instructions) {
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : instructions) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        FenwickTree ft = new FenwickTree(tset.size() + 1);
        long ans = 0;
        for (int i = 0; i < instructions.length; i++) {
            int index = map.get(instructions[i]);
            int right = map.size();
            int q1 = ft.query(index - 1); // 小于instructions[i]的个数
            int q2 = ft.query(right) - ft.query(index); // 大于instructions[i]的个数
            ans += Math.min(q1, q2);
            ft.change(index, 1);
        }
        ans %= MOD;
        return (int) ans;
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

//    1649. 通过指令创建有序数组
//            已解答
//    第 214 场周赛
//            Q4
//2208
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 instructions ，你需要根据 instructions 中的元素创建一个有序数组。一开始你有一个空的数组 nums ，你需要 从左到右 遍历 instructions 中的元素，将它们依次插入 nums 数组中。每一次插入操作的 代价 是以下两者的 较小值 ：
//
//    nums 中 严格小于  instructions[i] 的数字数目。
//    nums 中 严格大于  instructions[i] 的数字数目。
//    比方说，如果要将 3 插入到 nums = [1,2,3,5] ，那么插入操作的 代价 为 min(2, 1) (元素 1 和  2 小于 3 ，元素 5 大于 3 ），插入后 nums 变成 [1,2,3,3,5] 。
//
//    请你返回将 instructions 中所有元素依次插入 nums 后的 总最小代价 。由于答案会很大，请将它对 109 + 7 取余 后返回。
//
//
//
//    示例 1：
//
//    输入：instructions = [1,5,6,2]
//    输出：1
//    解释：一开始 nums = [] 。
//    插入 1 ，代价为 min(0, 0) = 0 ，现在 nums = [1] 。
//    插入 5 ，代价为 min(1, 0) = 0 ，现在 nums = [1,5] 。
//    插入 6 ，代价为 min(2, 0) = 0 ，现在 nums = [1,5,6] 。
//    插入 2 ，代价为 min(1, 2) = 1 ，现在 nums = [1,2,5,6] 。
//    总代价为 0 + 0 + 0 + 1 = 1 。

}
