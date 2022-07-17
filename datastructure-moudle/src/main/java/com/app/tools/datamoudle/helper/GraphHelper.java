package com.app.tools.datamoudle.helper;


import com.app.tools.datamoudle.module.Graph;

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
     * @return Graph图
     */
    public static <T> Graph<T> createGraph(int[][] edges, List<T> vertexes) {
        Graph<T> graph = new Graph<>(vertexes.size());
        // add vertex
        vertexes.forEach(graph::addVertex);
        // add edge
        for (int i = 0; i < edges.length; i++) {
            int[] vertexEdge = edges[i];
            for (int j = 0; j < vertexEdge.length; j++) {
                graph.addEdge(i, j, edges[i][j]);
            }
        }
        return graph;
    }

    /**
     * 连通图的 prim 算法生成最小生成树。如果图不连通最小生成将不会有不连通的节点。
     *
     * @param graph 连通图
     * @param begin 开始节点
     * @param <T> 数据泛型
     * @return 最小生成树
     */
    public static <T> Graph<T> findMstByPrim(Graph<T> graph, int begin) {
        int vertexNumber = graph.getVertexTotal();
        // visited 数组用于记录各个顶点属于最小生成树类集合 A 还是原始图中待加入最小生成树类的集合 B。false代表是B类， true代表是A类
        boolean[] visited = new boolean[vertexNumber];
        // parent 数组用于记录最小生成树中各个顶点父节点的位置(记录路径：集合B通过A中什么节点加入A的)
        int[] parent = new int[vertexNumber];
        // weight数组用于记录 B 类顶点到 A 类顶点的最小权值
        int[] weight = new int[vertexNumber];
        // 初始化
        initPrim(parent, weight);
        // 最小生成树开始节点初始，权重置为0，该顶点没有父节点
        weight[begin] = 0;
        parent[begin] = -1;

        // 对于 V 个顶点的图，最需选择 V-1 条路径，即可构成最小生成树
        for (int i = 0; i < vertexNumber - 1; i++) {
            // 从 weight 数组中找到权值最小的顶点所在的位置，并标记为true（加入到A类-最小生成树集合中）
            int index = findMinWeightKey(weight, visited);
            visited[index] = true;

            // 由于新顶点加入 A 类，因此需要更新 weight 数组中的数据（B到A有更小的权重则更新）
            for (int v = 0; v < vertexNumber; v++) {
                if (!visited[v] && graph.getWeight(v, index) < weight[v]) {
                    parent[v] = index;
                    weight[v] = graph.getWeight(v, index);
                }
            }
        }

        return createMstTreeByPrim(parent, graph);
    }

    /**
     * 初始化weight，parent
     *
     * @param parent 集合B通过A中什么节点加入A的
     * @param weight 最小生成树类集合 A 到原始图中待加入最小生成树类的集合B的最小权重
     */
    private static void initPrim(int[] parent, int[] weight) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
            // 权重无穷大，代表不连通
            weight[i] = Integer.MAX_VALUE;
        }
    }

    /**
     * 寻找权重最小的未加入最小生成树的图的节点
     *
     * @param weight 最小生成树类集合 A 到原始图中待加入最小生成树类的集合B的最小权重
     * @param visited 集合B加入A的路径
     * @return 节点下标 -1代表找不到
     */
    private static int findMinWeightKey(int[] weight, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < weight.length; v++) {
            if (!visited[v] && weight[v] < min) {
                min = weight[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /**
     * 生成最小生成树
     *
     * @param parent 路径节点下标index代表代表节点位置，parent[index]值代表当前节点通过parent[index]节点加入最小生成树的，即parent
     * @param graph 图
     * @param <T> 数据泛型
     * @return 最小生成树
     */
    private static <T> Graph<T> createMstTreeByPrim(int[] parent, Graph<T> graph) {
        Graph<T> mstGraph = new Graph<>(graph.getVertexTotal());
        for (int i = 0; i < parent.length; i++) {
            mstGraph.addVertex(graph.getValue(i));
            // 起始节点的parent = -1
            if (parent[i] > -1) {
                mstGraph.addEdge(i, parent[i], graph.getWeight(i, parent[i]));
            }
        }
        return mstGraph;
    }
}
