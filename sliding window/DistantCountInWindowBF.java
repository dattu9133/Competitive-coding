import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DistantCountInWindowBF {
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
    for (int i = 0; i < n - k + 1; i++) {
      HashSet<Integer> hs = new HashSet<>();
      for (int j = i; j < i + k; j++) {
        hs.add(a[j]);
      }
      res.add(hs.size());
      hs = null;
    }
    return res;
  }
}
