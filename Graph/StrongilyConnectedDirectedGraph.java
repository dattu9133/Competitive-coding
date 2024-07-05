import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StrongilyConnectedDirectedGraph {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of nodes:");
    int n = sc.nextInt();
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      hm.put(i, new ArrayList<>());
    }

    System.out.println("Enter no.of edges:");
    int n1 = sc.nextInt();
    System.out.println("Enter edge(u,v):");
    for (int i = 0; i < n1; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      hm.get(u).add(v);
    }
    if (isStrongilyConnected(hm, n))
      System.out.println("Graph is strongly connected");
    else
      System.out.println("Graph is not strongly connected");
    sc.close();
  }

  private static boolean isStrongilyConnected(HashMap<Integer, ArrayList<Integer>> hm, int n) {
    for (int i = 0; i < n; i++) {
      boolean visited[] = new boolean[n];
      bfs(hm, n, i, visited);
      for (boolean f : visited) {
        if (!f)
          return false;
      }
    }
    return true;
  }

  private static void bfs(HashMap<Integer, ArrayList<Integer>> hm, int n, int start, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    visited[start] = true;
    while (!q.isEmpty()) {
      int x = q.poll();
      for (int neighbor : hm.get(x)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          q.add(neighbor);
        }
      }
    }
  }

  private static void dfs(HashMap<Integer, ArrayList<Integer>> hm, int n, int i, boolean[] visited) {
    visited[i] = true;
    for (int neighbor : hm.get(i)) {
      if (!visited[neighbor]) {
        dfs(hm, n, neighbor, visited);
      }
    }
  }
}