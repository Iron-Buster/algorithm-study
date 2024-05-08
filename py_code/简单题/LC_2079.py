# https://leetcode.cn/problems/watering-plants/
class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        ans = 0
        plants = [0] + plants
        cur = capacity
        for i in range(1, len(plants)):
            if cur >= plants[i]:
                ans += 1
                cur -= plants[i]
            else:
                ans += 2 * i - 1
                cur = capacity - plants[i]
        return ans
