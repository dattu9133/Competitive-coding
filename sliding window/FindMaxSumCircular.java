import java.util.Scanner;

public class FindMaxSumCircular {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int n = scanner.nextInt();

    int[] array = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }

    System.out.print("Enter the value of k: ");
    int k = scanner.nextInt();

    scanner.close();

    if (k > n) {
      System.out.println("k cannot be greater than the size of the array.");
    } else {
      int[] res = findMaxSum(array, k, n);
      System.out.println("Max Sum is : " + res[0]);
      System.out.print("Subarray with maximum sum: ");
      for (int i = res[1]; i < res[1] + k; i++) {
        System.out.print(array[i % n] + " ");
      }
      System.out.println();
    }
  }

  private static int[] findMaxSum(int[] a, int k, int n) {
    // Create a new array that is the original array duplicated
    int[] extendedArray = new int[2 * n];
    System.arraycopy(a, 0, extendedArray, 0, n);
    System.arraycopy(a, 0, extendedArray, n, n);

    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;
    int startIndex = 0;

    // Compute sum of the first window of size k
    for (int i = 0; i < k; i++) {
      currSum += extendedArray[i];
    }
    maxSum = currSum;

    // Compute sums of remaining windows by sliding the window
    for (int i = 1; i <= n; i++) {
      currSum += extendedArray[i + k - 1] - extendedArray[i - 1];
      if (currSum > maxSum) {
        maxSum = currSum;
        startIndex = i % n;
      }
    }

    return new int[] { maxSum, startIndex };
  }
}
