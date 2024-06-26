import java.util.Scanner;

public class FrogJump {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of stairs:");
    int n = sc.nextInt();
    int[] heights = new int[n];
    System.out.println("Enter the heights of the stairs:");
    for (int i = 0; i < n; i++) {
      heights[i] = sc.nextInt();
    }

    int result = minEnergy(heights, n);
    System.out.println("The minimum energy used by the frog is: " + result);
    sc.close();
  }

  private static int minEnergy(int[] heights, int n) {
    if (n == 1) {
      return 0; // No energy needed if there is only one stair
    }

    int[] dp = new int[n];
    dp[0] = 0; // Starting on the first stair

    for (int i = 1; i < n; i++) {
      int oneStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
      int twoSteps = Integer.MAX_VALUE;
      if (i > 1) {
        twoSteps = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
      }
      dp[i] = Math.min(oneStep, twoSteps);
    }

    return dp[n - 1];
  }
}
