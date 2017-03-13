package com.company;

public class Vertex {
    public char label;
    public boolean wasVisited;
    public boolean isInTree;

    public Vertex(char label) {
        this.label = label;
        isInTree = false;
    }
}
