import java.util.*;
class TrapingRainWater{
    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int curIndex = 0;

        while (curIndex < n) {

            while (!stack.isEmpty() && height[stack.peek()]
                < height[curIndex]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int h = Math.min(height[stack.peek()], height[curIndex]) - height[top];
                int dist = curIndex - stack.peek() - 1;
                res += dist * h;
            }

            stack.push(curIndex++);
        }

        return res;
    }
}