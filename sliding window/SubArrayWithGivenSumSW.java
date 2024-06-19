import java.util.HashMap;
import java.util.Scanner;

public class SubArrayWithGivenSumSW {
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
      System.out.println("SubArray starts from " + res[0] + " to " + res[1]);
    else
      System.out.println("No subarray with the given sum found.");
  }

  // private static int[] findSubArray(int[] a, int x, int n) {
  // int l = 0, r = 0;
  // int currSum = 0;
  // while (r < n) {
  // currSum += a[r];
  // while (currSum > x && l < r) {
  // currSum -= a[l];
  // l++;
  // }
  // if (currSum == x) {
  // return new int[] { l, r };
  // }
  // r++;
  // }
  // return new int[] { -1, -1 };
  // }

  private static int[] findSubArray(int[] a, int x, int n) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int currSum = 0;

    for (int i = 0; i < n; i++) {
      currSum += a[i];

      // Check if current sum is equal to the target sum
      if (currSum == x) {
        return new int[] { 0, i };
      }

      // Check if there is a prefix sum that we can subtract to get the target sum
      if (hm.containsKey(currSum - x)) {
        return new int[] { hm.get(currSum - x) + 1, i };
      }

      // Store the current sum with its index
      hm.put(currSum, i);
    }

    // If no subarray is found, return -1, -1
    return new int[] { -1, -1 };
  }
}
