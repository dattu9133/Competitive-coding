import java.util.Scanner;

public class LargestRectangleWithOnes {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Read dimensions of the matrix
    System.out.print("Enter the number of rows (n): ");
    int n = scanner.nextInt();
    System.out.print("Enter the number of columns (m): ");
    int m = scanner.nextInt();

    // Initialize the matrix
    int[][] M = new int[n][m];

    // Read matrix elements
    System.out.println("Enter the matrix elements row by row (0 or 1):");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        M[i][j] = scanner.nextInt();
      }
    }

    // Close the scanner
    scanner.close();

    int result = maxArea(M, n, m);
    System.out.println("Maximum size rectangle area in binary sub-matrix with all 1's: " + result);
  }

  public static int maxArea(int[][] M, int n, int m) {
    if (n == 0 || m == 0)
      return 0;

    int maxArea = 0;
    int[] left = new int[m]; // initialize left as the leftmost boundary possible
    int[] right = new int[m]; // initialize right as the rightmost boundary possible
    int[] height = new int[m]; // initialize height as 0

    for (int i = 0; i < m; i++)
      right[i] = m; // right bound is initially m for all columns

    for (int i = 0; i < n; i++) {
      int curLeft = 0, curRight = m;
      // Update height
      for (int j = 0; j < m; j++) {
        if (M[i][j] == 1)
          height[j]++;
        else
          height[j] = 0;
      }
      // Update left
      for (int j = 0; j < m; j++) {
        if (M[i][j] == 1)
          left[j] = Math.max(left[j], curLeft);
        else {
          left[j] = 0;
          curLeft = j + 1;
        }
      }
      // Update right
      for (int j = m - 1; j >= 0; j--) {
        if (M[i][j] == 1)
          right[j] = Math.min(right[j], curRight);
        else {
          right[j] = m;
          curRight = j;
        }
      }
      // Update the area
      for (int j = 0; j < m; j++) {
        maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
      }
    }

    return maxArea;
  }

}