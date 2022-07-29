package com.app.tools.datastruct.module.graph;

import lombok.Data;

/**
 * 图的边
 *
 * @author yanggy
 */
@Data
public class Edge<W> {
    /**
     * 边的开始节点
     */
    private int from;

    /**
     * 边的结束节点
     */
    private int to;

    /**
     * 边的权重
     */
    private W weight;

    public Edge(int from, int to, W weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
