import java.util.Scanner;

public class UniquePathsWithObstacle {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of rows (m): ");
    int m = scanner.nextInt();

    System.out.print("Enter the number of columns (n): ");
    int n = scanner.nextInt();

    int grid[][] = new int[m][n];
    System.out.println("Enter row and column of block:");
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == x && j == y) {
          grid[i][j] = 1;
        }
      }
    }

    System.out.println("Number of unique paths for grid " + m + " x " + n + ": " + uniquePaths(m, n, grid));
    scanner.close();
  }

  private static int uniquePaths(int m, int n, int[][] grid) {
    if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
      return 0;

    int[][] dp = new int[m][n];

    // Initialize the starting point
    dp[0][0] = 1;

    // Fill the first column
    for (int i = 1; i < m; i++) {
      dp[i][0] = grid[i][0] == 1 ? 0 : dp[i - 1][0];
    }

    // Fill the first row
    for (int j = 1; j < n; j++) {
      dp[0][j] = grid[0][j] == 1 ? 0 : dp[0][j - 1];
    }

    // Fill the rest of the grid
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (grid[i][j] == 1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }

    return dp[m - 1][n - 1];
  }
}
