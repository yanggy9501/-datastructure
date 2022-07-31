package com.app.tools.datastruct.datamodule.tree;

import lombok.Data;

import java.util.List;

/**
 * 树的孩子表示法
 *
 * @author yanggy
 */
@Data
public class TreeNode<T> {
    public TreeNode() {

    }

    public TreeNode(T data) {
        this.data = data;
    }

    /**
     * 节点数据属性
     */
    private T data;

    /**
     * 孩子节点
     */
    private List<TreeNode<T>> children;
}
