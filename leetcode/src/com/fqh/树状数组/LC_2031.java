package com.fqh.树状数组;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/21 16:05
 **/
public class LC_2031 {

//    2031. 1 比 0 多的子数组个数
//            已解答
//    中等
//            相关标签
//    相关企业
//            提示
//    给你一个只包含 0 和 1 的数组 nums，请返回 1 的数量 大于 0 的数量的子数组的个数。由于答案可能很大，请返回答案对 109 + 7 取余 的结果。
//
//    一个 子数组 指的是原数组中连续的一个子序列。
//
//
//
//    示例 1:
//
//    输入: nums = [0,1,1,0,1]
//    输出: 9
//    解释:
//    长度为 1 的、1 的数量大于 0 的数量的子数组有: [1], [1], [1]
//    长度为 2 的、1 的数量大于 0 的数量的子数组有: [1,1]
//    长度为 3 的、1 的数量大于 0 的数量的子数组有: [0,1,1], [1,1,0], [1,0,1]
//    长度为 4 的、1 的数量大于 0 的数量的子数组有: [1,1,0,1]
//    长度为 5 的、1 的数量大于 0 的数量的子数组有: [0,1,1,0,1]

    static final int MOD = (int) (1e9 + 7);

    // 前缀和 + 离散化 + 树状数组
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length;
        int[] s = new int[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + (nums[i] == 0 ? -1 : 1);
        }
        var tset = new TreeSet<Integer>();
        for (int x : s) tset.add(x);
        int rank = 1;
        var map = new HashMap<Integer, Integer>();
        for (int x : tset) map.put(x, rank++);
        FenwickTree FT = new FenwickTree(tset.size() + 1);
        int ans = 0;
        for (int x : s) {
            int index = map.get(x);
            ans += FT.query(index - 1);
            ans %= MOD;
            FT.change(index , 1);
        }
        return ans;
    }

    class FenwickTree {
        int n;
        int[] s = new int[100005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
        }

        public FenwickTree() {
            this.n = 100005;
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
}
