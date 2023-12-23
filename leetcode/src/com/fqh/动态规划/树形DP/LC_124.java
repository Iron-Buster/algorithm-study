package com.fqh.动态规划.树形DP;

import com.fqh.utils.TreeNode;

/**
 * @Author: vq
 * @Date: 2023/12/23 16:35
 * @Version V1.0
 */
public class LC_124 {


    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int lmx = dfs(root.left);
        int rmx = dfs(root.right);
        ans = Math.max(ans, lmx + rmx + root.val);
        int mx = Math.max(lmx, rmx) + root.val; // 当前子树最大链和
        return Math.max(mx, 0);
    }


//    124. 二叉树中的最大路径和
//            已解答
//    困难
//            相关标签
//    相关企业
//    二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//    路径和 是路径中各节点值的总和。
//
//    给你一个二叉树的根节点 root ，返回其 最大路径和 。
}
