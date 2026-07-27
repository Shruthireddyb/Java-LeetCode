public class ReverseString {
  //O(n) time, O(1) space
    public static String reverse(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while(i < j) {
            // swap
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
public static void main(String[] args) {
        String input = "hello";
        System.out.println("Reversed: " + reverse(input));

    }
}

