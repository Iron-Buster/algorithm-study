# https://leetcode.cn/problems/n-queens/

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [['.' for _ in range(n)] for _ in range(n)]
        
        def check(row: int, col: int) -> bool:
            for i in range(row):
                if board[i][col] == 'Q':
                    return False
            i = row - 1
            j = col - 1
            while i >= 0 and j >= 0:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j -= 1
            i = row - 1
            j = col + 1
            while i >= 0 and j < n:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j += 1
            return True
        
        def dfs(row: int) -> int:
            if row == n:
                res.append([''.join(r) for r in board])
                return
            for col in range(n):
                if check(row, col):
                    board[row][col] = 'Q'
                    dfs(row + 1)
                    board[row][col] = '.'
        
        dfs(0)
        return res
                
