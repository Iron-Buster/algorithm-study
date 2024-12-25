from collections import defaultdict
from functools import cache


def solution(n, k, p):
    # Edit your code here
    mp = defaultdict(int)
    for i, x in p:
        mp[i] = x

    @cache
    def dfs(i: int, j: int) -> int:
        if i > n: return 0 if j >= 0 else 0x3f3f3f3f
        ans = dfs(i + 1, j - 1)
        if mp[i]:
            p = mp[i]
            for x in range(1, n + 1):
                ans = min(ans, dfs(i + 1, j + x - 1) + (x * p))
        return ans
    res = dfs(0, 0)
    return res

if __name__ == "__main__":
    # Add your test cases here

    print(solution(5, 4, [[0, 2], [1, 3], [2, 1], [3, 2]]) == 7)
