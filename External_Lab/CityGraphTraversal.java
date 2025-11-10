import java.util.*;

// ===============================
// DFS using Adjacency Matrix
// ===============================
class GraphDFS {
    private int[][] adjMatrix;
    private int numVertices;

    public GraphDFS(int vertices) {
        numVertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Add edge (undirected)
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    // DFS Recursive
    public void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print((char) (start + 'A') + " ");

        for (int j = 0; j < numVertices; j++) {
            if (adjMatrix[start][j] == 1 && !visited[j]) {
                dfs(j, visited);
            }
        }
    }

    // DFS Driver
    public void performDFS(char startChar) {
        int start = startChar - 'A';
        boolean[] visited = new boolean[numVertices];
        System.out.println("\nDFS Traversal (Adjacency Matrix):");
        dfs(start, visited);
        System.out.println();
    }
}

// ===============================
// BFS using Adjacency List
// ===============================
class GraphBFS {
    private Map<Character, List<Character>> adjList;

    public GraphBFS() {
        adjList = new HashMap<>();
    }

    // Add edge (undirected)
    public void addEdge(char src, char dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    // BFS Traversal
    public void performBFS(char start) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        visited.add(start);
        queue.add(start);

        System.out.println("\nBFS Traversal (Adjacency List):");
        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.print(current + " ");
            for (char neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}

// ===============================
// Main Class
// ===============================
public class CityGraphTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of locations (nodes)
        System.out.print("Enter number of locations: ");
        int n = sc.nextInt();

        // Create Graphs for DFS & BFS
        GraphDFS dfsGraph = new GraphDFS(n);
        GraphBFS bfsGraph = new GraphBFS();

        // Input connections
        System.out.println("Enter connections between locations (e.g., A B). Type '0 0' to stop:");
        while (true) {
            char u = sc.next().charAt(0);
            char v = sc.next().charAt(0);
            if (u == '0' && v == '0') break;

            dfsGraph.addEdge(u - 'A', v - 'A');
            bfsGraph.addEdge(u, v);
        }

        // Starting location
        System.out.print("Enter starting location (A/B/C...): ");
        char start = sc.next().charAt(0);

        // Perform DFS and BFS
        dfsGraph.performDFS(start);
        bfsGraph.performBFS(start);

        sc.close();
    }
}
