package com.fqh.并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/4 17:17
 **/
public class LC_952 {

    // 质因数分解 + 并查集
    // 4,6,15,35
    // map记录该质因子的最大索引
    // map[2] = 0，map包含6的质因数2，然后将map.get(2) 和 j合并，更新map[2]为j map[3]为j，依次合并
    // 4质因数分解后 fac = [2]
    // 6质因数分解后 fac = [2,3]
    // 15质因数分解后 fac = [3,5]
    // 35质因数分解后 fac = [5,7]
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        var uf = new UnionFind(n);
        var map = new HashMap<Integer, Integer>(); // <因子，元素索引>
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
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int fa = uf.find(i);
            ans = Math.max(ans, uf.size[fa]);
        }
        return ans;
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
        int[] size;

        public UnionFind(int n) {
            fa = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                size[i] = 1;
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
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            if (size[aRoot] < size[bRoot]) {
                fa[aRoot] = bRoot;
                size[bRoot] += size[aRoot];
            } else {
                fa[bRoot] = aRoot;
                size[aRoot] += size[bRoot];
            }
        }
    }

//    952. 按公因数计算最大组件大小
//    第 113 场周赛
//            Q4
//    2272
//    相关标签
//            相关企业
//    给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
//
//    有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
//    只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
//    返回 图中最大连通组件的大小 。

//    输入：nums = [4,6,15,35]
//    输出：4

//    4 6 的公因子 2
//    6 15 的公因子 3
//    15 35的公因子 5

    public static void main(String[] args) {
        int[] a = {20,50,9,63};
        System.out.println(new LC_952().largestComponentSize(a));
    }
}
