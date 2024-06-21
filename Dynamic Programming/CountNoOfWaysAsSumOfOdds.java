import java.util.Scanner;

public class CountNoOfWaysAsSumOfOdds {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int n = sc.nextInt();
    int res = countWays(n);
    System.out.println("No. of ways: " + res);
    sc.close();
  }

  private static int countWays(int n) {
    if (n < 0)
      return 0;
    if (n < 2)
      return 1;
    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

}
