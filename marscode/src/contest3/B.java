package contest3;

import java.util.*;

public class B {
    public static int solution(int[] a) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            map.computeIfAbsent(x, v -> new ArrayList<>()).add(i);
        }
        var vis = new HashSet<Integer>();
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{0, 0});
        vis.add(0);
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int u = p[0], step = p[1];
            if (u == a.length - 1) {
                return step;
            }
            if (u - 1 >= 0 && !vis.contains(u - 1)) {
                q.offer(new int[]{u - 1, step + 1});
                vis.add(u - 1);
            }
            if (u + 1 < a.length && !vis.contains(u + 1)) {
                q.offer(new int[]{u + 1, step + 1});
                vis.add(u + 1);
            }
            for (int v : map.get(a[u])) {
                if (!vis.contains(v)) {
                    q.offer(new int[]{v, step + 1});
                    vis.add(v);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 11, 5, 5, 5, 5, 46, 5, -25, 46}) == 5);
        System.out.println(solution(new int[]{9}) == 0);
        System.out.println(solution(new int[]{9, 8, 1, 8, 1, 8, 1, 9}) == 1);
    }
}