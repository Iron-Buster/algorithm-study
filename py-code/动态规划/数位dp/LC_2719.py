from functools import cache


class Solution:
    def count(self, num1: str, num2: str, min_sum: int, max_sum: int) -> int:
        def calc(s: str):
            @cache
            def dfs(i: int, isLimit: bool, sum: int) -> int:
                if i == len(s):
                    return 1 if min_sum <= sum <= max_sum else 0
                ans = 0
                up = int(s[i]) if isLimit else 9
                for d in range(up + 1):
                    if d + sum > max_sum: continue
                    ans += dfs(i + 1, isLimit and d == up, sum + d)
                return ans % 1000000007
            return dfs(0, True, 0)
        return (calc(num2) - calc(str(int(num1) - 1))) % 1000000007

if __name__ == '__main__':
    ret = Solution().count("1", "12", 1, 8)
    print(ret)