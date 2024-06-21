import java.util.Scanner;

public class TotalSetBitsDP {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number:");
    int num = sc.nextInt();
    int totalSetBits = totalSetBitsDP(num);
    System.out.println("Total number of set bits from 0 to " + num + ": " + totalSetBits);
    sc.close();
  }

  private static int totalSetBitsDP(int num) {
    int[] dp = new int[num + 1];
    int sum = 0;

    for (int i = 1; i <= num; i++) {
      if (i % 2 == 0) {
        dp[i] = dp[i / 2];
      } else {
        dp[i] = dp[i - 1] + 1;
      }
      sum += dp[i];
    }

    return sum;
  }
}
