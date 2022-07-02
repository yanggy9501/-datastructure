package com.app.tree.module.tree;

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
     * 节点数据属性
     */
    private T data;

    /**
     * 孩子节点
     */
    private List<TreeNode<T>> children;
}
