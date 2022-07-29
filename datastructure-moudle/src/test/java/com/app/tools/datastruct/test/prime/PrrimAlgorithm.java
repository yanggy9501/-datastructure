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

    public MatrixGraph<String, Integer> createGraph() {
        // 添加顶点
        String[] vertexes = {"A", "B", "C", "D", "E", "F", "G"};
        List<String> list = Arrays.asList(vertexes);

        // 添加边
        Integer[][] edges = new Integer[][] {
        //   A      B       C       D       E     F     G
            {null, 5,      7,    null, null, null, 2},      // A
            {5,     null, null, 9,     null, null, 3},      // B
            {7,     null, null, null, 8,     null, null},  // C
            {null, 9,     null, null, null, 4,     null},  // D
            {null, null, 8,     null, null, 5,     4},      // E
            {null, null, null, 4,     5,     null, 6},      // F
            {2,     3,     null, null, 4,     6,     null}   // G
        };

        return GraphHelper.createGraph(edges, list);
    }

    @Test
    public void test1() {
        MatrixGraph<String, Integer> matrixGraph = createGraph();
        matrixGraph.setWeightComparator(Integer::compareTo);
        matrixGraph.printGraph();
    }

    // prime 算法
    @Test
    public void prim() {
        MatrixGraph<String, Integer> matrixGraph = createGraph();
        matrixGraph.setWeightComparator((o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1 - o2;
        });
        MatrixGraph<String, Integer> prim = GraphHelper.findMstByPrim(matrixGraph, 0);
        prim.printGraph();
    }
}
