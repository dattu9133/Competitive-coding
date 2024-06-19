import java.util.Scanner;

public class SubArrayWithGivenSumBF {
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
    int res[] = findSubArray(array, x, n);
    if (res[0] != -1)
      System.out.println("Subarray with given sum found from index " + res[0] + " to " + res[1]);
    else
      System.out.println("No subarray with the given sum found.");
  }

  private static int[] findSubArray(int[] a, int x, int n) {
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += a[j];
        if (sum == x) {
          return new int[] { i, j };
        }
      }
    }
    return new int[] { -1, -1 };
  }
}
