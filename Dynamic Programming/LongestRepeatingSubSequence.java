import java.util.Scanner;

public class LongestRepeatingSubSequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string:");
    String str = sc.next();
    int res = findLongestRepeatingSubSequenceLength(str);
    System.out.println("Length of Longest Repeating SubSequence is: " + res);
    sc.close();
  }

  private static int findLongestRepeatingSubSequenceLength(String str) {
    int n = str.length();
    int dp[][] = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i != j && str.charAt(i - 1) == str.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][n];
  }
}
