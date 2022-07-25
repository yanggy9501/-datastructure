package com.app.tools.datastruct.module.tree;

import lombok.Data;

import java.util.List;

/**
 * Tree节点
 * 树的孩子表示法描述节点
 *
 * @author yanggy
 */
@Data
public class TreeNode<T>{
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
