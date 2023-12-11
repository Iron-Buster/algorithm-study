package com.fqh;

import com.fqh.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/12/6 11:39
 * @Version V1.0
 */
public class LC_2385 {

//    2385. 感染二叉树需要的总时间
//            已解答
//    第 307 场周赛
//            Q3
//    1711
//    相关标签
//            相关企业
//    提示
//    给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
//
//    每分钟，如果节点满足以下全部条件，就会被感染：
//
//    节点此前还没有感染。
//    节点与一个已感染节点相邻。
//    返回感染整棵树需要的分钟数。

    List<Integer>[] g = new List[100001];
    int ans = 0;
    public int amountOfTime(TreeNode root, int start) {
        Arrays.setAll(g, e -> new ArrayList<>());
        buildGraph(root);
        dfs(start, -1, 0);
        return ans;
    }

    void buildGraph(TreeNode root) {
        if (root == null) return;
        int x = root.val;
        if (root.left != null) {
            int y = root.left.val;
            g[x].add(y);
            g[y].add(x);
            buildGraph(root.left);
        }
        if (root.right != null) {
            int y = root.right.val;
            g[x].add(y);
            g[y].add(x);
            buildGraph(root.right);
        }
    }

    void dfs(int x, int fa, int depth) {
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x, depth + 1);
        }
        ans = Math.max(ans, depth);
    }
}
