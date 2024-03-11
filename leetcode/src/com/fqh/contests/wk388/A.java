package com.fqh.contests.wk388;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/11 09:38
 **/
public class A {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int s = Arrays.stream(apple).sum();
        int ans = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            s -= capacity[i];
            ans += 1;
            if (s <= 0) break;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
