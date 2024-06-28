import java.util.Scanner;

// There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e., the length of the garden is n).
// There are n + 1 taps located at points [0, 1, ..., n] in the garden.
// Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means 
// the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
// Return the minimum number of taps that should be open to water the whole garden, 
// If the garden cannot be watered return -1.

class MinTapsToWaterGarden {

  public static int minTaps(int n, int[] ranges) {
    int[] dp = new int[n + 1];
    dp[0] = 0; // No tap needed to cover up to position 0

    // Initialize dp array with a large value (unreachable state)
    for (int i = 1; i <= n; i++) {
      dp[i] = n + 2;
    }

    // Fill the dp array
    for (int i = 0; i <= n; i++) {
      int start = Math.max(0, i - ranges[i]);
      int end = Math.min(n, i + ranges[i]);
      for (int j = start; j <= end; j++) {
        dp[j] = Math.min(dp[j], 1 + dp[start]);
      }
    }

    // Return the result
    return dp[n] != n + 2 ? dp[n] : -1;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the length of the garden (n): ");
    int n = scanner.nextInt();

    System.out.println("Enter the ranges array: ");
    int[] ranges = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      ranges[i] = scanner.nextInt();
    }

    int result = minTaps(n, ranges);
    System.out.println("Minimum number of taps needed: " + result);

    scanner.close();
  }
}
