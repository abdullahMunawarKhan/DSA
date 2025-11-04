import java.util.*;

import DSA_EDC.Arrays;

public class PizzaDeliveryOptimizer {
    
    // Class to represent a delivery location
    static class Location {
        int id;
        String name;
        
        public Location(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    
    // Class to represent the delivery graph
    static class DeliveryGraph {
        private int numLocations;
        private int[][] timeMatrix;
        private Location[] locations;
        private static final int INF = Integer.MAX_VALUE;
        
        public DeliveryGraph(int numLocations) {
            this.numLocations = numLocations;
            this.timeMatrix = new int[numLocations][numLocations];
            this.locations = new Location[numLocations];
            
            // Initialize matrix
            for (int i = 0; i < numLocations; i++) {
                for (int j = 0; j < numLocations; j++) {
                    if (i == j) {
                        timeMatrix[i][j] = 0;
                    } else {
                        timeMatrix[i][j] = INF;
                    }
                }
            }
        }
        
        public void addLocation(int id, String name) {
            locations[id] = new Location(id, name);
        }
        
        public void addRoute(int from, int to, int time) {
            timeMatrix[from][to] = time;
            timeMatrix[to][from] = time; // Bidirectional routes
        }
        
        // TSP using Nearest Neighbor Heuristic
        public TSPResult solveTSPNearestNeighbor(int startLocation) {
            boolean[] visited = new boolean[numLocations];
            List<Integer> tour = new ArrayList<>();
            int totalTime = 0;
            int currentLocation = startLocation;
            
            System.out.println("=== PIZZA DELIVERY ROUTE OPTIMIZATION ===");
            System.out.println("Starting from: " + locations[startLocation].name);
            
            visited[currentLocation] = true;
            tour.add(currentLocation);
            
            // Visit all other locations using nearest neighbor
            for (int count = 1; count < numLocations; count++) {
                int nearestLocation = -1;
                int minTime = INF;
                
                // Find nearest unvisited location
                for (int next = 0; next < numLocations; next++) {
                    if (!visited[next] && timeMatrix[currentLocation][next] < minTime) {
                        minTime = timeMatrix[currentLocation][next];
                        nearestLocation = next;
                    }
                }
                
                if (nearestLocation != -1) {
                    visited[nearestLocation] = true;
                    tour.add(nearestLocation);
                    totalTime += minTime;
                    
                    System.out.println("Delivering to: " + locations[nearestLocation].name 
                                     + " (Time: " + minTime + " minutes)");
                    currentLocation = nearestLocation;
                }
            }
            
            // Return to starting location
            totalTime += timeMatrix[currentLocation][startLocation];
            tour.add(startLocation);
            
            System.out.println("Returning to: " + locations[startLocation].name 
                             + " (Time: " + timeMatrix[currentLocation][startLocation] + " minutes)");
            
            return new TSPResult(tour, totalTime);
        }
        
        // TSP using Dynamic Programming (for small graphs)
        public TSPResult solveTSPDP(int startLocation) {
            int n = numLocations;
            int[][] dp = new int[1 << n][n];
            int[][] parent = new int[1 << n][n];
            
            // Initialize DP table
            for (int i = 0; i < (1 << n); i++) {
                Arrays.fill(dp[i], INF);
                Arrays.fill(parent[i], -1);
            }
            
            dp[1 << startLocation][startLocation] = 0;
            
            // Fill DP table
            for (int mask = 0; mask < (1 << n); mask++) {
                for (int u = 0; u < n; u++) {
                    if ((mask & (1 << u)) == 0 || dp[mask][u] == INF) continue;
                    
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) != 0) continue;

                        if (timeMatrix[u][v] == INF) continue;
                        
                        int newMask = mask | (1 << v);
                        int newCost = dp[mask][u] + timeMatrix[u][v];
                        
                        if (newCost < dp[newMask][v]) {
                            dp[newMask][v] = newCost;
                            parent[newMask][v] = u;
                        }
                    }
                }
            }
            
            // Find minimum cost to return to start
            int finalMask = (1 << n) - 1;
            int minCost = INF;
            int lastCity = -1;
            
            for (int i = 0; i < n; i++) {
                if (i != startLocation && dp[finalMask][i] != INF && 
                    timeMatrix[i][startLocation] != INF) {
                    int totalCost = dp[finalMask][i] + timeMatrix[i][startLocation];
                    if (totalCost < minCost) {
                        minCost = totalCost;
                        lastCity = i;
                    }
                }
            }
            
            // Reconstruct path
            List<Integer> tour = new ArrayList<>();
            if (lastCity != -1) {
                int mask = finalMask;
                int curr = lastCity;
                
                while (curr != -1) {
                    tour.add(curr);
                    int prev = parent[mask][curr];
                    mask ^= (1 << curr);
                    curr = prev;
                }
                Collections.reverse(tour);
                tour.add(startLocation); // Return to start
            }
            
            return new TSPResult(tour, minCost);
        }
        
        // Dijkstra's algorithm for shortest path between two locations
        public PathResult findShortestPath(int source, int destination) {
            int[] dist = new int[numLocations];
            int[] parent = new int[numLocations];
            boolean[] visited = new boolean[numLocations];
            
            Arrays.fill(dist, INF);
            Arrays.fill(parent, -1);
            dist[source] = 0;
            
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
            pq.offer(source);
            
            while (!pq.isEmpty()) {
                int u = pq.poll();
                if (visited[u]) continue;
                visited[u] = true;
                
                for (int v = 0; v < numLocations; v++) {
                    if (!visited[v] && timeMatrix[u][v] != INF) {
                        int newDist = dist[u] + timeMatrix[u][v];
                        if (newDist < dist[v]) {
                            dist[v] = newDist;
                            parent[v] = u;
                            pq.offer(v);
                        }
                    }
                }
            }
            
            // Reconstruct path
            List<Integer> path = new ArrayList<>();
            int curr = destination;
            while (curr != -1) {
                path.add(curr);
                curr = parent[curr];
            }
            Collections.reverse(path);
            
            return new PathResult(path, dist[destination]);
        }
        
        public void displayGraph() {
            System.out.println("\n=== DELIVERY TIME MATRIX (in minutes) ===");
            System.out.print("From\\To\t");
            for (int i = 0; i < numLocations; i++) {
                System.out.printf("%-12s", locations[i].name);
            }
            System.out.println();
            
            for (int i = 0; i < numLocations; i++) {
                System.out.printf("%-8s", locations[i].name);
                for (int j = 0; j < numLocations; j++) {
                    if (timeMatrix[i][j] == INF) {
                        System.out.printf("%-12s", "∞");
                    } else {
                        System.out.printf("%-12d", timeMatrix[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
    
    // Result classes
    static class TSPResult {
        List<Integer> tour;
        int totalTime;
        
        public TSPResult(List<Integer> tour, int totalTime) {
            this.tour = tour;
            this.totalTime = totalTime;
        }
    }
    
    static class PathResult {
        List<Integer> path;
        int totalTime;
        
        public PathResult(List<Integer> path, int totalTime) {
            this.path = path;
            this.totalTime = totalTime;
        }
    }
    
    public static void main(String[] args) {
        // Create delivery graph with 7 locations
        DeliveryGraph deliverySystem = new DeliveryGraph(7);
        
        // Add pizza delivery locations
        deliverySystem.addLocation(0, "Pizza Shop");
        deliverySystem.addLocation(1, "Downtown");
        deliverySystem.addLocation(2, "Mall Area");
        deliverySystem.addLocation(3, "University");
        deliverySystem.addLocation(4, "Hospital");
        deliverySystem.addLocation(5, "Suburb-A");
        deliverySystem.addLocation(6, "Suburb-B");
        
        // Add routes with delivery times (in minutes)
        deliverySystem.addRoute(0, 1, 8);   // Pizza Shop - Downtown
        deliverySystem.addRoute(0, 2, 12);  // Pizza Shop - Mall Area
        deliverySystem.addRoute(0, 5, 15);  // Pizza Shop - Suburb-A
        deliverySystem.addRoute(1, 2, 6);   // Downtown - Mall Area
        deliverySystem.addRoute(1, 3, 10);  // Downtown - University
        deliverySystem.addRoute(1, 4, 14);  // Downtown - Hospital
        deliverySystem.addRoute(2, 3, 7);   // Mall Area - University
        deliverySystem.addRoute(2, 4, 9);   // Mall Area - Hospital
        deliverySystem.addRoute(2, 6, 11);  // Mall Area - Suburb-B
        deliverySystem.addRoute(3, 4, 5);   // University - Hospital
        deliverySystem.addRoute(3, 6, 13);  // University - Suburb-B
        deliverySystem.addRoute(4, 5, 16);  // Hospital - Suburb-A
        deliverySystem.addRoute(4, 6, 8);   // Hospital - Suburb-B
        deliverySystem.addRoute(5, 6, 18);  // Suburb-A - Suburb-B
        
        // Display the delivery network
        deliverySystem.displayGraph();
        
        // Solve using Nearest Neighbor Heuristic
        System.out.println("\n=== NEAREST NEIGHBOR SOLUTION ===");
        TSPResult nnResult = deliverySystem.solveTSPNearestNeighbor(0);
        System.out.println("\nOptimal Delivery Route:");
        for (int i = 0; i < nnResult.tour.size(); i++) {
            System.out.print(deliverySystem.locations[nnResult.tour.get(i)].name);
            if (i < nnResult.tour.size() - 1) System.out.print(" → ");
        }
        System.out.println("\nTotal Delivery Time: " + nnResult.totalTime + " minutes");
        
        // Solve using Dynamic Programming (optimal for small graphs)
        if (deliverySystem.numLocations <= 10) {
            System.out.println("\n=== DYNAMIC PROGRAMMING SOLUTION (OPTIMAL) ===");
            TSPResult dpResult = deliverySystem.solveTSPDP(0);
            if (!dpResult.tour.isEmpty()) {
                System.out.println("Optimal Delivery Route:");
                for (int i = 0; i < dpResult.tour.size(); i++) {
                    System.out.print(deliverySystem.locations[dpResult.tour.get(i)].name);
                    if (i < dpResult.tour.size() - 1) System.out.print(" → ");
                }
                System.out.println("\nMinimum Total Time: " + dpResult.totalTime + " minutes");
            }
        }
        
        // Find shortest path between specific locations
        System.out.println("\n=== SHORTEST PATH ANALYSIS ===");
        PathResult pathResult = deliverySystem.findShortestPath(0, 4);
        System.out.println("Shortest path from Pizza Shop to Hospital:");
        for (int i = 0; i < pathResult.path.size(); i++) {
            System.out.print(deliverySystem.locations[pathResult.path.get(i)].name);
            if (i < pathResult.path.size() - 1) System.out.print(" → ");
        }
        System.out.println("\nTime: " + pathResult.totalTime + " minutes");
        
        // Performance comparison
        System.out.println("\n=== ALGORITHM COMPARISON ===");
        System.out.println("Nearest Neighbor (Heuristic): " + nnResult.totalTime + " minutes - Fast, Good approximation");
        if (deliverySystem.numLocations <= 10) {
            TSPResult dpResult = deliverySystem.solveTSPDP(0);
            if (!dpResult.tour.isEmpty()) {
                System.out.println("Dynamic Programming (Optimal): " + dpResult.totalTime + " minutes - Slower, Exact solution");
                double efficiency = ((double) dpResult.totalTime / nnResult.totalTime) * 100;
                System.out.println("Nearest Neighbor efficiency: " + String.format("%.1f", efficiency) + "% of optimal");
            }
        }
    }
}
