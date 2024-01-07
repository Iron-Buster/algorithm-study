package com.fqh.并查集;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/7 18:13
 **/
public class LC_2948 {

    // 并查集 + 优先队列
    // 类似题目：https://leetcode.cn/problems/smallest-string-with-swaps/description/
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        var uf = new UnionFind(n);
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> nums[i] - nums[j]);
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && nums[ids[i]] - nums[ids[i-1]] <= limit; i++) {
                // merge 操作
                uf.merge(ids[st], ids[i]);
            }
        }
        var map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (i = 0; i < n; i++) {
            int fa = uf.find(i);
            map.computeIfAbsent(fa, v -> new PriorityQueue<>((a, b) -> a - b));
            map.get(fa).offer(nums[i]);
        }
        int[] ans = new int[n];
        for (i = 0; i < n; i++) {
            int fa = uf.find(i);
            ans[i] = map.get(fa).poll();
        }
        return ans;
    }

    class UnionFind {
        int[] fa;

        public UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
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

//    2948. 交换得到字典序最小的数组
//            已解答
//    第 373 场周赛
//            Q3
//2047
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的 正整数 数组 nums 和一个 正整数 limit 。
//
//    在一次操作中，你可以选择任意两个下标 i 和 j，如果 满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 nums[j] 。
//
//    返回执行任意次操作后能得到的 字典序最小的数组 。
//
//    如果在数组 a 和数组 b 第一个不同的位置上，数组 a 中的对应元素比数组 b 中的对应元素的字典序更小，则认为数组 a 就比数组 b 字典序更小。
//    例如，数组 [2,10,3] 比数组 [10,2,3] 字典序更小，下标 0 处是两个数组第一个不同的位置，且 2 < 10 。
}
