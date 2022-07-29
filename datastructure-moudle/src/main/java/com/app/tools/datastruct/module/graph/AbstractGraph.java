package com.app.tools.datastruct.module.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 图的抽象接口
 *
 * @param <T> 数据源泛型
 * @param <W> 权重泛型
 * @author yanggy
 */
@Getter@Setter
public abstract class AbstractGraph<T, W> {

    /**
     * 有向图标志
     */
    protected boolean isDigraph;

    /**
     * 权重比较器
     */
    protected Comparator<W>  weightComparator = (o1, o2) -> {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return o1.hashCode() - o2.hashCode();
    };

    /**
     * 添加顶点
     *
     * @param vertex 顶点
     */
    public abstract void addVertex(T vertex);

    /**
     * 添加边
     *
     * @param vertex 顶点1所在数组下标
     * @param anotherVertex 顶点2所在数组下标
     * @param weight 权重
     */
    public abstract void addEdge(int vertex, int anotherVertex, W weight);

    /**
     * 移除边
     *
     * @param vertex 顶点1所在数组下标
     * @param anotherVertex 顶点2所在数组下标
     */
    public abstract void removeEdge(int vertex, int anotherVertex);

    /**
     * 获取顶点总数
     *
     * @return 顶点总数
     */
    public abstract int getVertexTotal();

    /**
     * 获取index位置的顶点值
     *
     * @param index 顶点下标
     * @return 顶点index的值
     */
    public abstract T getValue(int index);

    /**
     * 获取两顶点间的权重
     *
     * @param vertex 顶点下标1
     * @param anotherVertex 顶点下标2
     * @return 顶点间的权值
     */
    public abstract W getWeight(int vertex, int anotherVertex);

    /**
     * 设置权重
     *
     * @param vertex 顶点下标1
     * @param anotherVertex 顶点下标2
     * @param weight 权重
     */
    public abstract void setWeight(int vertex, int anotherVertex, W weight);

    /**
     * 判断两个顶点是否邻接
     *
     * @param vertex 顶点下标1
     * @param anotherVertex 顶点下标2
     * @return boolean true则边存在，否则不存在
     */
    public abstract boolean isAdjaceted(int vertex, int anotherVertex);

    /**
     * 获取顶点的第一条邻边的顶点下标，不存在则返回 -1
     *
     * @param vertex 顶点下标
     * @return 第一条邻边的顶点下标，-1 则不存在邻边
     */
    public abstract int getFirstNeighbor(int vertex);

    /**
     * 从上一次顶点开始，获取顶点的下一条邻边，不存在则返回 -1
     *
     * @param vertex 顶点下标
     * @param lastIndex 与 {@code vertex} 邻接的并且上一次的顶点下标
     * @return 下一条邻边下标，-1 则不存在邻边
     */
    public abstract int getNextNeighbor(int vertex, int lastIndex);

    /**
     * 列出图中与节点 {@code vertex} 相邻的节点
     *
     * @param vertex 顶点下标
     * @return 相邻的节点集合
     */
    public List<Integer> getNeighbors(int vertex) {
        return Collections.emptyList();
    }

    /**
     * 打印图的边
     */
    public void printGraph() {

    }

    /**
     * 深度优先访问所有顶点，默认从0号顶点开始访问
     *
     * @param consumer 顶点的消费者
     */
    public void dfsVisit(Consumer<T> consumer) {

    }

    /**
     * 从指定起始顶点深度优先访问所有顶点
     *
     * @param index 访问起始顶点
     * @param consumer 顶点的消费者
     */
    public void dfsVisit(int index, Consumer<T> consumer) {

    }

    /**
     * 广度度优先访问所有顶点，默认从0号顶点开始访问
     *
     * @param consumer 顶点的消费者
     */
    public void bfsVisit(Consumer<T> consumer) {

    }

    /**
     * 从指定起始顶点广度优先访问所有顶点
     *
     * @param root 访问起始顶点
     * @param consumer 顶点的消费者
     */
    public void bfsVisit(int root, Consumer<T> consumer) {

    }
}
