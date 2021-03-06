package com.test.graph.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunal on 06/11/17.
 */
public class Vertex {

    private int data;
    private boolean visited;
    private List<Vertex> neighbourList;

    public Vertex(final int data) {
        this.data = data;
        this.neighbourList = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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

    public void addNeighbour(final Vertex vertex) {
        this.neighbourList.add(vertex);
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
