import java.util.Arrays;

public class OrderlyQueue {
  public String orderlyQueue(String s, int k) {
        int n = s.length();
        if (k == 1) {
            StringBuilder cur = new StringBuilder(s);
            String res = new String();
            for (int i = 0; i < n; i++) {
                char firstChar = cur.charAt(0);
                cur.deleteCharAt(0);
                cur.append(firstChar);
                if (cur.toString().compareTo(res) < 0) {
                    res = cur.toString();
                }
            }
            return res;
        }
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}