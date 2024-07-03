import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearchWithAdjacencyList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of vertices:");
    int n = sc.nextInt();

    System.out.println("Enter Adjacency List (for ArrayList implementation):");
    ArrayList<ArrayList<Integer>> arrayListGraph = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> hashMapGraph = new HashMap<>();

    for (int i = 0; i < n; i++) {
      arrayListGraph.add(new ArrayList<>());
      hashMapGraph.put(i, new ArrayList<>());
    }
    while (true) {
      System.out.println("Enter the vertices which has edge (-1 to break):");
      int u = sc.nextInt();
      if (u == -1)
        break;
      int v = sc.nextInt();
      if (v == -1)
        break;
      arrayListGraph.get(u).add(v);
      arrayListGraph.get(v).add(u);
      hashMapGraph.get(u).add(v);
      hashMapGraph.get(v).add(u);
    }

    System.out.println("Enter start vertex:");
    int start = sc.nextInt();

    boolean visitedArrayList[] = new boolean[n];
    System.out.println("DFS Traversal (Recursive using ArrayList):");
    dfs(arrayListGraph, start, visitedArrayList);
    System.out.println();

    visitedArrayList = new boolean[n];
    System.out.println("DFS Traversal (Iterative using ArrayList):");
    dfs(n, arrayListGraph, start, visitedArrayList);
    System.out.println();

    boolean visitedHashMap[] = new boolean[n];
    System.out.println("DFS Traversal (Iterative using HashMap):");
    dfs(n, hashMapGraph, start, visitedHashMap);
    System.out.println();

    visitedHashMap = new boolean[n];
    System.out.println("DFS Traversal (Recursive using HashMap):");
    dfs(hashMapGraph, start, visitedHashMap);
    System.out.println();

    sc.close();
  }

  // Recursive DFS using ArrayList adjacency list
  private static void dfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
    System.out.print(start + " -> ");
    visited[start] = true;
    ArrayList<Integer> neighbors = graph.get(start);
    for (int neighbor : neighbors) {
      if (!visited[neighbor]) {
        dfs(graph, neighbor, visited);
      }
    }
  }

  // Iterative DFS without Recursion using ArrayList adjacency list
  private static void dfs(int v, ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
    Stack<Integer> stack = new Stack<>();

    stack.push(start);

    while (!stack.isEmpty()) {
      int vertex = stack.pop();

      if (!visited[vertex]) {
        visited[vertex] = true;
        System.out.print(vertex + " -> ");
      }

      ArrayList<Integer> adjList = graph.get(vertex);
      Collections.reverse(adjList);
      for (int adj : adjList) {
        if (!visited[adj]) {
          stack.push(adj);
        }
      }
    }
  }

  // Iterative DFS without Recursion using HashMap adjacency list
  private static void dfs(int v, HashMap<Integer, ArrayList<Integer>> graph, int start, boolean[] visited) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, ArrayList<Integer>> adjHashMap = graph;
    stack.push(start);
    while (!stack.empty()) {
      int node = stack.pop();
      if (!visited[node]) {
        visited[node] = true;
        System.out.print(node + " -> ");
      }
      ArrayList<Integer> adjList = adjHashMap.get(node);
      Collections.reverse(adjList);
      for (int neighbor : adjList) {
        if (!visited[neighbor]) {
          stack.push(neighbor);
        }
      }
    }
  }

  // Recursive DFS using HashMap adjacency list
  private static void dfs(HashMap<Integer, ArrayList<Integer>> graph, int start, boolean[] visited) {
    visited[start] = true;
    System.out.print(start + " -> ");
    for (int neighbor : graph.get(start)) {
      if (!visited[neighbor]) {
        dfs(graph, neighbor, visited);
      }
    }
  }
}
