from functools import cache


def solution(n, k, data):
    # Edit your code
    @cache
    def dfs(i: int, j: int) -> int:
        if i >= n: return 0
        ans = 0x3f3f3f3f
        if j > 0:
            # 不购买
            ans = min(ans, dfs(i + 1, j - 1))
        for x in range(1, k + 1):
            if j + x > k: break
            # 必须消耗一次
            ans = min(ans, dfs(i + 1, j + x - 1) + (data[i] * x))
        return ans


    res = dfs(0, 0)
    return res

if __name__ == "__main__":
    # Add your test cases here

    print(solution(5, 2, [1, 2, 3, 3, 2]) == 9)
