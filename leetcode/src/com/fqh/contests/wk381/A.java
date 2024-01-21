package com.fqh.contests.wk381;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/21 00:22
 **/
public class A {


    public int minimumPushes(String word) {
        char[] s = word.toCharArray();
        var map = new HashMap<Character, Integer>();
        for (char c : s) {
            map.merge(c, 1, Integer::sum);
        }
        int ans = 0;
        int cnt1 = 8;
        int cnt2 = 8;
        int cnt3 = 8;
        int cnt4 = 2;
        var pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());
        for (var entry : map.entrySet()) pq.offer(entry);
        while (pq.size() > 0) {
            Integer value = pq.poll().getValue();
            if (cnt1 > 0) {
                ans += value;
                cnt1--;
            } else if (cnt2 > 0) {
                ans += 2 * value;
                cnt2--;
            } else if (cnt3 > 0) {
                ans += 3 * value;
                cnt3--;
            } else {
                ans += 4 * value;
                cnt4--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String w = "xyzxyzxyzxyz";
        System.out.println(new A().minimumPushes(w));
    }
}
