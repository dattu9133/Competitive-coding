import java.util.Scanner;

public class LongestAlternatingSubarray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size:");
    int n = sc.nextInt();
    System.out.println("Enter the elements:");
    int a[] = new int[n];
    for (int i = 0; i < a.length; i++) {
      a[i] = sc.nextInt();
    }
    printLongestAlternatingSubarray(a);
    sc.close();
  }

  private static void printLongestAlternatingSubarray(int[] a) {
    int maxLength = 1;
    int currLength = 1;
    int endIndex = 0;
    for (int i = 1; i < a.length; i++) {
      if (a[i - 1] * a[i] < 0) {
        currLength++;
        if (currLength > maxLength) {
          endIndex = i;
          maxLength = currLength;
        }
      } else
        currLength = 1;
    }

    System.out.println("Longest alternating subsequence:");
    for (int i = endIndex - maxLength + 1; i <= endIndex; i++) {
      System.out.print(a[i] + " ");
    }
  }
}
