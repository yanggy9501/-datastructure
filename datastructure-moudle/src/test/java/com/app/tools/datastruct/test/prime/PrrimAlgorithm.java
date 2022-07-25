package com.app.tools.datastruct.test.prime;

import com.app.tools.datastruct.helper.GraphHelper;
import com.app.tools.datastruct.module.MatrixGraph;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author yanggy
 */
public class PrrimAlgorithm {

     /*       A  B  C  D  E                       A --- C
           A [0, 1, 1, 0, 0]                        \  /
           B [1, 0, 1, 1, 1]                          B
           C [1, 1, 0, 0, 0]                        /   \
           D [0, 1, 0, 0, 0]                       D     E
           E [0, 1, 0, 0, 0]
      */

    public MatrixGraph<String> createGraph() {
        // 添加顶点
        String[] vertexes = {"A", "B", "C", "D", "E", "F", "G"};
        List<String> list = Arrays.asList(vertexes);

        // 添加边
        int[][] edges = new int[][] {
        //   A      B       C       D       E     F     G
            {10000, 5,      7,    10000, 10000, 10000, 2},      // A
            {5,     10000, 10000, 9,     10000, 10000, 3},      // B
            {7,     10000, 10000, 10000, 8,     10000, 10000},  // C
            {10000, 9,     10000, 10000, 10000, 4,     10000},  // D
            {10000, 10000, 8,     10000, 10000, 5,     4},      // E
            {10000, 10000, 10000, 4,     5,     10000, 6},      // F
            {2,     3,     10000, 10000, 4,     6,     10000}   // G
        };

        return GraphHelper.createGraph(edges, list);
    }

    @Test
    public void test1() {
        MatrixGraph<String> matrixGraph = createGraph();
        matrixGraph.printGraph();
    }

    // prime 算法
    @Test
    public void prim() {
        MatrixGraph<String> matrixGraph = createGraph();
        MatrixGraph<String> prim = GraphHelper.findMstByPrim(matrixGraph, 0);
        prim.printGraph();
    }
}
