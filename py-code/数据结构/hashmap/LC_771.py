

# 771. 宝石与石头
# 提示
# 简单
# 789
# 相关企业
#  给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
#
# 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        return sum(stones.count(x) for x in jewels)


if __name__ == '__main__':
    print("ok")