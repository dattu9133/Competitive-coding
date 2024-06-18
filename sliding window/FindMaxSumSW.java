import java.util.Scanner;

public class FindMaxSumSW {
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
    int res[] = findMaxSum(array, k, n);
    System.out.println("Max Sum is : " + res[0]);
    System.out.println("Window starts from index :" + res[1]);
  }

  private static int[] findMaxSum(int[] a, int k, int n) {
    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;
    int start = 0;

    for (int i = 0; i < k; i++) {
      currSum += a[i];
    }
    maxSum = currSum;

    for (int i = k; i < n; i++) {
      currSum += a[i] - a[i - k];
      if (maxSum < currSum) {
        maxSum = currSum;
        start = i - k + 1;
      }
    }

    // for (int i = 1; i < n - k + 1; i++) {
    // currSum += a[i + k - 1] - a[i - 1];
    // maxSum = Math.max(maxSum, currSum);
    // }

    return new int[] { maxSum, start };
  }

}
