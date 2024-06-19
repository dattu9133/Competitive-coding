import java.util.Scanner;

public class SmallestSubArrayWithSumGreaterThanGivenSum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int n = scanner.nextInt();

    int[] array = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }

    System.out.print("Enter the value of sum: ");
    int x = scanner.nextInt();

    scanner.close();
    int res = findMinimumLengthSubArray(array, x, n);
    if (res < n)
      System.out.println("Length of minimum sub array is: " + res);
    else
      System.out.println("No subarray found.");
  }

  private static int findMinimumLengthSubArray(int[] a, int x, int n) {
    int minLength = n + 1; // Initialize minLength to be larger than any possible subarray length
    int currSum = 0;
    int start = 0, end = 0;

    while (end < n) {
      // Add elements to currSum until it becomes greater than x
      while (currSum <= x && end < n) {
        currSum += a[end];
        end++;
      }

      // Now remove elements from the start to find the smallest subarray with sum > x
      while (currSum > x && start < n) {
        if (end - start < minLength) {
          minLength = end - start;
        }
        currSum -= a[start];
        start++;
      }
    }

    return minLength;
  }
}