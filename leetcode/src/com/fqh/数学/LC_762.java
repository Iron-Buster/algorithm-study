package com.fqh.数学;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/17 22:23
 **/
public class LC_762 {


//    https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/

    static HashSet<Integer> primes = new HashSet<>();
    static  {
        int mx = (int) 1e6;
        // 或者，只是单纯想标记一下
        boolean[] vis = new boolean[mx + 1];
        for (int i = 2; i <= mx; i++) {
            if (!vis[i]) {
                primes.add(i);
                vis[i] = true;
                for (int j = i * 2; j <= mx; j += i) {
                    vis[j] = true;
                }
            }
        }
    }

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            ans += primes.contains(Integer.bitCount(i)) ? 1 : 0;
        }
        return ans;
    }
}
