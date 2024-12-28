package contest3;

public class A {

    public static int solution(String[] instructions) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        int ans = 0;
        for (var s : instructions) {
            if (s.equals("++")) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"++", "--", "++"}) == 1);
        System.out.println(solution(new String[]{"++", "++", "--", "--"}) == 0);
        System.out.println(solution(new String[]{"++", "++", "--"}) == 1);
    }
}
