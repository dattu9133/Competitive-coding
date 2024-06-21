import java.util.Scanner;

public class CountingBits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int num = sc.nextInt();
    int[] res = countBits(num);
    System.out.println("Count of bits for each number from 0 to " + num + ":");
    for (int i = 0; i <= num; i++) {
      System.out.println("Number " + i + " has " + res[i] + " bits.");
    }
    sc.close();
  }

  private static int[] countBits(int num) {
    int[] dp = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      if (i % 2 == 0) {
        dp[i] = dp[i / 2];
      } else {
        dp[i] = dp[i - 1] + 1;
      }
    }
    return dp;
  }
}
