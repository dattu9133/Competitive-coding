import java.util.Scanner;

public class MinCutsToMakeStringPalindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String:");
    String str = sc.next();

    boolean[][] p = new boolean[str.length()][str.length()];
    findAllPalindromes(str, p);

    int res = minCuts(str, p);
    System.out.println("Minimum cuts to make all sub strings as Palindrome: " + res);
    sc.close();
  }

  @SuppressWarnings("unused")
  // Recursion
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

  private static void findAllPalindromes(String X, boolean[][] dp) {
    int n = X.length();
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if (i == j) {
          dp[i][j] = true;
        } else if (X.charAt(i) == X.charAt(j)) {
          if (i + 1 == j) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }
      }
    }
  }

  private static int minCuts(String X, boolean[][] p) {
    int n = X.length();
    int[] dp = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      dp[i] = Integer.MAX_VALUE;
      if (p[i][n - 1]) {
        dp[i] = 0;
      } else {
        for (int j = i; j < n; j++) {
          if (p[i][j]) {
            dp[i] = Math.min(dp[i], 1 + (j + 1 < n ? dp[j + 1] : 0));
          }
        }
      }
    }
    return dp[0];
  }
}
