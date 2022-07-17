package com.app.tools.datamoudle.module.tree;

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
    /**
     * 节点数据属性
     */
    private T data;

    /**
     * 孩子节点
     */
    private List<TreeNode<T>> children;
}
