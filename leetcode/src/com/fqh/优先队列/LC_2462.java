package com.fqh.优先队列;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/1 20:31
 **/
public class LC_2462 {

    //https://leetcode.cn/problems/total-cost-to-hire-k-workers/description/?envType=daily-question&envId=2024-05-01
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        if (2 * candidates + k > n) {
            Arrays.sort(costs);
            long v = 0;
            for (int i = 0; i < k; i++) v += costs[i];
            return v;
        }
        var pq1 = new PriorityQueue<Integer>();
        var pq2 = new PriorityQueue<Integer>();
        for (int i = 0; i < Math.min(n, candidates); i++) {
            pq1.offer(costs[i]);
            pq2.offer(costs[n-i-1]);
        }
        long ans = 0;
        int l = candidates, r = n - candidates - 1;
        while (k-- > 0) {
            if (pq1.peek() <= pq2.peek()) {
                ans += pq1.poll();
                pq1.offer(costs[l++]);
            } else {
                ans += pq2.poll();
                pq2.offer(costs[r--]);
            }
        }
        return ans;
    }

    //costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
    public static void main(String[] args) {
        int[] costs = {1,2,4,1};
        int k = 3;
        int candidates = 3;
        System.out.println(new LC_2462().totalCost(costs, k, candidates));
    }
}
