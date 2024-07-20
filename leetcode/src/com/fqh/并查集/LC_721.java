package com.fqh.并查集;

import java.util.*;
import java.util.stream.Collectors;

public class LC_721 {


    public static void main(String[] args) {
        String[][] b = {{"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"John", "johnsmith@mail.com", "john00@mail.com"}, {"Mary", "mary@mail.com"}, {"John", "johnnybravo@mail.com"}};
        List<List<String>> a = new ArrayList<>();
        for (String[] strings : b) a.add(Arrays.stream(strings).collect(Collectors.toList()));
        System.out.println(new LC_721().accountsMerge(a));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                groups.computeIfAbsent(list.get(j), k -> new ArrayList<>()).add(i);
            }
        }
        var dsu = new DSU(n, accounts);
        for (List<Integer> value : groups.values()) {
            int v = value.get(0);
            for (int x : value) dsu.merge(v, x);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            set.add(root);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i : set) {
            String name = accounts.get(i).get(0);
            List<String> p = new ArrayList<>(dsu.size[i]);
            p.sort((a, b) -> a.compareTo(b));
            p.set(0, name);
            ans.add(p);
        }
        return ans;
    }


    class DSU {
        int[] parent;
        HashSet<String>[] size;

        public DSU(int n, List<List<String>> accounts) {
            this.parent = new int[n];
            this.size = new HashSet[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = new HashSet<>();
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    size[i].add(accounts.get(i).get(j));
                }
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void merge(int x, int y) {
            if (x == y) return;
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return;
            if (size[rx].size() < size[ry].size()) { // 启发式合并
                parent[rx] = ry;
                size[ry].addAll(size[rx]);
            } else {
                parent[ry] = rx;
                size[rx].addAll(size[ry]);
            }
        }
    }
}
