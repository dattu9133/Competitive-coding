import java.util.Scanner;

public class CountNoOfWaysEvenAsSumOfEvens {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the even number:");
    int n = sc.nextInt();
    int res = countWays(n);
    System.out.println("No. of ways: " + res);
    sc.close();
  }

  private static int countWays(int n) {
    int dp[] = new int[n + 1];
    dp[2] = 1;
    for (int i = 4; i <= n; i += 2) {
      dp[i] = 2 * dp[i - 2];
      // System.out.println(dp[i]);
    }
    return dp[n];
  }

}
