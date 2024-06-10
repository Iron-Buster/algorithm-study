from string import digits
from typing import * 

# https://leetcode.cn/problems/clear-digits/description/

class Solution:
    def clearDigits(self, s: str) -> str:
        stk = []
        for c in s:
            if c in digits:
                stk.pop()
            else:
                stk.append(c)
                
        return "".join(stk)