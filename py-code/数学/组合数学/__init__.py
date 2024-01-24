'''

组合数学
    除法取模：求逆元
        (a / b) (mod p)
        (a * (1 / b)) (mod p)
        核心为求b (mod p)的逆元
        (b * 1 / b) = 1 (mod p)

    费马小定理： https://oi-wiki.org/math/number-theory/fermat/#%E8%B4%B9%E9%A9%AC%E5%B0%8F%E5%AE%9A%E7%90%86
        (a / b) mod p = (a * b ^ (p - 2)) mod p

'''
from functools import cache

# 1-n号物品里选若干个物品 要求相邻的物品差要>=k
# 对k=1-n求方案数

MOD = 10 ** 9 + 7

@cache
def fac(n: int) -> int:
    ''' n的阶乘 '''
    if n == 0:
        return 1
    return n * fac(n - 1) % MOD

@cache
def ifac(n: int) -> int:
    ''' n的阶乘的逆元 '''
    return pow(fac(n), -1, MOD)

def C(n: int, k: int) -> int:
    if n < 0 or k < 0 or n < k:
        return 0
    return ((fac(n) * ifac(k)) % MOD * ifac(n - k)) % MOD

# 从n个物品选a个 有(a-1)*(k-1)个位置不能选
# 因此从n个物品选a个方案数为Comb(n-(a-1)*(k-1),a)
# k逐渐增大 总的复杂度为调和级数 nlogn
