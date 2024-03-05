package com.fqh.hot100;

import com.fqh.utils.TreeNode;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/5 15:00
 **/
public class BinaryTreeMaximumPathSum {


    // https://leetcode.cn/problems/binary-tree-maximum-path-sum/submissions/490732425/?envType=study-plan-v2&envId=top-100-liked
    // 124. 二叉树中的最大路径和
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
        int mx = Math.max(lmx, rmx) + root.val; // 当前子树的最大链和
        return Math.max(mx, 0);
    }
}
