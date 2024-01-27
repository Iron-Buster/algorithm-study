package com.fqh.并查集;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/27 17:45
 **/
public class LC_128 {

//    128. 最长连续序列
//            已解答
//    中等
//            相关标签
//    相关企业
//    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] + 1)) {
                uf.merge(i, map.get(nums[i] + 1));
            }
        }
        var count = new HashMap<Integer, Integer>();
        int ans = 0;
        for (Integer x : map.values()) {
            int root = uf.find(x);
            count.merge(root, 1, Integer::sum);
        }
        for (var v : count.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }

    class UnionFind {
        int[] fa;

        public UnionFind(int n) {
            fa = new int[n]; // 如果n从1开始，则n+1
            for (int i = 0; i < n; i++) { // <= n
                fa[i] = i;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            fa[rootB] = rootA;
        }
    }
}
