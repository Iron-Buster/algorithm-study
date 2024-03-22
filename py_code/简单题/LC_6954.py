from typing import List


# 6954. 统计和小于目标的下标对数目


class Solution:
    def countPairs(self, nums: List[int], target: int) -> int:
        return sum(nums[i] + nums[j] < target for i in range(len(nums)) for j in range(i + 1, len(nums)))


if __name__ == '__main__':
    print("Ok")