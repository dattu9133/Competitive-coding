import java.util.Scanner;

public class LargestSquareWithOnes {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Taking dimensions of the matrix
    System.out.print("Enter number of rows (N): ");
    int N = scanner.nextInt();
    System.out.print("Enter number of columns (M): ");
    int M = scanner.nextInt();

    int[][] A = new int[N][M];

    // Taking matrix input
    System.out.println("Enter the matrix (row by row, space-separated): ");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        A[i][j] = scanner.nextInt();
      }
    }

    // Calling the function to find the maximum size square sub-matrix with all 1's
    int maxSquareArea = findMaximalSquare(A);
    System.out.println("The area of the maximum size square sub-matrix with all 1's is: " + maxSquareArea);
  }

  public static int findMaximalSquare(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    int N = matrix.length;
    int M = matrix[0].length;
    int[][] dp = new int[N][M];
    int maxSide = 0;

    // Initialize dp matrix and find the maximum side length of square sub-matrix
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        // If the cell is in the first row or first column, just copy the value from the
        // original matrix
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        } else {
          dp[i][j] = 0;
        }
        // Update the maximum side length found so far
        maxSide = Math.max(maxSide, dp[i][j]);
      }
    }

    // The area of the largest square is side^2
    return maxSide * maxSide;
  }
}
