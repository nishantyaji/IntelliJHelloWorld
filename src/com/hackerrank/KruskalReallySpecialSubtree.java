package com.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KruskalReallySpecialSubtree {
    public static void main(String[] args) {

    }

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public static int compareTo(Edge first, Edge second) {
            if(first.weight == second.weight) {
                return (first.to + first.from) - (second.to + second.from);
            } else {
                return first.weight - second.weight;
            }
        }
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        Set<Integer> visitedEdges = new HashSet<>();
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < gWeight.size();i++){
            Edge edge = new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i));
            edges.add(edge);
        }
        edges.sort(Edge::compareTo);

        int sumOfEdges = 0;
        for(Edge edge: edges) {
            if(visitedEdges.size() == gNodes) {
                break;
            }
            if(!visitedEdges.contains(edge.to) || !visitedEdges.contains(edge.from)) {
                visitedEdges.add(edge.to);
                visitedEdges.add(edge.from);
                sumOfEdges += edge.weight;
            }
        }
        return sumOfEdges;
    }
}
