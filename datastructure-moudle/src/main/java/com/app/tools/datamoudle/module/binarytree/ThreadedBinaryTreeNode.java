package com.app.tools.datamoudle.module.binarytree;

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
public class ThreadedBinaryTreeNode<T> {
    /**
     * 数据域
     */
    private T data;

    /**
     * 左子节点
     */
    private ThreadedBinaryTreeNode<T> leftNode;

    /**
     * 左节点指针类型
     */
    private PointType leftType = PointType.CHILDREN_POINT;

    /**
     * 右子节点
     */
    private ThreadedBinaryTreeNode<T> rightNode;

    /**
     * 右节点指针类型
     */
    private PointType rightType = PointType.CHILDREN_POINT;

    @Override
    public String toString() {
        return "ThreadedBinaryTreeNode{" +
            "leftType=" + leftType +
            ", rightType=" + rightType +
            ", data=" + data +
            '}';
    }

    public enum PointType {
        /**
         * 孩子节点 point
         */
        CHILDREN_POINT(0),

        /**
         * 前驱或后继 point
         */
        PRE_OR_PSOT_POINT(1);

        /**
         * 指针类型int值
         */
        int value;

        PointType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
