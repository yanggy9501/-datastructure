package com.app.tools.datamoudle.helper;

import com.app.tools.datamoudle.module.binarytree.ThreadedBinaryTreeNode;

import java.util.function.Consumer;

/**
 * 线索化二叉树工具类
 *
 * @author yanggy
 */
public class ThreadedBinaryTreeHelper {
    /**
     * 中序线索化二叉树实现
     * 线索化时，前驱和后继的指针的搭建时preNode节点搭建后继，当前节点 currentNode 搭建前驱
     *
     * @param preNodeContainer 前驱指针（使用容器保证在整个递归过程中前驱可见）
     * @param currentNode 当前节点
     * @param <T> 泛型
     */
    private static <T> void doInfixOrderThread(ThreadLocal<ThreadedBinaryTreeNode<T>> preNodeContainer,
        ThreadedBinaryTreeNode<T> currentNode) {
        if (currentNode == null) {
            return;
        }
        // thread left child tree
        doInfixOrderThread(preNodeContainer, currentNode.getLeftNode());

        // current node point pre node if current node left is null
        if (currentNode.getLeftNode() == null) {
            currentNode.setLeftNode(preNodeContainer.get());
            currentNode.setLeftType(ThreadedBinaryTreeNode.PointType.PRE_OR_PSOT_POINT);
        }
        // pre node point post node if pre node right is null. firstly preNode is null
        if (preNodeContainer.get() != null && preNodeContainer.get().getRightNode() == null) {
            preNodeContainer.get().setRightNode(currentNode);
            preNodeContainer.get().setRightType(ThreadedBinaryTreeNode.PointType.PRE_OR_PSOT_POINT);
        }
        preNodeContainer.set(currentNode);
        // thread right child tree
        doInfixOrderThread(preNodeContainer, currentNode.getRightNode());
    }

    /**
     * 中序线索化二叉树
     *
     * @param root root节点
     */
    public static <T> void infixOrderThread(ThreadedBinaryTreeNode<T> root) {
        // 使用容器保存前驱
        ThreadLocal<ThreadedBinaryTreeNode<T>> preNodeContainer = ThreadLocal.withInitial(() -> null);
        try {
            doInfixOrderThread(preNodeContainer, root);
        } finally {
            preNodeContainer.remove();
        }
    }

    /**
     * 中序遍历中序线索二叉树
     *
     * @param root "root"节点
     * @param <T> data域 泛型
     */
    public static <T> void infixOrder(ThreadedBinaryTreeNode<T> root, Consumer<ThreadedBinaryTreeNode<T>> consumer) {
        // 遍历指针，存储当前遍历节点
        ThreadedBinaryTreeNode<T> node = root;
        while (node != null) {
            // 遍历找到最左边的节点即中序遍历“第一个”节点，一个树或子树第一个访问的节点是最左边的叶子节点
            while (node.getLeftType().equals(ThreadedBinaryTreeNode.PointType.CHILDREN_POINT)) {
                node = node.getLeftNode();
            }
            consumer.accept(node);
            // 遍历 “root”
            while (node.getRightType().equals(ThreadedBinaryTreeNode.PointType.PRE_OR_PSOT_POINT)) {
                node = node.getRightNode();
                // 根节点左子树的最右边的叶子节点的右指针指向该子树的root
                consumer.accept(node);
            }
            // 遍历右子树
            node = node.getRightNode();
        }
    }
}
