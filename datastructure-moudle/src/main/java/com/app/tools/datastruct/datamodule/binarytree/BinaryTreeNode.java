package com.app.tools.datastruct.datamodule.binarytree;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二叉树结点
 *
 * @author yanggy
 */
@Data
@NoArgsConstructor
public class  BinaryTreeNode <T> {
    /**
     * 数据域
     */
    private T data;

    /**
     * 左子节点
     */
    private BinaryTreeNode<T> leftNode;

    /**
     * 右子节点
     */
    private BinaryTreeNode<T> rightNode;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
            "data=" + data +
            '}';
    }
}
