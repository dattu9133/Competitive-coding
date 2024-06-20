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
    if (n == 0)
      return 1; // Base case: there's one way to make 0, by not choosing any numbers
    if (n < 0)
      return 0; // No way to form a negative number with positive integers

    int[] dp = new int[n + 1];
    dp[0] = 1; // One way to form 0

    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1]; // Always possible to form 'i' by adding 1
      if (i >= 3)
        dp[i] += dp[i - 3]; // Possible to form 'i' by adding 3
      if (i >= 4)
        dp[i] += dp[i - 4]; // Possible to form 'i' by adding 4
    }
    return dp[n];
  }
}
