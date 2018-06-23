package com.test.graph.bfs;

/**
 * Created by kunal on 06/11/17.
 */
public class TestGraph {
    public static void main(String[] args) {
        /**
         * A->D,C
C->B,E
D->
E->B, D
         */
        
        Vertex A = new Vertex(1);
        Vertex B = new Vertex(2);
        Vertex C = new Vertex(3);
        Vertex D = new Vertex(4);
        Vertex E = new Vertex(5);
        
        A.addNeighbour(D);
        A.addNeighbour(C);
        B.addNeighbour(D);
        C.addNeighbour(B);
        C.addNeighbour(E);
        E.addNeighbour(B);
        E.addNeighbour(D);
        
        BFS bfs = new BFS();
        bfs.bfs(A);
    }
}
