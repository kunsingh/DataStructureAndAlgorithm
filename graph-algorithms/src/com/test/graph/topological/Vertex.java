package com.test.graph.topological;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private boolean beingVisited;
    private List<Vertex> neighbourList;

    public Vertex(final String name) {
        this.name = name;
        this.neighbourList = new ArrayList<>();
    }
    
    public void addNeighbour(final Vertex vertex) {
        this.neighbourList.add(vertex);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getData() {
        return name;
    }

    public void setData(String data) {
        this.name = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }
    
    
}
