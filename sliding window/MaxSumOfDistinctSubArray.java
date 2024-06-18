import java.util.HashMap;
import java.util.Scanner;

public class MaxSumOfDistinctSubArray {
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
    int res = findMaxSumOfDistinctSubArray(array, k, n);
    System.out.println("Max Sum is : " + res);
  }

  private static int findMaxSumOfDistinctSubArray(int[] a, int k, int n) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int maxSum = 0;
    int currSum = 0;
    for (int i = 0; i < k; i++) {
      currSum += a[i];
      hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
    }
    // System.out.println(currSum);
    if ((hm.size() == k) && (maxSum < currSum)) {
      maxSum = currSum;
    }

    for (int i = k; i < n; i++) {
      if (hm.get(a[i - k]) != null) {
        if (hm.get(a[i - k]) == 1) {
          hm.remove(a[i - k]);
        } else {
          hm.put(a[i - k], hm.get(a[i - k]) - 1);
        }
        currSum -= a[i - k];
      }
      hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
      currSum += a[i];
      // System.out.println(currSum);
      if ((hm.size() == k) && (maxSum < currSum)) {
        maxSum = currSum;
      }
    }
    return maxSum;
  }
}
