package com.app.tree.domain.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二叉树结点
 *
 * @author yanggy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  BinaryTreeNode <T> {
    /**
     * 左子节点
     */
    private BinaryTreeNode<T> leftNode;

    /**
     * 右子节点
     */
    private BinaryTreeNode<T> rightNode;

    /**
     * 数据域
     */
    private T data;

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
            "data=" + data +
            '}';
    }
}
