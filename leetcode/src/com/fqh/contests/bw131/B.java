package com.fqh.contests.bw131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/25 23:31
 **/
public class B {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int m = queries.length;
        var a = new Integer[m];
        var b = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            a[i] = i;
        }
        Arrays.sort(a, Comparator.comparingInt(i -> queries[i]));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) b.add(i);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int k = queries[a[i]];
            if (k > b.size()) {
                ans[a[i]] = -1;
            } else {
                ans[a[i]] = b.get(k - 1);
            }
        }
        return ans;
    }
}
