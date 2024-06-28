
import java.util.Scanner;

class CountDistantSubSequenceBetweenTwoStrings {
  static int prime = (int) (Math.pow(10, 9) + 7);

  static int subsequenceCounting(String s1, String s2, int n, int m) {
    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i < m + 1; i++) {
      dp[0][i] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter string 1:");
    String s1 = sc.next();
    System.out.println("Enter string 2:");
    String s2 = sc.next();
    System.out
        .println("The Count of Distinct Subsequences is " + subsequenceCounting(s1, s2, s1.length(), s2.length()));
    sc.close();
  }
}
