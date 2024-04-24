# https://leetcode.cn/problems/removing-stars-from-a-string/
class Solution:
    def removeStars(self, s: str) -> str:
        stk = []
        for c in s:
            if c == '*':
                if stk:
                    stk.pop()
            else:
                stk.append(c)
        return "".join(stk)
