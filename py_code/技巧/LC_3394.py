
# https://leetcode.cn/problems/check-if-grid-can-be-cut-into-sections/

class Solution:
    def checkValidCuts(self, n: int, a: List[List[int]]) -> bool:
        m = len(a)
        a.sort(key=lambda x: x[0])
        cnt = 1
        max_r = a[0][2]
        for i in range(1, m):
            l, r = a[i][0], a[i][2]
            if l >= max_r:
                cnt += 1
            if r > max_r:
                max_r = r
        if cnt >= 3:
            return True
        a.sort(key=lambda x: x[1])
        cnt = 1
        max_r = a[0][3]
        for i in range(1, m):
            l, r = a[i][1], a[i][3]
            if l >= max_r:
                cnt += 1
            if r > max_r:
                max_r = r
        return cnt >= 3