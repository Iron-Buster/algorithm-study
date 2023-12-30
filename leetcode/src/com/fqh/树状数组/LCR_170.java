package com.fqh.树状数组;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/30 12:56
 **/
public class LCR_170 {

    public int reversePairs(int[] nums) {
        int n = nums.length;
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : nums) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        FenwickTree ft = new FenwickTree(tset.size() + 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Integer index = map.get(nums[i]);
            ans += ft.query(tset.size()) - ft.query(index);
            ft.change(index, 1);
        }
        return ans;
    }


    class FenwickTree {
        int n;
        int[] s = new int[100005]; // 区间和
        int[] a = new int[100005];

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


//    LCR 170. 交易逆序对的总数
//            已解答
//    困难
//            相关标签
//    相关企业
//    在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
//
//
//
//    示例 1:
//
//    输入：record = [9, 7, 5, 4, 6]
//    输出：8
//    解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
}
