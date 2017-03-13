package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final static int MAX_VERTEX = 20;
    private Vertex[] vertexList;
    private int adjMatrix[][];
    private  int nVertex;
    private Stack stack;
    private Queue queue;

    public Graph(){
        vertexList = new Vertex[MAX_VERTEX];
        adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        nVertex = 0;
        for (int i = 0; i<MAX_VERTEX; i++)
            for (int j = 0; j<MAX_VERTEX; j++)
                adjMatrix[i][j] = 0;
        stack = new Stack();
        queue =  new PriorityQueue();
    }

    public void addVertex(char label){
        vertexList[nVertex++] = new Vertex(label);
    }

    public void addAdj(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    //Depth-first search
    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()){
            int v = getAdjUnvisitedVertex((int)stack.peek());
            if(v == -1)
                stack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int j = 0; j<nVertex; j++){
            vertexList[j].wasVisited = false;
        }
    }

    //breadth-first search
    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;

        while (!queue.isEmpty()){
            int v1 = (int)queue.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }

        for (int j = 0; j<nVertex; j++){
            vertexList[j].wasVisited = false;
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j<nVertex; j++){
            if(adjMatrix[v][j] == 1 && vertexList[j].wasVisited == false )
                return j;
        }
        return -1;
    }
















}
