import java.util.Scanner;

public class SubSetWithGivenSum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int n = scanner.nextInt();
    int[] array = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }
    System.out.print("Enter the sum: ");
    int sum = scanner.nextInt();

    if (isSubset(array, n, sum)) {
      System.out.println("There is a subset with sum of " + sum);
    } else {
      System.out.println("No subset with sum of " + sum);
    }

    scanner.close();
  }

  private static boolean isSubset(int[] array, int n, int sum) {
    boolean[][] dp = new boolean[n + 1][sum + 1];

    // If sum is 0, answer is true
    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }

    // If sum is not 0 and array is empty, answer is false
    for (int j = 1; j <= sum; j++) {
      dp[0][j] = false;
    }

    // Fill the subset table in bottom-up manner
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (array[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - array[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][sum];
  }
}
