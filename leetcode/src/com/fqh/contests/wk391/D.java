package com.fqh.contests.wk391;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/31 12:46
 **/
public class D {

    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> a = new TreeMap<>();
        TreeMap<Integer, Integer> b = new TreeMap<>();
        for (int[] p : points) {
            int v1 = p[0] - p[1];
            int v2 = p[0] + p[1];
            a.merge(v1, 1, Integer::sum);
            b.merge(v2, 1, Integer::sum);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] p : points) {
            int v1 = p[0] - p[1];
            int v2 = p[0] + p[1];
            if (a.get(v1) == 1) a.remove(v1);
            else a.merge(v1, -1, Integer::sum);
            if (b.get(v2) == 1) b.remove(v2);
            else b.merge(v2, -1, Integer::sum);
            // a[i] = x - y, b[i] = x + y
            // n个点的最大曼哈顿距离 = max(a[n]-a[0], b[n]-b[0])
            ans = Math.min(ans, Math.max(a.lastKey() - a.firstKey(), b.lastKey() - b.firstKey()));
            a.merge(v1, 1, Integer::sum);
            b.merge(v2, 1, Integer::sum);
        }
        return ans;
    }

    public int minimumDistance2(int[][] points) {
        int n = points.length;
        var a = new TreeSet<Long>();
        var b = new TreeSet<Long>();
        var map1 = new HashMap<Long, Integer>();
        var map2 = new HashMap<Long, Integer>();
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            long v1 = x - y;
            long v2 = x + y; a.add(v1); b.add(v2);
            map1.merge(v1, 1, Integer::sum);
            map2.merge(v2, 1, Integer::sum);
        }
        var ans = Math.max(a.last() - a.first(), b.last() - b.first());
        for (int i = 0; i < n; i++) {
            long v1 = points[i][0] - points[i][1];
            long v2 = points[i][0] + points[i][1];
            if (a.first() == v1) { // 移除points[i]是否影响a.first
                Long first = a.first();
                if (map1.get(v1) - 1 == 0) {
                    a.remove(first);
                    long t = Math.max(a.last() - a.first(), b.last() - b.first());
                    if (b.first() == v2) { // 移除points[i]是否影响b.first
                        Long first2 = b.first();
                        if (map2.get(v2) - 1 == 0) {
                            b.remove(first2);
                            t = Math.max(a.last() - a.first(), b.last() - b.first());
                            ans = Math.min(ans, t);
                            b.add(first2);
                        }
                    } else if (b.last() == v2) { // 移除points[i]是否影响b.last
                        Long last = b.last();
                        if (map2.get(v2) - 1 == 0) {
                            b.remove(last);
                            t = Math.max(a.last() - a.first(), b.last() - b.first());
                            ans = Math.min(ans, t);
                            b.add(last);
                        }
                    }
                    ans = Math.min(ans, t);
                    a.add(first);
                }
            } else if (a.last() == v1) { // 移除points[i]是否影响a.last
                Long last = a.last();
                if (map1.get(v1) - 1 == 0) {
                    a.remove(last);
                    long t = Math.max(a.last() - a.first(), b.last() - b.first());
                    if (b.first() == v2) {  // 移除points[i]是否影响b.first
                        Long first = b.first();
                        if (map2.get(v2) - 1 == 0) {
                            b.remove(first);
                            t = Math.max(a.last() - a.first(), b.last() - b.first());
                            ans = Math.min(ans, t);
                            b.add(first);
                        }
                    } else if (b.last() == v2) { // 移除points[i]是否影响b.last
                        Long last2 = b.last();
                        if (map2.get(v2) - 1 == 0) {
                            b.remove(last2);
                            t = Math.max(a.last() - a.first(), b.last() - b.first());
                            ans = Math.min(ans, t);
                            b.add(last2);
                        }
                    }
                    ans = Math.min(ans, t);
                    a.add(last);
                }
            }
            if (b.first() == v2) {  // 移除points[i]是否影响b.first
                Long first = b.first();
                if (map2.get(v2) - 1 == 0) {
                    b.remove(first);
                    long t = Math.max(a.last() - a.first(), b.last() - b.first());
                    ans = Math.min(ans, t);
                    b.add(first);
                }
            } else if (b.last() == v2) { // 移除points[i]是否影响b.last
                Long last = b.last();
                if (map2.get(v2) - 1 == 0) {
                    b.remove(last);
                    long t = Math.max(a.last() - a.first(), b.last() - b.first());
                    ans = Math.min(ans, t);
                    b.add(last);
                }
            }
        }
        return (int) ans;
    }
}
