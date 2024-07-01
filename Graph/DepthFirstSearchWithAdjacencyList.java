package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearchWithAdjacencyList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of vertices");
    int n = sc.nextInt();

    System.out.println("Enter Adjacency List:");
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      hm.put(i, new ArrayList<>());
    }

    while (true) {
      System.out.println("Enter the vertices which has edge(-1 to break)");
      int u = sc.nextInt();
      if (u == -1)
        break;
      int v = sc.nextInt();
      if (v == -1) {
        break;
      }
      hm.get(u).add(v);
      hm.get(v).add(u);
    }

    System.out.println("Enter start:");
    int start = sc.nextInt();

    boolean visited[] = new boolean[n];
    System.out.println("DFS Traversal:");
    dfs(hm, start, visited);

    sc.close();
  }

  @SuppressWarnings("unused")
  // Iterative DFS without Recursion
  private static void dfs(int v, HashMap<Integer, ArrayList<Integer>> hm, int start, boolean[] visited) {
    Stack<Integer> st = new Stack<>();
    st.push(start);
    while (!st.empty()) {
      int x = st.pop();
      visited[x] = true;
      System.out.print(x + " -> ");
      for (int neighbor : hm.get(x)) {
        if (!visited[neighbor]) {
          st.push(neighbor);
          visited[neighbor] = true;
        }
      }
    }
  }

  // Recursive DFS
  private static void dfs(HashMap<Integer, ArrayList<Integer>> hm, int start, boolean[] visited) {
    visited[start] = true;
    System.out.print(start + " -> ");
    for (int neighbor : hm.get(start)) {
      if (!visited[neighbor]) {
        dfs(hm, neighbor, visited);
      }
    }
  }
}
