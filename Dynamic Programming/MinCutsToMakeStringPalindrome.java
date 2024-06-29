import java.util.Scanner;

public class MinCutsToMakeStringPalindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String:");
    String str = sc.next();
    int res = minCuts(str, 0, str.length() - 1);
    System.out.println("Minimum cuts to make all sub strings as Palindrome: " + res);
    sc.close();
  }

  private static int minCuts(String X, int i, int j) {
    if (i == j || isPalindrome(X, i, j)) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      int c = 1 + minCuts(X, i, k) + minCuts(X, k + 1, j);
      min = Math.min(min, c);
    }

    return min;
  }

  private static boolean isPalindrome(String x, int i, int j) {
    while (i <= j) {
      if (x.charAt(i) != x.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
