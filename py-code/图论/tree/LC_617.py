# 617.
# 合并二叉树
# 简单
# 1.3
# K
# 相关企业
# 给你两棵二叉树： root1
# 和
# root2 。
#
# 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为
# null
# 的节点将直接作为新二叉树的节点。
#
# 返回合并后的二叉树。
#
# 注意: 合并过程必须从两个树的根节点开始。
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:

        def dfs(root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
            if root1 is None and root2 is None: return None
            if root1 is None: return root2
            if root2 is None: return root1
            root = TreeNode(root1.val + root2.val)
            root.left = dfs(root1.left, root2.left)
            root.right = dfs(root1.right, root2.right)
            return root
        return dfs(root1, root2)



if __name__ == '__main__':

    print("ok")