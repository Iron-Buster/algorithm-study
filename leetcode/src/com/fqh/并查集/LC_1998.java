package com.fqh.并查集;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/7 18:39
 **/
public class LC_1998 {

    // 质因数分解 + 并查集 + 优先队列
    // 类似题目：
    // https://leetcode.cn/problems/make-lexicographically-smallest-array-by-swapping-elements/description/
    // https://leetcode.cn/problems/smallest-string-with-swaps/
    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        var uf = new UnionFind(n);
        var map = new HashMap<Integer, Integer>(); // <质因子，最远下标>
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            List<Integer> divisors = primeDivisors(x);
            for (Integer divisor : divisors) {
                if (map.containsKey(divisor)) { // 有相同的质因子
                    uf.merge(i, map.get(divisor));
                }
                map.put(divisor, i);            // 维护该因子的最大索引
            }
        }
        var map2 = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int i = 0; i < n; i++) {
            int fa = uf.find(i);
            map2.computeIfAbsent(fa, v -> new PriorityQueue<>((a, b) -> a - b));
            map2.get(fa).offer(nums[i]);
        }
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int fa = uf.find(i);
            int v = map2.get(fa).poll();
            if (pre > v) {
                return false;
            }
            pre = v;
        }
        return true;
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

    public static void main(String[] args) {
        int[] a = {8, 9, 4, 2, 3};
        System.out.println(new LC_1998().gcdSort(a));
    }
}
