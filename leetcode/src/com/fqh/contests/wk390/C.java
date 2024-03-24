package com.fqh.contests.wk390;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/24 19:53
 **/
public class C {

//    https://leetcode.cn/problems/most-frequent-ids/



    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];
        var map = new HashMap<Integer, Long>();
        // 频率的map
        var tmap = new TreeMap<Long, Integer>((o1, o2) -> Long.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            Long preCnt = map.get(nums[i]);
            if (preCnt != null) {
                tmap.merge(preCnt, -1, Integer::sum);
                if (tmap.get(preCnt) == 0) tmap.remove(preCnt);
            }
            map.merge(nums[i], (long) freq[i], Long::sum);
            Long nextCnt = map.get(nums[i]);
            tmap.merge(nextCnt, 1, Integer::sum);
            ans[i] = tmap.firstKey();
        }
        return ans;
    }
}
