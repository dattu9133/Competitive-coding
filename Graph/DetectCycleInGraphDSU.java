import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInGraphDSU {
  static int[] parent;
  static int[] rank;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of vertices:");
    int V = sc.nextInt();
    System.out.println("Enter the number of edges:");
    int E = sc.nextInt();

    ArrayList<int[]> edges = new ArrayList<>();
    System.out.println("Enter the edges (u v):");
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      edges.add(new int[] { u, v });
    }

    boolean hasCycle = isCycle(V, edges);

    if (hasCycle) {
      System.out.println("Graph contains cycle");
    } else {
      System.out.println("Graph does not contain cycle");
    }

    sc.close();
  }

  public static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  public static void union(int x, int y) {
    int xRoot = find(x);
    int yRoot = find(y);

    if (xRoot != yRoot) {
      if (rank[xRoot] < rank[yRoot]) {
        parent[xRoot] = yRoot;
      } else if (rank[xRoot] > rank[yRoot]) {
        parent[yRoot] = xRoot;
      } else {
        parent[yRoot] = xRoot;
        rank[xRoot]++;
      }
    }
  }

  public static void initialize(int n) {
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 0;
    }
  }

  public static boolean isCycle(int V, ArrayList<int[]> edges) {
    initialize(V);

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      int uRoot = find(u);
      int vRoot = find(v);

      if (uRoot == vRoot) {
        return true;
      }

      union(uRoot, vRoot);
    }

    return false;
  }
}
