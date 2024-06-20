import java.util.Scanner;

public class CountNoOfWaysInSumOfGivenNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int n = sc.nextInt();
    int res = countWays(n);
    System.out.println("No. of ways: " + res);
    sc.close();
  }

  private static int countWays(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;
    for (int i = 4; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
    }
    return dp[n];
  }
}
