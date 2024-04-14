package com.fqh.contests.bw128;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/14 10:25
 **/
public class D {

    static long[] f(int[] a) {
        int n = a.length;
        long[] pre = new long[n];
        Arrays.fill(pre, 1); // 累加值相同的子数字组个数
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && a[stk.peek()] <= a[i]) {
                if (a[stk.peek()] == a[i]) {
                    pre[i] = pre[stk.peek()] + 1; // [4, 2, 4, 4] -> pre[1, 1, 2, 3]
                }
                stk.pop();
            }
            stk.push(i);
        }
        System.out.println(Arrays.toString(pre));
        return pre;
    }


    public long numberOfSubarrays(int[] nums) {
        long[] pre = f(nums);
        return Arrays.stream(pre).sum();
    }
}
