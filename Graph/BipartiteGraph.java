import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraph {
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
    if (isBipartite(n, edges))
      System.out.println("Graph is a Bipartite graph");
    else
      System.out.println("Graph is not a Bipartite graph");
    sc.close();
  }

  private static boolean isBipartite(int n, int[][] edges) {
    int[] colors = new int[n];
    for (int i = 0; i < n; i++) {
      colors[i] = -1;
    }

    for (int start = 0; start < n; start++) {
      if (colors[start] == -1) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = 0;

        while (!q.isEmpty()) {
          int u = q.poll();

          if (edges[u][u] == 1)
            return false;

          for (int v = 0; v < n; v++) {
            if (edges[u][v] == 1) {
              if (colors[v] == -1) {
                colors[v] = 1 - colors[u];
                q.add(v);
              } else if (colors[v] == colors[u]) {
                return false;
              }
            }
          }
        }
      }
    }
    return true;
  }
}
