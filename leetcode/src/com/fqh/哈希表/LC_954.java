package com.fqh.哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/7/20 15:53
 **/
public class LC_954 {

    //https://leetcode.cn/problems/array-of-doubled-pairs/description/
    public boolean canReorderDoubled(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        Arrays.sort(arr);
        for (int x : arr) {
            if (x > 0) {
                if (x % 2 == 0 && map.containsKey(x / 2)) {
                    map.merge(x / 2, -1, Integer::sum);
                    if (map.get(x / 2) == 0) map.remove(x / 2);
                } else {
                    map.merge(x, 1, Integer::sum);
                }
            } else {
                if (map.containsKey(x * 2)) {
                    map.merge(x * 2, -1, Integer::sum);
                    if (map.get(x * 2) == 0) map.remove(x * 2);
                } else {
                    map.merge(x, 1, Integer::sum);
                }
            }
        }
        return map.size() == 0;
    }
}
