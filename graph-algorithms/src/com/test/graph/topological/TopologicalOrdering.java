package com.test.graph.topological;

import java.util.Stack;

public class TopologicalOrdering {

    private Stack<Vertex> stack;
    
    public TopologicalOrdering(){
        this.stack = new Stack<>();
    }
    
    public void dfs(final Vertex vertex){
        
        vertex.setVisited(true);
        
    }
}
