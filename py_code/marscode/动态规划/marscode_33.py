from functools import cache


MOD = 10 ** 9 + 7
def solution(n: int, a: list, b: list) -> int:
    # PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
    # write code here

    @cache
    def dfs(i: int, v: int) -> int:
        if i >= n: return 1 if v % 3 == 0 else 0
        ans = 0
        ans += dfs(i + 1, (v + a[i]) % 3)
        ans += dfs(i + 1, (v + b[i]) % 3)
        return ans
    res = dfs(0, 0)
    return res % MOD

if __name__ == '__main__':
    print(solution(n = 3, a = [1, 2, 3], b = [2, 3, 2]) == 3)
    print(solution(n = 4, a = [3, 1, 2, 4], b = [1, 2, 3, 1]) == 6)
    print(solution(n = 5, a = [1, 2, 3, 4, 5], b = [1, 2, 3, 4, 5]) == 32)