import java.util.Scanner;

public class LengthOfLongestPalindromicSubSequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter string:");
    String str = sc.next();
    int res = findLongestPalindromicSubSequence(str);
    System.out.println("Length of Longest Palindromic sub sequence is: " + res);
    sc.close();
  }

  // Function to find the longest palindromic subsequence
  private static int findLongestPalindromicSubSequence(String str) {
    String revStr = new StringBuilder(str).reverse().toString();
    return LCS(str, revStr);
  }

  // Function to find the longest common subsequence
  private static int LCS(String a, String b) {
    int m = a.length();
    int n = b.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }
}
