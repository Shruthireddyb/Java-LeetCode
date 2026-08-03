import java.util.*;
class BasicCalculator{
    public int calculate(String s) {
        Queue<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                q.offer(c);
            }
        }
        q.offer(' ');
        return helper(q);
    }
    int helper(Queue<Character> q) {
    int sum = 0, prev = 0, num = 0;
    char prevOp = '+'; // 1. initialize
    
    while(!q.isEmpty()) {
        char c = q.poll();
        
        if(Character.isDigit(c)) {
            num = num * 10 + c - '0';
        } 
        else if(c == '(') {
            num = helper(q);
        } 
        else { // operator or ')'
            switch(prevOp) { // 2. switch works now
                case '+': sum += prev; prev = num; break;
                case '-': sum += prev; prev = -num; break;
            }
            if(c == ')') break; // end of this recursive call
            prevOp = c; // 3. update operator
            num = 0;
        }
    }
    sum += prev; // add last number
    return sum;
}
}