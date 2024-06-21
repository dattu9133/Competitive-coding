import java.util.Scanner;

public class MinNoOfPrefectSquaresAsSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int n = sc.nextInt();
    int res = minPrefectSquares(n);
    System.out.println("No. of ways: " + res);
    sc.close();
  }

  private static int minPrefectSquares(int n) {
    int dp[] = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= Math.sqrt(i); j++) {
        min = Math.min(min, i - j * j);
      }
      dp[i] = min + 1;
    }
    return dp[n];
  }
}
