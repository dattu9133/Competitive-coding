import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String:");
    String x = sc.next();
    if (isValid(x))
      System.out.println("Balanced");
    else
      System.out.println("Not Balanced");
    sc.close();
  }

  private static boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (char c : s.toCharArray()) {
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
      else if (stack.isEmpty() || stack.pop() != c)
        return false;
    }
    return stack.isEmpty();
  }
}