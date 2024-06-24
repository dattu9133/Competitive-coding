import java.util.Scanner;

public class NthCatalanNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long res = findCatalan(n);
    System.out.println("The " + n + "th Catalan number is: " + res);
    sc.close();
  }

  private static long findCatalan(int n) {
    long[] catalan = new long[n + 1];
    catalan[0] = 1;
    catalan[1] = 1;

    for (int i = 2; i <= n; i++) {
      catalan[i] = 0;
      for (int j = 0; j < i; j++) {
        catalan[i] += catalan[j] * catalan[i - 1 - j];
      }
    }

    return catalan[n];
  }
}
