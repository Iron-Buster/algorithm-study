package contest;

public class B {


    public static String solution(String s) {
        // write code here

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '?') {
                int t = 0;
                for (int j = 0; j < 26; j++) {
                    if (i > 0 && cs[i-1] == (char) ('a' + j)) {
                        continue;
                    }
                    if (i + 1 < cs.length && cs[i+1] == (char) ('a' + j)) {
                        continue;
                    }
                    t = j;
                    break;
                }
                cs[i] = (char) ('a' + t);
            }
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(solution("?ab").equals("bab"));
        System.out.println(solution("v?yz?").equals("vayza"));
        System.out.println(solution("?xyz??").equals("axyzab"));
        System.out.println(solution("b??b?").equals("bacba"));
        System.out.println(solution("???z").equals("abaz"));
    }
}
