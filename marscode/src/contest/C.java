package contest;

public class C {


    static int[][] matrixSum(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] g = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + 1;
                int y = j + 1;
                g[x][y] = a[i][j] + g[x-1][y] + g[x][y-1] - g[x-1][y-1];
            }
        }
        return g;
    }

    public static int solution(int[][] gems, int M) {
        // write code here
        int[][] g = matrixSum(gems);

        int n = gems.length;
        int m = gems[0].length;
        int maxLen = 0;
        for (int len = 1; len <= Math.min(n, m); len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                for (int j = 1; j <= m - len + 1; j++) {
                    int x2 = i + len - 1;
                    int y2 = j + len - 1;
                    int sum = g[x2][y2]
                            - g[i - 1][y2]
                            - g[x2][j - 1]
                            + g[i - 1][j - 1];
                    if (sum <= M) {
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{new int[]{1, 1, 2, 3}, new int[]{1, 1, 2, 3}, new int[]{2, 2, 3, 4}}, 5) == 2);
        System.out.println(solution(new int[][]{new int[]{3, 3, 3}, new int[]{3, 3, 3}, new int[]{3, 3, 3}}, 9) == 1);
        System.out.println(solution(new int[][]{new int[]{4}}, 5) == 1);
    }
}
