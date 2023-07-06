package undirectedGraph;

import java.util.Arrays;
import java.util.LinkedList;

public class AdjListGraph {
    int E, V;
    LinkedList<Integer>[] adjList;
    public AdjListGraph (int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjList = new LinkedList[this.V];
        for (int i = 0; i<this.V; i++)
            adjList[i] = new LinkedList<Integer>();
    }

    public void addEdge (int node1, int node2) {
        this.adjList[node1].add(node2);
        this.adjList[node2].add(node1);
        this.E ++;
    }

    public void display () {
        for (int i=0; i<this.V; i++) {
            System.out.println(i + " -> " + adjList[i]);
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
