package com.app.tools.datastruct.test.graph;

import com.app.tools.datastruct.module.MatrixGraph;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author yanggy
 */
public class TestGraph1 {
     /*       A  B  C  D  E                       A --- C
           A [0, 1, 1, 0, 0]                        \  /
           B [1, 0, 1, 1, 1]                          B
           C [1, 1, 0, 0, 0]                        /   \
           D [0, 1, 0, 0, 0]                       D     E
           E [0, 1, 0, 0, 0]
      */

    public MatrixGraph<String> createGraph() {
        MatrixGraph<String> matrixGraph = new MatrixGraph<>(5);
        // 添加顶点
        String[] vertexes = {"A", "B", "C", "D", "E"};
        Stream.of(vertexes).forEach(matrixGraph::addVertex);

        // 添加边
        matrixGraph.addEdge(0, 1, 1);
        matrixGraph.addEdge(0, 2, 1);
        matrixGraph.addEdge(1, 2, 1);
        matrixGraph.addEdge(1, 3, 1);
        matrixGraph.addEdge(1, 4, 1);

        return matrixGraph;
    }

    @Test
    public void testDfs() {
        MatrixGraph<String> matrixGraph = createGraph();
        matrixGraph.dfsVisit(4, System.out::println);
    }

    @Test
    public void testBfs() {
        MatrixGraph<String> matrixGraph = createGraph();
        matrixGraph.bfsVisit(4, System.out::println);
    }
}
