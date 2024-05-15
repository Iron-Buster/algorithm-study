# https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks/?envType=daily-question&envId=2024-05-14

class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        cnt = Counter(tasks)
        # @cache
        # def dfs(x: int) -> int:
        #     if x == 0: return 0
        #     if x < 0: return inf
        #     return 1 + min(dfs(x - 3), dfs(x - 2))
        
        # ans = 0
        # for c in cnt.values():
        #     res = dfs(c)   
        #     if res == inf:
        #         return -1
        #     ans += res
        # return ans

        if 1 in cnt.values():
            return -1
        return sum((c + 2) // 3 for c in cnt.values())
