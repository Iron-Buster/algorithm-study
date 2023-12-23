package com.fqh.动态规划.树形DP;

import com.fqh.utils.TreeNode;

/**
 * @Author: vq
 * @Date: 2023/12/23 16:41
 * @Version V1.0
 */
public class LC_337 {

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        // f[0] 表示不选当前根节点，选子节点l,r节点的最大收益
        // f[1] 表示选当前根节点，不选子节点l,r节点的最大收益
        int[] f = new int[2];
        f[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        f[1] = root.val + l[0] + r[0];
        return f;
    }


//    337. 打家劫舍 III
//    已解答
//            中等
//    相关标签
//            相关企业
//    小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
//
//    除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
//
//    给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
}
