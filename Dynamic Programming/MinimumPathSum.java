import java.util.Scanner;

public class MinimumPathSum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of rows (m): ");
    int m = scanner.nextInt();

    System.out.print("Enter the number of columns (n): ");
    int n = scanner.nextInt();

    int grid[][] = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println("Enter cost at " + i + " X " + j + " :");
        grid[i][j] = scanner.nextInt();
      }
    }

    System.out.println("Minimum path sum for grid " + m + " x " + n + ": " + findMinimumPathSum(m, n, grid));
    System.out.println(
        "Minimum path sum for grid " + m + " x " + n + " (recursive): " + findMinimumPathSumR(m - 1, n - 1, grid));
    scanner.close();
  }

  // Dynamic Programming
  private static int findMinimumPathSum(int m, int n, int[][] grid) {
    int dp[][] = new int[m][n];
    dp[0][0] = grid[0][0];

    // Initialize first column of the dp array
    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

    // Initialize first row of the dp array
    for (int j = 1; j < n; j++) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }

    // Fill the rest of the dp array
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[m - 1][n - 1];
  }

  // Recursion
  private static int findMinimumPathSumR(int i, int j, int[][] cost) {
    if (i == 0 && j == 0) {
      return cost[0][0];
    }

    if (i == 0) {
      return findMinimumPathSumR(i, j - 1, cost) + cost[i][j];
    }

    if (j == 0) {
      return findMinimumPathSumR(i - 1, j, cost) + cost[i][j];
    }

    return Math.min(findMinimumPathSumR(i - 1, j, cost), findMinimumPathSumR(i, j - 1, cost)) + cost[i][j];
  }
}
