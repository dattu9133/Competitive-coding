import java.util.Scanner;

public class CountOfDistainctAbsValuesInSortedArray {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int n = scanner.nextInt();

    int[] array = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }
    scanner.close();
    int res = findCount(array, n);
    System.out.println("Distanct absolute count in sorted array: " + res);
  }

  private static int findCount(int[] a, int n) {
    int l = 0, r = n - 1, count = n;
    while (l < r) {
      while ((l < r) && (a[l] == a[l + 1])) {
        count--;
        l++;
      }
      while (r > l && a[r - 1] == a[r]) {
        count--;
        r--;
      }
      if (l == r)
        break;
      int s = a[l] + a[r];
      if (s == 0) {
        count--;
        l++;
        r--;
      } else if (s < 0) {
        l++;
      } else
        r--;
    }

    return count;
  }

  // Using HashSet
  // private static int findCount(int[] a, int n) {
  // HashSet<Integer> hs = new HashSet<>();
  // for (int i = 0; i < n; i++) {
  // hs.add(Math.abs(a[i]));
  // }

  // return hs.size();
  // }

}
