package com.fqh.数学.筛质数;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/14 21:38
 **/
public class LC_2761 {

    static final int MX = (int) 1e6;
    static List<Integer> primes = new ArrayList<>();
    // 埃氏筛预处理1e6范围内的质数
    static {
        // 或者，只是单纯想标记一下
        var set = new HashSet<Long>();
        for (long i = 2; i <= MX; i++) {
            if (!set.contains(i)) {
                primes.add((int) i);
                set.add(i);
                for (long j = i * i; j <= MX; j += i) { // 避免溢出
                    set.add(j);
                }
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n) {
        var ans = new ArrayList<List<Integer>>();
        var set = new HashSet<Integer>();
        for (int x : primes) {
            if (x > n) break;
            set.add(x);
            if (set.contains(n - x)) {
                ans.add(List.of(n - x, x));
            }
        }
        ans.sort((a, b) -> a.get(0) - b.get(0));
        return ans;
    }

//    2761. 和等于目标值的质数对
//            已解答
//    第 352 场周赛
//            Q2
//1505
//    相关标签
//            相关企业
//    提示
//    给你一个整数 n 。如果两个整数 x 和 y 满足下述条件，则认为二者形成一个质数对：
//
//            1 <= x <= y <= n
//    x + y == n
//    x 和 y 都是质数
//    请你以二维有序列表的形式返回符合题目要求的所有 [xi, yi] ，列表需要按 xi 的 非递减顺序 排序。如果不存在符合要求的质数对，则返回一个空数组。
//
//    注意：质数是大于 1 的自然数，并且只有两个因子，即它本身和 1 。
}
