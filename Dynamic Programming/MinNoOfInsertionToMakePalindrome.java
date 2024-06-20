import java.util.Scanner;

public class MinNoOfInsertionToMakePalindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String:");
    String str = sc.next();
    int res = findMinInsertions(str);
    sc.close();
    System.out.println("Minimum no. of insertions required to make given string Palindrome: " + res);
  }

  // DP + Tabulation
  private static int findMinInsertions(String str) {
    int n = str.length();
    int[][] dp = new int[n][n];
    for (int gap = 1; gap < n; ++gap) {
      for (int l = 0, h = gap; h < n; ++l, ++h) {
        if (str.charAt(l) == str.charAt(h)) {
          dp[l][h] = dp[l + 1][h - 1];
        } else {
          dp[l][h] = Math.min(dp[l][h - 1], dp[l + 1][h]) + 1;
        }
      }
    }

    return dp[0][n - 1];
  }

  // DP + LCS
  // private static int findMinInsertions(String str) {
  // String revStr = new StringBuilder(str).reverse().toString();
  // int n = str.length();
  // return n - LCS(str, revStr);
  // }

  // private static int LCS(String a, String b) {
  // int m = a.length();
  // int n = b.length();
  // int[][] dp = new int[m + 1][n + 1];

  // for (int i = 0; i <= m; i++) {
  // for (int j = 0; j <= n; j++) {
  // if (i == 0 || j == 0) {
  // dp[i][j] = 0;
  // } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
  // dp[i][j] = dp[i - 1][j - 1] + 1;
  // } else {
  // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
  // }
  // }
  // }

  // return dp[m][n];
  // }

  // Recursion
  // private static int findMinInsertions(char[] str, int l, int h) {
  // // Base Cases
  // if (l > h)
  // return -1; // Invalid case
  // if (l == h)
  // return 0; // Single character is already a palindrome
  // if (l == h - 1)
  // return (str[l] == str[h]) ? 0 : 1; // Two characters, either they are same or
  // different

  // // Recursive Cases
  // if (str[l] == str[h]) {
  // return findMinInsertions(str, l + 1, h - 1);
  // } else {
  // // Insert a character at position h + 1 to match str[l]
  // (findMinInsertions(str,
  // // l + 1, h)).

  // // Insert a character at position l - 1 to match str[h]
  // (findMinInsertions(str,
  // // l, h - 1)).
  // return Math.min(findMinInsertions(str, l + 1, h), findMinInsertions(str, l, h
  // - 1)) + 1;
  // }
  // }
}
