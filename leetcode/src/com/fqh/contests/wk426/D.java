package com.fqh.contests.wk426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D {

    //https://leetcode.cn/post-editor/solution/create/?submissionId=584845176

    // https://leetcode.cn/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/solutions/3009164/huan-gen-dpzuo-fa-java-by-meilicat-7lp2
    /**
     * 用dp[i][0]表示以节点i为根，偶数节点的数量。dp[i][1]表示以i为根，奇数节点的数量。
     * 考虑节点0和1，从0转换到1，其实就是0的奇数节点数量变成了1的偶数节点数量，0的偶数节点数量变成了1的奇数节点数量。首先计算出dp[0][0]和dp[0][1]，然后换根dp计算出其他根的数量。
     * 最后连接tree2的某个节点，其实就是找tree2中dp[i][1]最多的那个节点连接。
     */

    List<Integer>[] g1;
    List<Integer>[] g2;
    int[][] dp1;
    int[][] dp2;

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length;
        int m = edges2.length;
        g1 = new List[n+1];
        g2 = new List[m+1];
        dp1 = new int[n+1][2];
        dp2 = new int[m+1][2];
        Arrays.setAll(g1, v -> new ArrayList<>());
        Arrays.setAll(g2, v -> new ArrayList<>());
        for (int[] edge : edges1) {
            int u = edge[0];
            int v = edge[1];
            g1[u].add(v);
            g1[v].add(u);
        }
        for (int[] edge : edges2) {
            int u = edge[0];
            int v = edge[1];
            g2[u].add(v);
            g2[v].add(u);
        }
        dfs0(0, -1, 0, false);
        dfs0(0, -1, 0, true);
        dfs1(0, -1, false);
        dfs1(0, -1, true);
        int mx = 0;
        for (int[] dp : dp2) {
            mx = Math.max(mx, dp[1]);
        }
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int v1 = dp1[i][0];
            ans[i] = v1 + mx;
        }
        return ans;
    }

    void dfs0(int x, int fa, int state, boolean inTree2) {
        if (!inTree2) {
            dp1[x][0] = (state == 0 ? 1 : 0);
            dp1[x][1] = (state == 1 ? 1 : 0);
        } else {
            dp2[x][0] = (state == 0 ? 1 : 0);
            dp2[x][1] = (state == 1 ? 1 : 0);
        }
        if (inTree2) {
            for (int y : g2[x]) {
                if (y == fa) continue;
                dfs0(y, x, state ^ 1, true);
                dp2[x][0] += dp2[y][0];
                dp2[x][1] += dp2[y][1];
            }
        } else {
            for (int y : g1[x]) {
                if (y == fa) continue;
                dfs0(y, x, state ^ 1, false);
                dp1[x][0] += dp1[y][0];
                dp1[x][1] += dp1[y][1];
            }
        }
    }

    void dfs1(int x, int fa, boolean inTree2) {
        if (inTree2) {
            for (int y : g2[x]) {
                if (y == fa) continue;
                dp2[y][0] = dp2[x][1];
                dp2[y][1] = dp2[x][0];
                dfs1(y, x, true);
            }
        } else {
            for (int y : g1[x]) {
                if (y == fa) continue;
                dp1[y][0] = dp1[x][1];
                dp1[y][1] = dp1[x][0];
                dfs1(y, x, false);
            }
        }

    }


    public static void main(String[] args) {
        int[][] edges1 =  {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        System.out.println(Arrays.toString(new D().maxTargetNodes(edges1, edges2)));
    }
}
