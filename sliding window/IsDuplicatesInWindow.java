import java.util.HashMap;
import java.util.Scanner;

public class IsDuplicatesInWindow {
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
    if (findDuplicate(array, k, n)) {
      System.out.println("There are Dupliocates in window size of " + k);
    } else
      System.out.println("No Duplicates in window size of " + k);
  }

  // Sliding Window Approach
  private static boolean findDuplicate(int[] a, int k, int n) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < k; i++) {
      hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
    }
    if (hm.size() < k)
      return true;
    for (int i = k; i < n; i++) {
      if (hm.get(a[i - k]) != null) {
        if (hm.get(a[i - k]) == 1)
          hm.remove(a[i - k]);
        else
          hm.put(a[i - k], hm.get(a[i - k]) - 1);
      }
      hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
      if (hm.size() < k)
        return true;
    }
    return false;
  }

  // Naive Approach
  // private static boolean findDuplicate(int[] a, int k, int n) {
  // for (int i = 0; i < n - k + 1; i++) {
  // HashSet<Integer> hs = new HashSet<>();
  // for (int j = i; j < i + k; j++) {
  // hs.add(a[j]);
  // }
  // if (hs.size() != k)
  // return true;
  // hs = null;
  // }
  // return false;
  // }

  // Using Pure Hashing
  // private static boolean findDuplicate(int[] a, int k, int n) {
  // HashMap<Integer, Integer> hm = new HashMap<>();
  // for (int i = 0; i < n; i++) {
  // if (hm.containsKey(a[i]) && (i - hm.get(a[i]) <= k))
  // return true;

  // hm.put(a[i], i);
  // }

  // return false;
  // }

}
