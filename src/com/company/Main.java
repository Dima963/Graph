package com.company;

import com.company.Dijkstra.GraphD;

public class Main {

    public static void main(String[] args) {

        GraphD graph =  new GraphD();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addAdj(0, 1, 50);
        graph.addAdj(0, 3, 80);
        graph.addAdj(1, 2, 60);
        graph.addAdj(1, 3, 90);
        graph.addAdj(2, 4, 40);
        graph.addAdj(3, 2, 20);
        graph.addAdj(3, 4, 70);
        graph.addAdj(4, 1, 50);

        System.out.print("Visits: ");
        graph.path();
        System.out.println();
    }
}
