package com.app.tools.datastruct.datamodule.graph;

import lombok.Data;

/**
 * 图的边
 *
 * @author yanggy
 */
@Data
public class Edge<W> {
    /**
     * 边的起点
     */
    private int from;

    /**
     * 边的终点
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
