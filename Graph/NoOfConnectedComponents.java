import java.util.Scanner;

public class NoOfConnectedComponents {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of vertices:");
    int n = sc.nextInt();
    int edges[][] = new int[n][n];
    while (true) {
      System.out.println("Enter Edge(u,v) or (-1,-1) to stop:");
      int u = sc.nextInt();
      int v = sc.nextInt();
      if (u == -1 || v == -1)
        break;
      edges[u][v] = 1;
      edges[v][u] = 1;
    }
    int res = 0;
    boolean visited[] = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(edges, visited, i, n);
        res++;
      }
    }
    System.out.println("No .of connected components : " + res);
    sc.close();

  }

  private static void dfs(int[][] edges, boolean[] visited, int start, int n) {
    visited[start] = true;
    for (int i = 0; i < n; i++) {
      if (!visited[i] && edges[start][i] == 1) {
        dfs(edges, visited, i, n);
      }
    }
  }

}
