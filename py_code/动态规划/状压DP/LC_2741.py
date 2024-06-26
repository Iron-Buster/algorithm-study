MOD = 10 ** 9 + 7

class LC_2741:
    def specialPerm(self, nums: List[int]) -> int:
        n = len(nums)
        U = (1<<n) - 1 # 全集

        @cache
        def dfs(i: int, mask: int) -> int:
            if mask == U: return 1
            ans = 0
            pre = nums[i]
            for j, cur in enumerate(nums):
                # 如果i没有选过 并且满足题目要求的 pre % cur == 0 或 cur % pre == 0
                if (mask>>j&1) == 0 and (pre % cur == 0 or cur % pre == 0):
                    ans += dfs(j, mask|(1<<j))
            return ans
        
        return sum(dfs(i, 1<<i) for i in range(n)) % MOD

# 作者：0XFFF
# 链接：https://leetcode.cn/problems/special-permutations/solutions/2822586/zhuang-ya-dppython3java-by-meilicat-f7a2/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
