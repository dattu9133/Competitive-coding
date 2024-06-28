import java.util.Scanner;

public class SubsetSumPartition {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int n = scanner.nextInt();
    int[] array = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }

    if (canPartition(array, n)) {
      System.out.println("The array can be partitioned into two subsets with equal sum.");
    } else {
      System.out.println("The array cannot be partitioned into two subsets with equal sum.");
    }

    scanner.close();
  }

  private static boolean canPartition(int[] array, int n) {
    int totalSum = 0;
    for (int i : array) {
      totalSum += i;
    }

    if (totalSum % 2 != 0) {
      return false;
    }

    int subsetSum = totalSum / 2;

    boolean dp[][] = new boolean[n + 1][subsetSum + 1];
    for (int i = 0; i <= n; i++)
      dp[i][0] = true;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= subsetSum; j++) {
        if (array[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - array[i - 1]];
        } else
          dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[n][subsetSum];
  }
}
