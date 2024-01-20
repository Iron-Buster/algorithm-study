package com.fqh.前缀和.前缀和哈希表;

import com.fqh.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 18:15
 **/
public class LC_437 {
//    437. 路径总和 III
//    中等
//            相关标签
//    相关企业
//    给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
//    路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
    int ans = 0;
    long s = 0;
    Map<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        dfs(root, targetSum);
        return ans;
    }
    // 哈希表 + 前缀和
    public void dfs(TreeNode root, int t) {
        if (root == null) return;
        s += root.val;
        if (map.containsKey(s - t)) {
            ans += map.get(s - t);
        }
        map.merge(s, 1, Integer::sum);
        dfs(root.left, t);
        dfs(root.right, t);
        map.merge(s, -1, Integer::sum);
        s -= root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        int t = 0;
        System.out.println(new LC_437().pathSum(root, t));
    }
}
