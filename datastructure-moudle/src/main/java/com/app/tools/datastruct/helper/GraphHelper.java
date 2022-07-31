package com.app.tools.datastruct.helper;


import com.app.tools.datastruct.datamodule.MatrixGraph;
import com.app.tools.datastruct.datamodule.graph.Edge;
import com.app.tools.datastruct.utils.SortUtils;

import java.util.Comparator;
import java.util.List;

/**
 * 图的帮助类
 *
 * @author yanggy
 */
public class GraphHelper {
    /**
     * 创建一个无向图
     *
     * @param edges 边集
     * @param vertexes 顶点
     * @param <T> 数据泛型
     * @param <W> 边权值泛型
     * @return Graph图
     */
    public static <T, W> MatrixGraph<T, W> createGraph(W[][] edges, List<T> vertexes) {
        MatrixGraph<T, W> matrixGraph = new MatrixGraph<>(vertexes.size());
        // add vertex
        vertexes.forEach(matrixGraph::addVertex);
        // add edge
        for (int i = 0; i < edges.length; i++) {
            W[] edge = edges[i];
            for (int j = 0; j < edge.length; j++) {
                if (edges[i][j] != null) {
                    // 边存在则添加边
                    matrixGraph.addEdge(i, j, edge[j]);
                }
            }
        }
        return matrixGraph;
    }



    /**
     * 连通图的 prim 算法生成最小生成树。如果图不连通最小生成将不会有不连通的节点。
     *
     * @param matrixGraph 连通图
     * @param begin 开始节点
     * @param <T> 数据泛型
     * @return 最小生成树
     */
    @SuppressWarnings("unchecked")
    public static <T, W> MatrixGraph<T, W> findMstByPrim(MatrixGraph<T, W> matrixGraph, int begin) {
        int vertexNumber = matrixGraph.getVertexTotal();
        // visited 数组用于记录各个顶点属于最小生成树类集合 A 还是原始图中待加入最小生成树类的集合 B。false代表是B类， true代表是A类
        boolean[] visited = new boolean[vertexNumber];
        // parent 数组用于记录最小生成树中各个顶点父节点的位置(记录路径：集合B通过A中什么节点加入A的)
        int[] parent = new int[vertexNumber];
        // weight数组用于记录 B 类顶点到 A 类顶点的最小权值
        Object[] weight =  new Object[vertexNumber];

        initOnPrim(begin, parent, matrixGraph, weight);
        // 最小生成树开始节点初始，权重置为null，该顶点没有父节点
        visited[begin] = true;

        Comparator<W> weightComparator = matrixGraph.getWeightComparator();
        // 对于 V 个顶点的图，最需选择 V-1 条路径，即可构成最小生成树
        for (int i = 0; i < vertexNumber - 1; i++) {
            // 从 weight 数组中找到权值最小的顶点所在的位置，并标记为true（加入到A类-最小生成树集合中）
            int index = findMinWeightKey(weight, visited, weightComparator);
            visited[index] = true;

            // 由于新顶点加入 A 类，因此需要更新 weight 数组中的数据（B到A有更小的权重则更新）
            for (int v = 0; v < vertexNumber; v++) {
                if (!visited[v] && matrixGraph.isAdjaceted(index, v)
                    && weightComparator.compare(matrixGraph.getWeight(index, v), (W) weight[v])  < 0) {
                    parent[v] = index;
                    weight[v] = matrixGraph.getWeight(index, v);
                }
            }
        }

        return createMstTreeByPrim(parent, matrixGraph);
    }

    private static <T, W> void initOnPrim(int begin, int[] parent, MatrixGraph<T, W> matrixGraph, Object[] weight) {
        weight[begin] = null;
        for (int i = 0; i < weight.length; i++) {
            if (matrixGraph.isAdjaceted(begin, i)) {
                W w = matrixGraph.getWeight(begin, i);
                parent[i] = begin;
                weight[i] = w;
            }
        }
        parent[begin] = -1;
    }

    /**
     * 寻找权重最小的未加入最小生成树的图的节点
     *
     * @param weight 最小生成树类集合 A 到原始图中待加入最小生成树类的集合B的最小权重
     * @param visited 集合B加入A的路径
     * @param comparator 权重的比较器, 权重为 null一般代表无穷大
     * @return 节点下标 -1代表找不到
     */
    @SuppressWarnings("unchecked")
    private static <W> int findMinWeightKey(Object[] weight, boolean[] visited, Comparator<W> comparator) {
        // null 一般代表路径不通，即可表示权重很大，可根据比较器表示不同含义，这里将min设置为第一个未被访问的节点的权重，防止null有特殊。
        W min = null;
        int minIndex =  -1;
        for (int v = 0; v < weight.length; v++) {
            if (!visited[v] && comparator.compare((W) weight[v], min) < 0) {
                min = (W) weight[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /**
     * 生成最小生成树
     *
     * @param parent 路径节点下标index代表代表节点位置，parent[index]值代表当前节点通过parent[index]节点加入最小生成树的，即parent
     * @param matrixGraph 图
     * @param <T> 数据泛型
     * @return 最小生成树
     */
    private static <T, W> MatrixGraph<T, W> createMstTreeByPrim(int[] parent, MatrixGraph<T, W> matrixGraph) {
        MatrixGraph<T, W> mstMatrixGraph =
            new MatrixGraph<>(matrixGraph.getVertexTotal(), matrixGraph.getWeightComparator());
        for (int i = 0; i < parent.length; i++) {
            mstMatrixGraph.addVertex(matrixGraph.getValue(i));
            // 起始节点的parent = -1
            if (parent[i] > -1) {
                mstMatrixGraph.addEdge(i, parent[i], matrixGraph.getWeight(i, parent[i]));
            }
        }
        return mstMatrixGraph;
    }

    /**
     * 连通图的 prim 算法生成最小生成树。如果图不连通最小生成将不会有不连通的节点。
     *
     * @param matrixGraph 连通图
     * @param begin 开始节点
     * @param <T> 数据泛型
     * @return 最小生成树
     */

    public static <T, W> MatrixGraph<T, W> findMstByKrusalCase(MatrixGraph<T, W> matrixGraph, int begin) {
        W[] weightOfEdge = getEdges(matrixGraph);
        SortUtils.heapSort(weightOfEdge, matrixGraph.getWeightComparator());

        return null;
    }

    @SuppressWarnings("unchecked")
    private static <T, W> W[] getEdges(MatrixGraph<T, W> matrixGraph) {
        Object[] edgeArr = new Object[matrixGraph.getEdgeTotal()];
        Object[][] edges = matrixGraph.getEdges();
        int n = 0;
        if (matrixGraph.isDigraph()) {
            for (int i = 0; i < edges.length; i++) {
                for (int j = 0; j < edges.length; j++) {
                    if (matrixGraph.isAdjaceted(i, j)) {
                        edgeArr[n++] =  ((Edge<W>) edges[i][j]).getWeight();
                    }
                }
            }
            return (W[]) edgeArr;
        }

        // 无向图
        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                if (matrixGraph.isAdjaceted(i, j)) {
                    edgeArr[n++] = ((Edge<W>) edges[i][j]).getWeight();
                }
            }
        }
        return (W[]) edgeArr;
    }

}
