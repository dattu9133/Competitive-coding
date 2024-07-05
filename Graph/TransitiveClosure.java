import java.util.*;

public class TransitiveClosure {
  public static void transitiveClosure(int E[][]) {
    int n = E.length;
    int reachable[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        reachable[i][j] = E[i][j];
      }
    }
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (reachable[i][j] != 0 || (reachable[i][k] != 0 && reachable[k][j] != 0))
            reachable[i][j] = 1;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j)
          System.out.print("1" + " ");
        else
          System.out.print(reachable[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of vertices: ");
    int n = scanner.nextInt();
    int E[][] = new int[n][n];
    System.out.println("Enter the adjacency matrix (0 or 1):");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        E[i][j] = scanner.nextInt();
      }
    }
    System.out.println("The transitive closure of the given graph is:");
    transitiveClosure(E);
    scanner.close();
  }
}