package com.fqh.contests.bw125;

import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/3 12:16
 **/
public class B {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for (int x : nums) pq.offer((long) x);
        int res = 0;
        while (pq.size() > 1 && pq.peek() < k) {
            var v1 = pq.poll();
            var v2 = pq.poll();
            res++;
            pq.offer(Math.min(v1, v2) * 2 + Math.max(v1, v2));
        }
        return res;
    }
}
