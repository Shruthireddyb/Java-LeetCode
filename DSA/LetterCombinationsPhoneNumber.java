import java.util.ArrayList;
import java.util.List;

class LetterCombinationsPhoneNumber{
  public List<String> letterCombinations3(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        helper(digits, 0, mapping, res, new StringBuilder());
        return res;
    }
    
    private void helper(String digits, int index, String[] mapping, 
        List<String> res, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
        } else {
            String digit = digits.substring(index, index + 1);
            for (char c : mapping[Integer.parseInt(digit)].toCharArray()) {
                sb.append(c);
                helper(digits, index + 1, mapping, res, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}