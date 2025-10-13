import java.util.*;

public class CityLocationTraversal {
    
    // Class to represent the graph using Adjacency List for BFS
    static class GraphAdjList {
        private int vertices;
        private LinkedList<Integer>[] adjList;
        private String[] locationNames;
        
        @SuppressWarnings("unchecked")
        public GraphAdjList(int vertices, String[] names) {
            this.vertices = vertices;
            this.locationNames = names.clone();
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<Integer>(); // Fixed: Added explicit generic type
            }
        }
        
        public void addEdge(int source, int destination) {
            adjList[source].add(destination);
            adjList[destination].add(source); // Undirected graph
        }
        
        public void BFS(int startVertex) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<Integer>(); // Added explicit type
            
            System.out.println("\n=== BFS Traversal (using Adjacency List) ===");
            System.out.println("Starting from: " + locationNames[startVertex]);
            System.out.print("Visit sequence: ");
            
            visited[startVertex] = true;
            queue.offer(startVertex);
            
            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(locationNames[currentVertex] + " -> ");
                
                // Visit all adjacent vertices
                for (int adjacent : adjList[currentVertex]) {
                    if (!visited[adjacent]) {
                        visited[adjacent] = true;
                        queue.offer(adjacent);
                    }
                }
            }
            System.out.println("END");
        }
        
        public void displayAdjList() {
            System.out.println("\nAdjacency List Representation:");
            for (int i = 0; i < vertices; i++) {
                System.out.print(locationNames[i] + " -> ");
                for (int j : adjList[i]) {
                    System.out.print(locationNames[j] + " ");
                }
                System.out.println();
            }
        }
    }
    
    // Class to represent the graph using Adjacency Matrix for DFS
    static class GraphAdjMatrix {
        private int vertices;
        private int[][] adjMatrix;
        private String[] locationNames;
        
        public GraphAdjMatrix(int vertices, String[] names) {
            this.vertices = vertices;
            this.locationNames = names.clone();
            adjMatrix = new int[vertices][vertices];
        }
        
        public void addEdge(int source, int destination) {
            adjMatrix[source][destination] = 1;
            adjMatrix[destination][source] = 1; // Undirected graph
        }
        
        public void DFS(int startVertex) {
            boolean[] visited = new boolean[vertices];
            System.out.println("\n=== DFS Traversal (using Adjacency Matrix) ===");
            System.out.println("Starting from: " + locationNames[startVertex]);
            System.out.print("Visit sequence: ");
            DFSUtil(startVertex, visited);
            System.out.println("END");
        }
        
        private void DFSUtil(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(locationNames[vertex] + " -> ");
            
            // Visit all adjacent vertices
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    DFSUtil(i, visited);
                }
            }
        }
        
        public void displayAdjMatrix() {
            System.out.println("\nAdjacency Matrix Representation:");
            System.out.print("     ");
            for (int i = 0; i < vertices; i++) {
                System.out.printf("%12s", locationNames[i]); // Increased width for better formatting
            }
            System.out.println();
            
            for (int i = 0; i < vertices; i++) {
                System.out.printf("%12s", locationNames[i]); // Increased width
                for (int j = 0; j < vertices; j++) {
                    System.out.printf("%12d", adjMatrix[i][j]);
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        // Popular locations in a city area (example: Commercial Street, Bangalore)
        String[] locations = {
            "Brigade Road",    // 0
            "Commercial St",   // 1  
            "MG Road",         // 2
            "Church Street",   // 3
            "UB City Mall",    // 4
            "Cubbon Park",     // 5
            "Forum Mall",      // 6
            "Garuda Mall"      // 7
        };
        
        int numLocations = locations.length;
        
        System.out.println("=== CITY LOCATION GRAPH TRAVERSAL ===");
        System.out.println("Popular Locations in the Area:");
        for (int i = 0; i < numLocations; i++) {
            System.out.println(i + ". " + locations[i]);
        }
        
        // Create graph with Adjacency List for BFS
        GraphAdjList graphList = new GraphAdjList(numLocations, locations);
        
        // Create graph with Adjacency Matrix for DFS  
        GraphAdjMatrix graphMatrix = new GraphAdjMatrix(numLocations, locations);
        
        // Add connections between locations (routes)
        System.out.println("\nAdding connections between locations...");
        
        // Brigade Road connections
        graphList.addEdge(0, 1);  // Brigade Road - Commercial St
        graphList.addEdge(0, 2);  // Brigade Road - MG Road
        graphList.addEdge(0, 3);  // Brigade Road - Church Street
        
        graphMatrix.addEdge(0, 1);
        graphMatrix.addEdge(0, 2);
        graphMatrix.addEdge(0, 3);
        
        // Commercial Street connections
        graphList.addEdge(1, 2);  // Commercial St - MG Road
        graphList.addEdge(1, 4);  // Commercial St - UB City Mall
        
        graphMatrix.addEdge(1, 2);
        graphMatrix.addEdge(1, 4);
        
        // MG Road connections
        graphList.addEdge(2, 3);  // MG Road - Church Street
        graphList.addEdge(2, 5);  // MG Road - Cubbon Park
        graphList.addEdge(2, 4);  // MG Road - UB City Mall
        
        graphMatrix.addEdge(2, 3);
        graphMatrix.addEdge(2, 5);
        graphMatrix.addEdge(2, 4);
        
        // Church Street connections
        graphList.addEdge(3, 6);  // Church Street - Forum Mall
        
        graphMatrix.addEdge(3, 6);
        
        // UB City Mall connections
        graphList.addEdge(4, 5);  // UB City Mall - Cubbon Park
        graphList.addEdge(4, 7);  // UB City Mall - Garuda Mall
        
        graphMatrix.addEdge(4, 5);
        graphMatrix.addEdge(4, 7);
        
        // Cubbon Park connections
        graphList.addEdge(5, 6);  // Cubbon Park - Forum Mall
        
        graphMatrix.addEdge(5, 6);
        
        // Forum Mall connections
        graphList.addEdge(6, 7);  // Forum Mall - Garuda Mall
        
        graphMatrix.addEdge(6, 7);
        
        // Display graph representations
        graphList.displayAdjList();
        graphMatrix.displayAdjMatrix();
        
        // Perform BFS starting from Brigade Road (index 0)
        graphList.BFS(0);
        
        // Perform DFS starting from Brigade Road (index 0)
        graphMatrix.DFS(0);
        
        System.out.println("\n=== ANALYSIS ===");
        System.out.println("BFS explores locations level by level (breadth-first)");
        System.out.println("DFS explores as deep as possible before backtracking (depth-first)");
        System.out.println("Both traversals visit all connected locations from the starting point");
        
        // Additional traversal from different starting points
        System.out.println("\n=== TRAVERSAL FROM DIFFERENT STARTING POINTS ===");
        System.out.println("\nBFS from Commercial Street:");
        graphList.BFS(1);
        
        System.out.println("\nDFS from MG Road:");
        graphMatrix.DFS(2);
        
        // Demonstrate connectivity
        System.out.println("\n=== CONNECTIVITY CHECK ===");
        System.out.println("All locations are connected in this graph");
        System.out.println("You can reach any location from any other location");
    }
}
