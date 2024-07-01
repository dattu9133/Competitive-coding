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
    ArrayList<ArrayList<Integer>> hm = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      hm.add(new ArrayList<>());
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

  // Recursive DFS using ArrayList adjacency list
  private static void dfs(ArrayList<ArrayList<Integer>> hm, int start, boolean[] visited) {
    System.out.print(start + " -> ");
    visited[start] = true;
    ArrayList<Integer> al = hm.get(start);
    for (int i : al) {
      if (!visited[i]) {
        dfs(hm, i, visited);
      }
    }
  }

  @SuppressWarnings("unused")
  // Iterative DFS without Recursion using Arraylist adjacency list
  private static void dfs(int v, ArrayList<ArrayList<Integer>> hm, int start, boolean[] visited) {
    Stack<Integer> st = new Stack<>();
    st.add(start);
    while (!st.empty()) {
      int x = st.pop();
      System.out.print(x + " -> ");
      visited[x] = true;
      for (int i : hm.get(x)) {
        if (!visited[i]) {
          st.add(i);
          visited[i] = true;
        }
      }
    }
  }

  @SuppressWarnings("unused")
  // Iterative DFS without Recursion using HashMap adjacency list
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

  @SuppressWarnings("unused")
  // Recursive DFS using HashMap adjacency list
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
