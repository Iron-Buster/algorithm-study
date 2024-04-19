package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/13 11:08
 * @Version V1.0
 */

import java.util.ArrayList;

/**
 * 位运算模板
 */
public class BitsTemplate {

}

//从集合论到位运算，常见位运算技巧分类总结！
//        https://leetcode.cn/circle/discuss/CaOJ45/
//
//        有关二进制枚举、枚举子集的子集、枚举大小固定集合等写法，见 search.go
//
//        标准库 "math/bits" 包含了位运算常用的函数，如二进制中 1 的个数、二进制表示的长度等
//        注意：bits.Len(0) 返回的是 0 而不是 1
//        bits.Len(x) 相当于 int(Log2(x)+eps)+1  x>0
//        或者说 2^(Len(x)-1) <= x < 2^Len(x)    x>0
//
//        基础题
//        https://leetcode.cn/problems/find-the-k-or-of-an-array/
//
//        XOR 相关题目
//        https://leetcode.cn/circle/discuss/sqPZwg/
//        - [1720. 解码异或后的数组](https://leetcode.cn/problems/decode-xored-array/) 1284
//        - [2433. 找出前缀异或的原始数组](https://leetcode.cn/problems/find-the-original-array-of-prefix-xor/) 1367
//        - [1310. 子数组异或查询](https://leetcode.cn/problems/xor-queries-of-a-subarray/) 1460
//        - [2683. 相邻值的按位异或](https://leetcode.cn/problems/neighboring-bitwise-xor/) 1518
//        - [1829. 每个查询的最大异或值](https://leetcode.cn/problems/maximum-xor-for-each-query/) 1523
//        - [1442. 形成两个异或相等数组的三元组数目](https://leetcode.cn/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/) 1525
//        - [2429. 最小 XOR](https://leetcode.cn/problems/minimize-xor/) 1532
//        - [2527. 查询数组 XOR 美丽值](https://leetcode.cn/problems/find-xor-beauty-of-array/) 1550
//        - [2425. 所有数对的异或和](https://leetcode.cn/problems/bitwise-xor-of-all-pairings/) 1622
//        - [2317. 操作后的最大异或和](https://leetcode.cn/problems/maximum-xor-after-operations/) 1679
//        - [1734. 解码异或后的排列](https://leetcode.cn/problems/decode-xored-permutation/) 2024
//        - [2939. 最大异或乘积](https://leetcode.cn/problems/maximum-xor-product/)


//常用技巧：拆位（部分题目排序很有用）
//        LC1835 https://leetcode.cn/problems/find-xor-sum-of-all-pairs-bitwise-and/
//        https://codeforces.com/problemset/problem/1777/F
//        https://codeforces.com/problemset/problem/981/D
//        https://atcoder.jp/contests/abc281/tasks/abc281_f
//        https://atcoder.jp/contests/arc127/tasks/arc127_d
//        考虑贡献 https://codeforces.com/problemset/problem/1362/C 1400
//
//        加法拆位（进位拆位）：涉及到加法进位的题目，可以按照 mod 2^k 拆位
//        https://atcoder.jp/contests/abc091/tasks/arc092_b
//        https://codeforces.com/problemset/problem/1322/B 2100
//        变形：减法拆位（借位拆位）https://www.luogu.com.cn/problem/P3760
//
//        拆位再合并相同位
//        https://codeforces.com/problemset/problem/1874/B


/** 灵神子数组 |（或） 模板 */
// 该模板可以做到
//求出所有子数组的按位或的结果，以及值等于该结果的子数组的个数。
//求按位或结果等于任意给定数字的子数组的最短长度/最长长度。
class SubArrayOrTemplate {



    public static int[] f(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ArrayList<int[]> ors = new ArrayList<>(); // 按位或的值 + 对应子数组的右端点的最小值
        for (int i = n - 1; i >= 0; i--) {
            ors.add(new int[]{0, i});
            int k = 0;
            for (int[] or : ors) {
                or[0] |= nums[i];
                if (ors.get(k)[0] == or[0]) {
                    ors.get(k)[1] = or[1];  // 合并相同值，下标取最小的
                } else {
                    ors.set(++k, or);
                }
            }
            ors.subList(k + 1, ors.size()).clear();
            // 本题只用到了 ors[0]，如果题目改成任意给定数值，可以在 ors 中查找
            ans[i] = ors.get(0)[1] - i + 1;
        }
        return ans;
    }
}