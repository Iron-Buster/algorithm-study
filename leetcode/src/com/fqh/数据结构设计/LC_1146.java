package com.fqh.数据结构设计;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/26 22:52
 **/
public class LC_1146 {


//    https://leetcode.cn/problems/snapshot-array/description/

    class SnapshotArray {
        private int cnt = 0;
        private HashMap<Integer, List<int[]>> map = new HashMap<>();

        public SnapshotArray(int length) {

        }

        public void set(int index, int val) {
            map.computeIfAbsent(index, v -> new ArrayList<>()).add(new int[]{cnt, val});
        }

        public int snap() {
            return cnt++;
        }

        public int get(int index, int snap_id) {
            List<int[]> list = map.get(index);
            if (list == null) return 0;
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid)[0] > snap_id) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (list.get(l)[0] > snap_id) return 0;
            return list.get(l)[1];
        }
    }
}
