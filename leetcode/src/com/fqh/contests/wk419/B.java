package com.fqh.contests.wk419;

import com.fqh.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class B {

    List<int[]> tset = new ArrayList<>();

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        dfs(root);
        if (tset.size() < k) {
            return -1;
        }
        List<int[]> list = new ArrayList<>();
        list.addAll(tset);
        list.sort((a, b) -> b[0] - a[0]);
        return list.get(k - 1)[0];
    }



    boolean dfs(TreeNode root) {
        if (root == null) return true;

        boolean ok1 = dfs(root.left);
        boolean ok2 = dfs(root.right);


        int v1 = root.left != null ? root.left.val : 0;
        int v2 = root.right != null ? root.right.val : 0;
        if (ok1 && ok2 && v1 == v2) {
            tset.add(new int[]{v1 + v2 + 1, root.val});
            root.val = v1 + v2 + 1;
            return true;
        } else {
            root.val = 0;
            return false;
        }
    }
}
