package com.app.tree.domain.tree;

import lombok.Data;

import java.util.List;

/**
 * Tree节点
 *
 * @author yanggy
 */
@Data
public class TreeNode<T>{
    /**
     * 排序字段
     */
    private int sortOrder = 0;

    /**
     * 节点数据属性
     */
    private T data;

    /**
     * 孩子节点
     */
    private List<TreeNode<T>> children;
}
