package com.fqh.优先队列.对顶堆;

import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/25 10:43
 **/
public class LC_480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        var q1 = new PriorityQueue<Double>((a, b) -> Double.compare(a, b));
        var q2 = new PriorityQueue<Double>((a, b) -> Double.compare(b, a));
        return null;
    }
}
