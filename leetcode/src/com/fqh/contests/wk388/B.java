package com.fqh.contests.wk388;

import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/11 09:38
 **/
public class B {

    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>((a, b) -> Long.compare(b, a));
        for (int x : happiness) {
            pq.offer((long) x);
        }
        long ans = 0;
        int v = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            long x = Math.max(0, pq.poll() - v);
            ans += x;
            v++;
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
