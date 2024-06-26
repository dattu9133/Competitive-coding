import java.util.Scanner;

public class PaintingFence {
  private static final int MOD = 1000000007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of posts (n):");
    int n = sc.nextInt();

    System.out.println("Enter the number of colors (k):");
    int k = sc.nextInt();

    int result = countWays(n, k);
    System.out.println("Number of ways to paint the fence: " + result);

    sc.close();
  }

  private static int countWays(int n, int k) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }

    long[] dp = new long[n + 1];
    dp[1] = k;
    dp[2] = (long) k * k % MOD;

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] * (k - 1) % MOD + dp[i - 2] * (k - 1) % MOD) % MOD;
    }

    return (int) dp[n];
  }
}
