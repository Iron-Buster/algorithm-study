from functools import cache


def solution(S: str, T: str) -> int:
    # PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
    # write code here
    m = len(S)
    n = len(T)
    diff = abs(m - n)

    @cache
    def dfs(i: int, j: int) -> int:
        if j >= n: return diff
        if i >= m: return 0
        ans = 0
        if S[i] == T[j]:
            ans += dfs(i + 1, j + 1)
        else:
            ans += dfs(i + 1, j + 1) + 1
        return ans
    return dfs(0, 0)


if __name__ == '__main__':
    print(solution("aba", "abb") == 1)
    print(solution("abcd", "efg") == 4)
    print(solution("xyz", "xy") == 1)
    print(solution("hello", "helloworld") == 0)
    print(solution("same", "same") == 0)