package com.app.tools.datastruct.datamodule;

import com.app.tools.datastruct.constants.RbtColorEnum;
import com.app.tools.datastruct.datamodule.binarytree.BinaryTreeNode;
import com.app.tools.datastruct.datamodule.binarytree.RbTreeNode;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 红黑树
 *
 * @author yanggy
 */
public class RbTree<T> extends BinarySortTree<T> {

    public RbTree(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void add(T data) {
        RbTreeNode<T> node = new RbTreeNode<>(data);
        if (getRoot() == null) {
            node.setColor(RbtColorEnum.BLACK);
        }
        super.add(node);
    }

    @Override
    public void add(BinaryTreeNode<T> node) {
        if (node instanceof RbTreeNode) {
            if (getRoot() == null) {
                toRbTreeNode(node).setColor(RbtColorEnum.BLACK);
            }
            super.add(node);
        }
    }

    @Override
    public void add(List<T> dataList) {
        dataList.forEach(this::add);
    }

    @Override
    public void delete(T targetValue) {

    }

    @Override
    public void remove(Predicate<BinaryTreeNode<T>> predicate) {

    }

    /**
     * 通过 RbTreeNode.parent 获取该节点的父节点
     *
     * @param targetNode BinaryTreeNode
     * @return RbTreeNode
     */
    @Override
    public RbTreeNode<T> findParent(BinaryTreeNode<T> targetNode) {
        RbTreeNode<T> node = toRbTreeNode(targetNode);
        if (node != null) {
            return node.getParent();
        }
        return null;
    }

    private void leftRotate(RbTreeNode<T> node) {
        RbTreeNode<T> rightNode = node.getRightNode();

    }

    private boolean isRedNode(RbTreeNode<T> node) {
        if (node != null) {
            return node.getColor() == RbtColorEnum.RED;
        }
        return false;
    }

    private void setNodeColor(RbTreeNode<T> node, RbtColorEnum color) {
        if (node != null) {
            node.setColor(color);
        }
    }

    private RbTreeNode<T> toRbTreeNode(BinaryTreeNode<T> node) {
        // null instanceof RbTreeNode 总是false
        if (node instanceof RbTreeNode) {
            return (RbTreeNode<T>) node;
        }
        if (node == null) {
            return null;
        }
        throw new ClassCastException("class of node is not RbTreeNode<T>");
    }
    
}
