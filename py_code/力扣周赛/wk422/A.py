
'''
https://leetcode.cn/contest/weekly-contest-422/problems/check-balanced-string/
'''
class Solution:
    def isBalanced(self, num: str) -> bool:
        x = y = 0
        for i in range(len(num)):
            if i % 2 == 0: x += int(num[i])
            else: y += int(num[i])
        return x == y