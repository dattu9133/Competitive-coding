import java.util.Scanner;

public class CoinsChange {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int N = sc.nextInt();
    System.out.println("Enter the no. of coins:");
    int n = sc.nextInt();
    int coins[] = new int[n];
    System.out.println("Enter the coins:");
    for (int i = 0; i < n; i++) {
      coins[i] = sc.nextInt();
    }
    int res = minCoins(coins, n, N);
    if (res == Integer.MAX_VALUE) {
      System.out.println("No solution possible.");
    } else {
      System.out.println("Minimum number of coins: " + res);
    }
    sc.close();
  }

  private static int minCoins(int[] coins, int n, int N) {
    int count = 0;
    if (N == 0)
      return new int[] { count, Integer.MAX_VALUE };
    int dp[] = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    dp[0] = 0;

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j < n; j++) {
        if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
          // count += dp[i];
        }
      }
    }
    // dp[N - 1] = count;

    return dp[N];
  }
}
