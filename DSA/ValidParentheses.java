import java.util.Stack;
public class ValidParentheses {
      public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            // Push opening brackets
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Check closing brackets
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // true if all matched
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]"));     // false
    }
}
