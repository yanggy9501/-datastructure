package com.app.tools.datamoudle.test.graph;

import com.app.tools.datamoudle.module.Graph;
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

    public Graph<String> createGraph() {
        Graph<String> graph = new Graph<>(5);
        // 添加顶点
        String[] vertexes = {"A", "B", "C", "D", "E"};
        Stream.of(vertexes).forEach(graph::addVertex);

        // 添加边
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);

        return graph;
    }

    @Test
    public void testDfs() {
        Graph<String> graph = createGraph();
        graph.dfsVisit(4, System.out::println);
    }

    @Test
    public void testBfs() {
        Graph<String> graph = createGraph();
        graph.bfsVisit(4, System.out::println);
    }
}
