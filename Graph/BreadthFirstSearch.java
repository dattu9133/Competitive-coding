import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
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
    System.out.println("BFS Traversal:");
    bfs(v, edges, start, visited);
    sc.close();
  }

  private static void bfs(int v, int[][] edges, int start, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    visited[start] = true;

    while (!q.isEmpty()) {
      int x = q.poll();
      System.out.print(x + " -> ");
      for (int i = 0; i < v; i++) {
        if (!visited[i] && edges[x][i] == 1) {
          visited[i] = true;
          q.add(i);
        }
      }
    }
  }

}
