import java.util.Scanner;

public class MaximumProductSubarray {

  public static int maxProduct(int[] nums) {
    if (nums.length == 0)
      return 0;

    int maxProduct = nums[0];
    int minProduct = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) {
        // Swap maxProduct and minProduct
        int temp = maxProduct;
        maxProduct = minProduct;
        minProduct = temp;
      }

      maxProduct = Math.max(nums[i], maxProduct * nums[i]);
      minProduct = Math.min(nums[i], minProduct * nums[i]);

      result = Math.max(result, maxProduct);
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number of elements in the array:");
    int n = scanner.nextInt();

    int[] nums = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      nums[i] = scanner.nextInt();
    }

    int result = maxProduct(nums);
    System.out.println("The maximum product subarray is: " + result);
    scanner.close();
  }
}
