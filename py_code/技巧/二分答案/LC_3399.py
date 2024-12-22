# https://leetcode.cn/problems/smallest-substring-with-identical-characters-ii/

class Solution:
    def minLength(self, s: str, numOps: int) -> int:
        n = len(s)
        l = 1
        r = 100005

        def check(mid: int, ops: int) -> bool:
            if mid == 1:
                cnt = sum((ord(b) ^ i) & 1 for i, b in enumerate(s))
                cnt = min(cnt, n - cnt)
                return cnt <= ops
            else:
                cnt = 1
                for i in range(1, n):
                    if s[i] == s[i - 1]:
                        cnt += 1
                    else:
                        # 计算下cnt 要操作多少次 才不存在任意一段连续数量>mid
                        need = cnt // (mid + 1)
                        if need > ops:
                            return False
                        ops -= need
                        cnt = 1
                if cnt > 1:
                    need = cnt // (mid + 1)
                    if need > ops:
                        return False
                return True

        while l < r:
            mid = l + r >> 1
            if check(mid, numOps):
                r = mid
            else:
                l = mid + 1
        return l
