import java.util.Scanner;

public class MinNoOfInsertionToMakePalindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String:");
    String str = sc.next();
    int res = findMinInsertions(str.toCharArray(), 0, str.length() - 1);
    sc.close();
    System.out.println("Minimum no. of insertions required to make given string Palindrome: " + res);
  }

  private static int findMinInsertions(char[] str, int l, int h) {
    // Base Cases
    if (l > h)
      return -1; // Invalid case
    if (l == h)
      return 0; // Single character is already a palindrome
    if (l == h - 1)
      return (str[l] == str[h]) ? 0 : 1; // Two characters, either they are same or different

    // Recursive Cases
    if (str[l] == str[h]) {
      return findMinInsertions(str, l + 1, h - 1);
    } else {
      // Insert a character at position h + 1 to match str[l] (findMinInsertions(str,
      // l + 1, h)).

      // Insert a character at position l - 1 to match str[h] (findMinInsertions(str,
      // l, h - 1)).
      return Math.min(findMinInsertions(str, l + 1, h), findMinInsertions(str, l, h - 1)) + 1;
    }
  }
}
