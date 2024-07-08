import java.util.Scanner;
import java.util.Stack;

class LengthOfLongestValidParentheses {

  public static int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    int maxLength = 0;
    stack.push(-1); // Base for the first valid substring

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        System.out.print(i + " ");
        stack.push(i); // Push the index of the '('
      } else {
        stack.pop(); // Pop the index of the last unmatched '('
        if (stack.isEmpty()) {
          System.out.print(i + " ");
          stack.push(i); // Push the index of the current ')'
        } else {
          System.out.print(i - stack.peek() + " ");
          maxLength = Math.max(maxLength, i - stack.peek()); // Calculate the length of the current valid substring
        }
      }
    }
    System.out.println();

    return maxLength;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the string containing parentheses:");
    String input = scanner.nextLine();

    int result = longestValidParentheses(input);

    System.out.println("The length of the longest valid parentheses substring is: " + result);
    scanner.close();
  }
}
