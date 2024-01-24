# 1022. 从根到叶的二进制数之和
# 已解答
# 第 131 场周赛
# Q2
# 1462
# 相关标签
# 相关企业
# 提示
# 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。

# 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
# 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

# 返回这些数字之和。题目数据保证答案是一个 32 位 整数。


# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

        
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        ans = 0
        def dfs(o: Optional[TreeNode], v: int) -> None:
            if not o: return
            v = (v << 1) + o.val
            if not o.left and not o.right:
                nonlocal ans
                ans += v
                return
            dfs(o.left, v)
            dfs(o.right, v)
        dfs(root, 0)