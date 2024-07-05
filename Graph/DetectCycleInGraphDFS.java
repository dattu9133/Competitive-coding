import java.util.ArrayList;
import java.util.Scanner;

class DetectCycleInGraphDFS {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of vertices:");
    int V = sc.nextInt();
    System.out.println("Enter the number of edges:");
    int E = sc.nextInt();

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    System.out.println("Enter the edges (u v):");
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    boolean hasCycle = isCycle(V, adj);

    if (hasCycle) {
      System.out.println("Graph contains cycle");
    } else {
      System.out.println("Graph does not contain cycle");
    }

    sc.close();
  }

  public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (isCyclicDFS(i, visited, -1, adj)) {
          return true;
        }
      }
    }
    return false;
  }

  // 4 2
  // 1 2
  // 2 3
  private static boolean isCyclicDFS(int start, boolean[] visited, int parent, ArrayList<ArrayList<Integer>> adj) {
    visited[start] = true;

    for (int neighbor : adj.get(start)) {
      if (!visited[neighbor]) {
        if (isCyclicDFS(neighbor, visited, start, adj)) {
          return true;
        }
      } else if (neighbor != parent) {
        return true;
      }
    }
    return false;
  }
}
