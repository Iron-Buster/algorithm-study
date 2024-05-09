# https://leetcode.cn/problems/watering-plants-ii/description/

'''
双指针模拟
'''
class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        n = len(plants)
        i, j = 0, n - 1
        v1, v2 = capacityA, capacityB
        ans = 0
        while i <= j:
            if i == j:
                if v1 == v2 or v1 > v2:
                    ans += v1 < plants[i]
                else:
                    ans += v2 < plants[i]
                break

            if v1 < plants[i]:
                ans += 1
                v1 = capacityA - plants[i]
            else:
                v1 -= plants[i]

            if v2 < plants[j]:
                ans += 1
                v2 = capacityB - plants[j]
            else:
                v2 -= plants[j]

            i += 1
            j -= 1
        return ans
