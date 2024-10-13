package com.fqh.contests.wk419;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            var cnt = new HashMap<Integer, Integer>();
            int sum = 0;
            for (int j = i; j < n; j++) {
                cnt.merge(nums[j], 1, Integer::sum);
                sum += nums[j];
                if (j - i + 1 == k) {
                    int v = 0;
                    List<int[]> list = new ArrayList<>();
                    for (var e : cnt.entrySet()) {
                        list.add(new int[]{e.getValue(), e.getKey()});
                    }
                    list.sort((a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
                    if (list.size() < x) {
                        res[i] = sum;
                    } else {
                        for (int l = 0; l < x; l++) {
                            v += list.get(l)[0] * list.get(l)[1];
                        }
                        res[i] = v;
                    }
                    break;
                }
            }
        }
        return res;
    }
}
