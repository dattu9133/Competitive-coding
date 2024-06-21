import java.util.Scanner;

public class GetMaxInGeneratedArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter n:");
    int n = sc.nextInt();
    int res = findMaxInGeneratedArray(n);
    System.out.println("Maximum element in generated array: " + res);
    sc.close();
  }

  private static int findMaxInGeneratedArray(int n) {
    if (n == 0)
      return 0;
    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    int max = 1;
    for (int i = 2; i <= n; i++) {
      if (i % 2 == 0) {
        dp[i] = dp[i / 2];
        max = Math.max(max, dp[i]);
      } else {
        int index = (int) i / 2;
        dp[i] = dp[index] + dp[index + 1];
        max = Math.max(max, dp[i]);
      }
    }
    return max;
  }
}
