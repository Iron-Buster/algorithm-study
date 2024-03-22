
# 20. 有效的括号
# 提示
# 简单
# 4K
# 相关企业
# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
#
# 有效字符串需满足：
#
# 左括号必须用相同类型的右括号闭合。
# 左括号必须以正确的顺序闭合。
# 每个右括号都有一个对应的相同类型的左括号。


class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for i, x in enumerate(s):
            if x == '(':
                st.append(')')
            elif x == '[':
                st.append(']')
            elif x == '{':
                st.append('}')
            elif not st or x != st.pop():
                return False
        return not st




if __name__ == '__main__':
    s = "()"
    ret = Solution().isValid(s)
    print(ret)