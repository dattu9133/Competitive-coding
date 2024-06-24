import java.util.Scanner;

public class LongestPalindromicSubString {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String:");
    String str = sc.next();
    String res = findLongestPalindromicSubstring(str);
    System.out.println("Longest Palindromic substring is: " + res);
    sc.close();
  }

  private static String findLongestPalindromicSubstring(String str) {
    int n = str.length();
    if (n == 0)
      return "";

    boolean[][] dp = new boolean[n][n];
    int start = 0, maxLength = 1;

    // All substrings of length 1 are palindromes
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }

    // Check for substrings of length 2
    boolean found = false;
    for (int i = 0; i < n - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        dp[i][i + 1] = true;
        if (!found) {
          start = i;
          maxLength = 2;
          found = true;
        }

      }
    }

    // Check for lengths greater than 2
    for (int k = 3; k <= n; k++) {
      for (int i = 0; i < n - k + 1; i++) {
        int j = i + k - 1;
        if (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
          dp[i][j] = true;
          if (k > maxLength) {
            start = i;
            maxLength = k;
          }
        }
      }
    }

    return str.substring(start, start + maxLength);
  }

  @SuppressWarnings("unused")
  // Naive Approach
  private static String findLongestPalindromicSubstringOn3(String str) {
    int n = str.length();
    int maxLength = 1;
    int start = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        String res = str.substring(i, j + 1);
        if (isPalindrome(res)) {
          if (j - i + 1 > maxLength) {
            maxLength = j - i + 1;
            start = i;
          }
        }
      }
    }
    return str.substring(start, start + maxLength);
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
