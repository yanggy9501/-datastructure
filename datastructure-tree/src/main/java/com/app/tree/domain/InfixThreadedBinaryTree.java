package com.app.tree.domain;

import com.app.tree.domain.binarytree.ThreadedBinaryTreeNode;
import com.app.tree.helper.ThreadedBinaryTreeHelper;

import java.util.function.Consumer;

/**
 * 中序线索二叉树
 *
 * @author yanggy
 */
public class InfixThreadedBinaryTree <T> {

    /**
     * root 节点
     */
    private ThreadedBinaryTreeNode<T> root;

    /**
     * 中序遍历中序线索二叉树
     *
     * @param consumer 消费者
     */
    public void infixOrder(Consumer<ThreadedBinaryTreeNode<T>> consumer) {
        if (root != null) {
            ThreadedBinaryTreeHelper.infixOrder(root, consumer);
        }
    }
}
