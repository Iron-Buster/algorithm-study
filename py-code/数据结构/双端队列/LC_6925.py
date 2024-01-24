# 6925.
# 故障键盘
# 提示
# 简单
# 0
# 你的笔记本键盘存在故障，每当你在上面输入字符
# 'i'
# 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
#
# 给你一个下标从
# 0
# 开始的字符串
# s ，请你用故障键盘依次输入每个字符。
#
# 返回最终笔记本屏幕上输出的字符串。
from collections import deque


class Solution:
    def finalString(self, s: str) -> str:
        q = deque()
        tail = True
        for c in s:
            if c == 'i':
                tail = not tail
            elif tail:
                q.append(c)
            else:
                q.appendleft(c)

        return ''.join(q if tail else reversed(q))


if __name__ == '__main__':
    print("Ok")