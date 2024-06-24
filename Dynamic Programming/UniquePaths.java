import java.util.Scanner;

public class UniquePaths {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of rows (m): ");
    int m = scanner.nextInt();

    System.out.print("Enter the number of columns (n): ");
    int n = scanner.nextInt();

    System.out.println("Number of unique paths for grid " + m + "x" + n + ": " + uniquePaths(m, n));
    scanner.close();
  }

  private static int uniquePaths(int m, int n) {
    int dp[][] = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  @SuppressWarnings("unused")
  private static int uniquePathsR(int m, int n) {
    // Implementation goes here
    if (m == 0 || n == 0) {
      return 1;
    }
    return uniquePathsR(m - 1, n) + uniquePathsR(m, n - 1);
  }
}
