import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DistantCountInWindowSW {

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
    ArrayList<Integer> res = findDistinctCount(array, k, n);
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i) + " ");
    }
  }

  private static ArrayList<Integer> findDistinctCount(int[] a, int k, int n) {
    ArrayList<Integer> res = new ArrayList<>();
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < k; i++) {
      hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
    }
    res.add(hm.size());
    for (int i = k; i < n; i++) {
      if (hm.get(a[i - k]) != null) {
        if (hm.get(a[i - k]) == 1)
          hm.remove(a[i - k]);
        else
          hm.put(a[i - k], hm.get(a[i - k]) - 1);
      }
      hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
      res.add(hm.size());
    }
    return res;
  }
}
