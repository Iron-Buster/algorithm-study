package com.fqh.树状数组;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/30 13:30
 **/
public class LC_493 {

    public int reversePairs(int[] nums) {
        int n = nums.length;
        // 离散化
        TreeSet<Long> tset = new TreeSet<>();
        for (long x : nums) {
            tset.add(x);
            tset.add(x * 2);
        }
        Map<Long, Integer> map = new HashMap<>();
        int rank = 1;
        for (Long x : tset) {
            map.put(x, rank++);
        }
        FenwickTree ft = new FenwickTree(tset.size() + 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = map.get((long) nums[i] * 2);
            int right = map.size();
            ans += ft.query(right) - ft.query(left);
            Integer index = map.get((long) nums[i]);
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

//    493. 翻转对
//            已解答
//    困难
//            相关标签
//    相关企业
//            提示
//    给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//
//    你需要返回给定数组中的重要翻转对的数量。
//
//    示例 1:
//
//    输入: [1,3,2,3,1]
//    输出: 2
//    示例 2:
//
//    输入: [2,4,3,5,1]
//    输出: 3
//    注意:
//
//    给定数组的长度不会超过50000。
//    输入数组中的所有数字都在32位整数的表示范围内。
}
