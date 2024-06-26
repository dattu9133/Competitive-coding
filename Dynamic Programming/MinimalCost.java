import java.util.Scanner;

public class MinimalCost {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter n:");
    int n = sc.nextInt();
    System.out.println("Enter heights:");
    int heights[] = new int[n];
    for (int i = 0; i < heights.length; i++) {
      heights[i] = sc.nextInt();
    }
    System.out.println("Enter k:");
    int k = sc.nextInt();
    int res = findMinimal(heights, n, k);
    System.out.println("Minimal cost is: " + res);
    sc.close();
  }

  private static int findMinimal(int[] heights, int n, int k) {
    int[] dp = new int[n];
    dp[0] = 0; // starting at the first stone with no cost

    for (int i = 1; i < n; i++) {
      dp[i] = Integer.MAX_VALUE; // initialize dp[i] with a large value
      for (int j = 1; j <= k; j++) {
        if (i - j >= 0) {
          dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(heights[i] - heights[i - j]));
        }
      }
    }

    return dp[n - 1];
  }
}
