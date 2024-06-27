import java.util.Scanner;

/**
 * UncrossedLines
 */
public class UncrossedLines {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of array: ");
    int n = sc.nextInt();
    System.out.println("Enter first array elements:");
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    System.out.println("Enter second array elements:");
    int b[] = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = sc.nextInt();
    }
    int res = findUncrossedLines(a, b, n);
    System.out.println("No. of uncrossed lines: " + res);
    sc.close();
  }

  private static int findUncrossedLines(int[] a, int[] b, int n) {

    int[][] dp = new int[a.length + 1][b.length + 1];
    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        if (a[i - 1] == b[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[a.length][b.length];

  }
}
