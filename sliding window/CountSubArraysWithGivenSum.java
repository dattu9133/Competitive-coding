import java.util.HashMap;
import java.util.Scanner;

public class CountSubArraysWithGivenSum {
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
    int count = countSubArrays(array, x, n);
    System.out.println("Number of subarrays with the given sum: " + count);
  }

  private static int countSubArrays(int[] a, int x, int n) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int currSum = 0;
    int count = 0;

    // Initialize the hash map with zero sum having one occurrence
    hm.put(0, 1);

    for (int i = 0; i < n; i++) {
      currSum += a[i];

      // If currSum - x exists in the map, it means we found some subarrays with sum x
      if (hm.containsKey(currSum - x)) {
        count += hm.get(currSum - x);
      }

      // Update the hash map with the current sum
      hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
    }

    return count;
  }
}
