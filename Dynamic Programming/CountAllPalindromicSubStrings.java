import java.util.Scanner;

public class CountAllPalindromicSubStrings {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String:");
    String str = sc.next();
    int res = findCountAllPalindromicSubStrings(str);
    System.out.println("Count of All Palindromic Substrings: " + res);
    sc.close();
  }

  private static int findCountAllPalindromicSubStrings(String str) {
    int n = str.length();
    int c = 0;
    boolean dp[][] = new boolean[n][n];

    // Single character palindromes
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
      c++;
    }

    // Two consecutive character palindromes
    for (int i = 0; i < n - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        dp[i][i + 1] = true;
        c++;
      }
    }

    // Palindromes of length 3 or more
    for (int k = 3; k <= n; k++) {
      for (int i = 0; i < n - k + 1; i++) {
        int j = i + k - 1;
        if (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
          dp[i][j] = true;
          c++;
        }
      }
    }
    return c;
  }

  @SuppressWarnings("unused")
  // Recursion
  private static int findCountAllPalindromicSubStringsR(String str) {
    int n = str.length();
    int c = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        String res = str.substring(i, j + 1);
        if (isPalindrome(res)) {
          c++;
        }
      }
    }
    return c;
  }

  private static boolean isPalindrome(String string) {
    int i = 0;
    int j = string.length() - 1;
    while (i <= j) {
      if (string.charAt(i) != string.charAt(j)) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

}
