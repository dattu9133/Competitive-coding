import java.util.Scanner;

public class CountNoOfWaysAsSumOfGivenElements {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number:");
    int N = scanner.nextInt();
    System.out.print("Enter the size of the array: ");
    int n = scanner.nextInt();
    int[] array = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }
    scanner.close();
    int res = countWays(array, n, N);
    System.out.println("No. of ways: " + res);
  }

  private static int countWays(int[] a, int n, int N) {
    int dp[] = new int[N + 1];
    dp[0] = 1;
    for (int i = 1; i < N + 1; i++) {
      for (int j = 0; j < n; j++) {
        if (i >= a[j])
          dp[i] += dp[i - a[j]];
      }
    }
    return dp[N];
  }

}