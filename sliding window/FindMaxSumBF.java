import java.util.Scanner;

public class FindMaxSumBF {
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
    int res = findMaxSum(array, k, n);
    System.out.println("Max Sum is : " + res);

  }

  private static int findMaxSum(int[] a, int k, int n) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < n - k; i++) {
      int currSum = 0;
      for (int j = i; j <= i + k; j++) {
        currSum += a[j];
      }
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
}