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


'''
    组合数学
'''


'''
    1.康托展开
    康托展开用于求一个排列在所有 [1,n]的排列间的字典序排名。
    https://zhuanlan.zhihu.com/p/272721663
    https://zhuanlan.zhihu.com/p/109700398
'''
# 0~10的阶乘，这里采用打表法，也可以单独写个函数用于求阶乘
fac = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800] 
'''
    a: 要求解的排列 可以是字符串
    n: 位数
    return: rank排名
'''
def cantor(a: List[int], n: int) -> int:
    x = 0 # 初始化x
    for i in range(n):
        smaller = 0
        for j in range(i + 1, n):
            if a[j] < a[i]:
                smaller += 1
        x += fac[n - i - 1] * smaller # 累加康托展开的每一项
    print('hash: ' + str(x))    # 康拓展开值
    x += 1      # 最后+1是因为求的是排名，而前面的式子求解的是比该排列字典序小的排列有多少个
    print(x)
    return x

'''
    2.逆康托展开
    用于求解给定排名后求具体排列的问题。
    https://zhuanlan.zhihu.com/p/109700398
'''
'''
    x: 代表康托值 比排名小1
    n: 代表位数
'''
def decantor(x: int, n: int) -> None:
    x -= 1                      # x是排名 需要-1得到康拓值
    v = list(range(1, n + 1))   # 存放可选的数字，保证有序
    ans = []                    # 所求排列组合
    for i in range(n, 0, -1):
        r = x % fac[i - 1]
        t = x // fac[i - 1]
        x = r
        ans.append(v[t])
        del v[t]
    print(ans)


x = cantor([3,4,1,5,2], 5)
decantor(x, 5)
