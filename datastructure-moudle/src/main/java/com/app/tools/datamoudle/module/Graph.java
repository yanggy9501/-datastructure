package com.app.tools.datamoudle.module;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 无向图
 *
 * @author yanggy
 */
@Getter
public class Graph <T> {
    /**
     * 顶点集
     */
    private final List<T> vertexes;

    /**
     * 边集
     */
    private final int[][] edges;

    /**
     * 边的总数
     */
    private int edgeTotal;

    public Graph(int vertexTotal) {
        edges = new int[vertexTotal][vertexTotal];
        vertexes = new ArrayList<>();
    }

    /**
     * 添加顶点
     *
     * @param vertex 顶点
     */
    public void addVertex(T vertex) {
        vertexes.add(vertex);
    }

    /**
     * 添加边
     *
     * @param vertex1 顶点1所在数组下标
     * @param vertex2 顶点2所在数组下标
     * @param weight 权重
     */
    public void addEdge(int vertex1, int vertex2, int weight) {
        edges[vertex1][vertex2] = weight;
        edges[vertex2][vertex1] = weight;
        edgeTotal++;
    }

    /**
     * 移除边
     *
     * @param vertex1 顶点1所在数组下标
     * @param vertex2 顶点2所在数组下标
     */
    public void removeEdge(int vertex1, int vertex2) {
        edges[vertex1][vertex2] = 0;
        edges[vertex2][vertex1] = 0;
        edgeTotal++;
    }




    /**
     * 获取顶点总数
     *
     * @return 顶点总数
     */
    public int getVertexTotal() {
        return vertexes.size();
    }

    /**
     * 获取index位置的顶点值
     *
     * @param index 顶点下标
     * @return 顶点index的值
     */
    public T getValue(int index) {
        return vertexes.get(index);
    }

    /**
     * 获取两顶点间的权重
     *
     * @param vertex1 顶点下标1
     * @param vertex2 顶点下标2
     * @return 顶点间的权值
     */
    public int getWeight(int vertex1, int vertex2) {
        return edges[vertex1][vertex2];
    }

    /**
     * 打印边
     */
    public void printGraph() {
        for (int[] links : edges) {
            System.out.println(Arrays.toString(links));
        }
    }

    /**
     * 深度优先访问所有顶点，默认从0号顶点开始访问
     *
     * @param consumer 顶点的消费者
     */
    public void dfsVisit(Consumer<T> consumer) {
        dfsVisit(0, consumer);
    }

    /**
     * 从指定起始顶点深度优先访问所有顶点
     *
     * @param index 访问起始顶点
     * @param consumer 顶点的消费者
     */
    public void dfsVisit(int index, Consumer<T> consumer) {
        boolean[] visited = new boolean[getVertexTotal()];
        doDfsVisit(index, visited, consumer);
        for (int i = 0; i < getVertexTotal(); i++) {
            if (!visited[i]) {
                doDfsVisit(i, visited, consumer);
            }
        }
    }

    /**
     * dfs 深度优先算法实现
     *
     * @param vertex 当前要访问的顶点下标
     * @param visited 访问标记数组
     * @param consumer 顶点的消费者
     */
    private void doDfsVisit(int vertex, boolean[] visited, Consumer<T> consumer) {
        // visit vertex
        consumer.accept(vertexes.get(vertex));
        visited[vertex] = true;
        // get first neighbor vertex
        int neighborVertex = getFirstNeighbor(vertex);
        // vertex exist neighbor vertex
        while (neighborVertex == -1) {
            if (!visited[vertex]) {
                doDfsVisit(neighborVertex, visited, consumer);
            }
            neighborVertex = getNextNeighbor(vertex, neighborVertex);
        }
    }

    /**
     * 广度度优先访问所有顶点，默认从0号顶点开始访问
     *
     * @param consumer 顶点的消费者
     */
    public void bfsVisit(Consumer<T> consumer) {
        bfsVisit(0, consumer);
    }

    /**
     * 从指定起始顶点广度优先访问所有顶点
     *
     * @param root 访问起始顶点
     * @param consumer 顶点的消费者
     */
    public void bfsVisit(int root, Consumer<T> consumer) {
        boolean[] visited = new boolean[getVertexTotal()];
        doBfsVisit(root, visited, consumer);
        for (int i = 0; i < getVertexTotal(); i++) {
            if (!visited[i]) {
                doBfsVisit(i, visited, consumer);
            }
        }
    }

    /**
     * bfs 广度优先算法实现
     * 实现：顶点v访问并入队，出队时访问所有v相邻的顶点并入队。访问完顶点v的所有相邻节点，依次重复该操作。
     *
     * @param root 当前要访问的顶点下标
     * @param visited 访问标记数组
     * @param consumer 顶点的消费者
     */
    private void doBfsVisit(int root, boolean[] visited, Consumer<T> consumer) {
        LinkedList<Integer> queue = new LinkedList<>();
        // visit vertex
        consumer.accept(vertexes.get(root));
        visited[root] = true;
        queue.addLast(root);
        // v 队头节点下标，n 相邻节点下标
        int v, n;
        while (!queue.isEmpty()) {
            // 遍历所有与 v 相邻的顶点
            v = queue.removeFirst();
            n = getFirstNeighbor(v);
            while (n != -1) {
                if (!visited[n]) {
                    consumer.accept(vertexes.get(n));
                    visited[n] = true;
                    queue.addLast(n);
                }
                n = getNextNeighbor(v, n);
            }
        }
    }

    /**
     * 获取顶点的第一条邻边的顶点下标，不存在则返回 -1
     *
     * @param current 当前顶点下标
     * @return 第一条邻边的顶点下标，-1 则不存在邻边
     */
    public int getFirstNeighbor(int current) {
        for (int i = 0; i < getVertexTotal(); i++) {
            if (edges[current][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从上一次顶点开始，获取顶点的下一条邻边，不存在则返回 -1
     *
     * @param current 当前顶点下标
     * @param lastIndex 上一次的顶点下标
     * @return 下一条邻边下标，-1 则不存在邻边
     */
    public int getNextNeighbor(int current, int lastIndex) {
        for (int i = lastIndex + 1; i < getVertexTotal(); i ++) {
            if (edges[current][i] > 0) {
                return i;
            }
        }
        return -1;
    }
}
