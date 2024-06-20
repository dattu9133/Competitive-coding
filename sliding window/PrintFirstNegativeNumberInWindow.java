import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PrintFirstNegativeNumberInWindow {
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
    ArrayList<Integer> res = findFirstNegative(array, k, n);
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i) + " ");
    }
  }

  // Sliding Window
  private static ArrayList<Integer> findFirstNegative(int[] a, int k, int n) {
    ArrayList<Integer> res = new ArrayList<>();
    Deque<Integer> dq = new LinkedList<>();

    // Process the first window of size k
    for (int i = 0; i < k; i++) {
      if (a[i] < 0) {
        dq.addLast(i);
      }
    }

    // For the first window, add the first negative number to the result
    if (!dq.isEmpty()) {
      res.add(a[dq.peekFirst()]);
      // System.out.println(dq);
    } else {
      res.add(0);
    }

    // Process the rest of the windows
    for (int i = k; i < n; i++) {
      // Remove elements that are out of the current window
      if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
        dq.pollFirst();
      }

      // Add the current element if it is negative
      if (a[i] < 0) {
        dq.addLast(i);
      }

      // Add the first negative number for the current window to the result
      if (!dq.isEmpty()) {
        // System.out.println(dq);
        res.add(a[dq.peekFirst()]);
      } else {
        res.add(0);
      }
    }

    return res;
  }

  // Using Naive Approach
  // private static ArrayList<Integer> findFirstNegative(int[] a, int k, int n) {
  // ArrayList<Integer> res = new ArrayList<>();
  // for (int i = 0; i < n - k + 1; i++) {
  // int c = 0;
  // for (int j = i; j < i + k; j++) {
  // if (a[j] < 0) {
  // res.add(a[j]);
  // break;
  // }
  // c++;
  // if (c == k)
  // res.add(0);
  // }
  // }
  // return res;
  // }

}
