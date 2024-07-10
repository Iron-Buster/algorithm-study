package com.fqh.contests.bw134;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/7/10 22:32
 **/
public class B {


    //https://leetcode.cn/problems/maximum-points-after-enemy-battles/description/
    public long maximumPoints(int[] e, int currentEnergy) {
        long min = Arrays.stream(e).min().getAsInt();
        long sum = 0;
        for (int v : e) sum += v;
        if (currentEnergy < min) return 0;
        return (sum + currentEnergy - min) / min;
    }


    public static void main(String[] args) {

    }
}
