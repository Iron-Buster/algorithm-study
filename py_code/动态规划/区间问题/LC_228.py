# 228. 汇总区间
# 简单
# 345
# 相关企业
# 给定一个  无重复元素 的 有序 整数数组 nums 。

# 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

# 列表中的每个区间范围 [a,b] 应该按如下格式输出：

# "a->b" ，如果 a != b
# "a" ，如果 a == b



from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if not nums: return []
        res = []
        head = nums[0]
        last = nums[0]
        for i in range(1, len(nums)):
            if last + 1 == nums[i]:
                last = nums[i]
                continue
            if head == last:
                res.append(str(head))
            else:
                res.append(str(head) + "->" + str(last))
            head = nums[i]
            last = nums[i]
        # 检查最后一次
        if head == last:
            res.append(str(head))
        else:
            res.append(str(head) + "->" + str(last))
        return res
