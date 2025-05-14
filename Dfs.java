import java.util.*;

// sec 4 Find the Diameter of a Binary Tree
class Dfs {
    private boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;

        List<Integer> neighbors = adj.get(node);
        for (int i = 0; i < neighbors.size(); i++) {
            int it = neighbors.get(i);

            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }

    public boolean isCyclic(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4; // total node
        List<List<Integer>> adj = new ArrayList<>();

        // adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);

        Dfs obj = new Dfs();
        if (obj.isCyclic(V, adj)) {
            System.out.println("Yes detect a Cycle");
        } else {
            System.out.println("No Cycle");
        }
    }
}
