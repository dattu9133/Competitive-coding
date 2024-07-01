package Graph;

import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearchWithAdjacencyMatrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of vertices");
    int v = sc.nextInt();
    System.out.println("Enter Adjacency matrix:");
    int edges[][] = new int[v][v];
    for (int i = 0; i < edges.length; i++) {
      for (int j = 0; j < edges.length; j++) {
        edges[i][j] = sc.nextInt();
      }
    }
    System.out.println("Enter start:");
    int start = sc.nextInt();
    boolean visited[] = new boolean[v];
    System.out.println("DFS Traversal:");
    dfs(v, edges, start, visited);
    sc.close();
  }

  // Without Recursion
  private static void dfs(int v, int[][] edges, int start, boolean[] visited) {
    Stack<Integer> st = new Stack<>();
    st.push(start);
    while (!st.empty()) {
      int x = st.pop();
      visited[x] = true;
      System.out.print(x + " -> ");
      for (int i = v - 1; i >= 0; i--) {
        if (!visited[i] && edges[x][i] == 1) {
          visited[i] = true;
          st.push(i);
        }
      }
    }
  }

  @SuppressWarnings("unused")
  // Recursion
  private static void dfsWR(int v, int[][] edges, int start, boolean[] visited) {
    System.out.print(start + " -> ");
    visited[start] = true;
    for (int i = 0; i < v; i++) {
      if (!visited[i] && edges[start][i] == 1) {
        dfsWR(v, edges, i, visited);
      }
    }
  }

}
