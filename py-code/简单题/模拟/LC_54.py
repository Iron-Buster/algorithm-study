from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from random import *
from typing import *
import random
import sys
import os
from io import BytesIO, IOBase
from copy import deepcopy
import threading

BUFSIZE = 4096
MOD = 10 ** 9 + 7
mod = 998244353
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        m = len(matrix)
        n = len(matrix[0])
        up, down = 0, m - 1
        left, right = 0, n - 1
        ans = []
        while up <= down and left <= right:
            # left -> right
            if left > right: break
            for i in range(left, right+1):
                ans.append(matrix[up][i])
            up += 1
            if up > down: break
            # up -> down
            for i in range(up, down+1):
                ans.append(matrix[i][right])
            right -= 1
            # right -> left
            if left > right: break
            for i in range(right, left-1, -1):
                ans.append(matrix[down][i])
            down -= 1
            # down -> up
            if up > down: break
            for i in range(down, up-1, -1):
                ans.append(matrix[i][left])
            left += 1
        return ans

if __name__ == '__main__':
    print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]))