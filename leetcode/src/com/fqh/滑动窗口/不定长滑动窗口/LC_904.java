package com.fqh.滑动窗口.不定长滑动窗口;

import java.util.HashMap;

/**
 * @Author: vq
 * @Date: 2023/12/18 18:11
 * @Version V1.0
 */
public class LC_904 {
//    904. 水果成篮
//            已解答
//    第 102 场周赛
//            Q2

    public int totalFruit(int[] fruits) {
        var map = new HashMap<Integer, Integer>();
        int ans = 0, j = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.merge(fruits[i], 1, Integer::sum);
            while (map.size() > 2) {
                map.merge(fruits[j], -1, Integer::sum);
                if (map.get(fruits[j]) == 0) map.remove(fruits[j]);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
