package com.fqh.contests.wk391;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/31 12:44
 **/
public class B {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int cnt = numBottles;
        int v = 0;
        while (cnt >= numExchange) {
            cnt -= numExchange;
            v++;
            cnt++;
            numExchange++;
        }
        return numBottles + v;
    }
}
