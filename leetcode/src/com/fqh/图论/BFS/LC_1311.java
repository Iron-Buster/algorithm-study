package com.fqh.图论.BFS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/7 15:32
 **/
public class LC_1311 {

//    1311. 获取你好友已观看的视频
//            已解答
//    第 170 场周赛
//            Q3
//    1653
//    相关标签
//            相关企业
//    提示
//    有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
//
//    给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
//
//    Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
//
//    给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按字母顺序从小到大排列。


    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer>[] g = new List[friends.length];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 0; i < friends.length; i++) {
            for (int v : friends[i]) {
                g[i].add(v);
                g[v].add(i);
            }
        }
        var map = new HashMap<String, Integer>();
        int mn = Integer.MAX_VALUE;
        var vis = new boolean[friends.length];
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{id, 0});
        vis[id] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], d = p[1];
            if (d > level) break;
            for (int y : g[x]) {
                if (vis[y]) continue;
                if (d + 1 == level) {
                    for (String v : watchedVideos.get(y)) {
                        map.merge(v, 1, Integer::sum);
                        mn = Math.min(mn, map.get(v));
                    }
                }
                q.offer(new int[]{y, d + 1});
                vis[y] = true;
            }
        }
        List<PII> ans = new ArrayList<>();
        map.forEach((k ,v) -> ans.add(new PII(k, v)));
        ans.sort((a, b) -> {
            if (a.second != b.second) return a.second - b.second;
            return a.first.compareTo(b.first);
        });
        return ans.stream().map(e -> e.first).collect(Collectors.toList());
    }

    class PII {
        String first;
        int second;

        public PII(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
