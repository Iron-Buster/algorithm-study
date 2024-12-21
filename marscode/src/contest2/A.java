package contest2;

import java.util.Arrays;

public class A {

    public static int solution(int[][] financials) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        int ans = 0;
        for (int[] f : financials) {
            ans = Math.max(ans, Arrays.stream(f).sum());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{new int[]{2, 4, 6}, new int[]{4, 3, 2}}) == 12);
        System.out.println(solution(new int[][]{new int[]{3, 9}, new int[]{8, 2}, new int[]{5, 6}}) == 12);
        System.out.println(solution(new int[][]{new int[]{5, 5, 9, 3}, new int[]{6, 2, 3, 1}, new int[]{3, 4, 10, 2}}) == 22);
    }
}
