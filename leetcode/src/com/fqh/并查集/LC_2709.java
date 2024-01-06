package com.fqh.并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/6 13:39
 **/
public class LC_2709 {

    // 质因数分解 + 并查集
    // 类似题目 LC_952 按公因数计算最大组件大小
    // https://leetcode.cn/problems/largest-component-size-by-common-factor/description/
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        var map = new HashMap<Integer, Integer>(); // <质因子，最远下标>
        var uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            List<Integer> divisors = primeDivisors(nums[i]);
            for (int divisor : divisors) {
                if (map.containsKey(divisor)) {
                    uf.merge(map.get(divisor), i);
                }
                map.put(divisor, i);
            }
        }
        // 如果所有下标都在同一个连通分量中，那么数组满足条件的下标对都可以遍历
        return uf.count == 1;
    }

    // 分解质因数
    public static List<Integer> primeDivisors(int x) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) { // 如果 i 能够整除 x，说明 i 为 x 的一个质因子。
                int s = 0; //
                while (x % i == 0) {
                    x /= i;
                    s++;
                }
                primes.add(i);
            }
        }
        if (x > 1) { // 说明再经过操作之后 x 留下了一个素数
            primes.add(x);
        }
        return primes;
    }

    static class UnionFind {
        int[] fa;
        int count;

        public UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            count = n;
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            fa[aRoot] = bRoot;
            count--;
        }
    }


//    2709. 最大公约数遍历
//    第 105 场双周赛
//            Q4
//2172
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums ，你可以在一些下标之间遍历。对于两个下标 i 和 j（i != j），当且仅当 gcd(nums[i], nums[j]) > 1 时，我们可以在两个下标之间通行，其中 gcd 是两个数的 最大公约数 。
//
//    你需要判断 nums 数组中 任意 两个满足 i < j 的下标 i 和 j ，是否存在若干次通行可以从 i 遍历到 j 。
//
//    如果任意满足条件的下标对都可以遍历，那么返回 true ，否则返回 false 。
}
