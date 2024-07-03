import java.util.Scanner;

public class DisjointSetUnion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of presons:");
    int n = sc.nextInt();
    int parent[] = new int[n];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
    System.out.println("Enter no. of relations:");
    int n1 = sc.nextInt();
    for (int i = 0; i < n1; i++) {
      System.out.println("Enter relation between 2 persons:");
      int a = sc.nextInt();
      int b = sc.nextInt();
      union(parent, a, b);
    }
    System.out.println("Enter no. of queries:");
    int k = sc.nextInt();
    for (int i = 0; i < k; i++) {
      System.out.println("Enter differnt persons you want to find friends or not:");
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (find(a, parent) == find(b, parent)) {
        System.out.println(a + " and " + b + " are friends");
      } else {
        System.out.println(a + " and " + b + " are not friends");
      }
    }
    sc.close();
  }

  private static int find(int a, int[] parent) {
    if (a == parent[a])
      return a;
    parent[a] = find(parent[a], parent);
    return parent[a];
  }

  private static void union(int[] parent, int a, int b) {
    int ra = find(a, parent);
    int rb = find(b, parent);
    parent[rb] = ra;
  }
}
