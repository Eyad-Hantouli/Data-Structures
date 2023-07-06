package undirectedGraph;

import java.util.Arrays;

public class AdjMatrixGraph {
    int E, V;
    int[][] adjMatrix;
    public AdjMatrixGraph (int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int node1, int node2) {
        this.adjMatrix[node1][node2] = 1;
        this.adjMatrix[node2][node1] = 1;
        this.E++;
    }

    public void display () {
        for (int[] i : adjMatrix) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    public int getEdges() {
        return E;
    }

    public int getVertexes() {
        return V;
    }
}
