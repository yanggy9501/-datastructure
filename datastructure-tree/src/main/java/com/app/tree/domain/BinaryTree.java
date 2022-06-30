package com.app.tree.domain;

import com.app.tree.domain.binarytree.BinaryTreeNode;
import com.app.tree.helper.BinaryTreeHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 二叉树实体
 * 一颗二叉树有 0 个或多个二叉树节点 BinaryTreeNode 组成
 *
 * @author yanggy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinaryTree<T> {

    /**
     * 二叉树根节点
     */
    private BinaryTreeNode<T> root;

    /**
     * 前序遍历
     *
     * @param consumer 消费者
     */
    public void preOrder(Consumer<BinaryTreeNode<T>> consumer) {
        if (root != null) {
            BinaryTreeHelper.preOrder(root, consumer);
        }
    }

    /**
     * 中序遍历
     *
     * @param consumer 消费者
     */
    public void infixOrder(Consumer<BinaryTreeNode<T>> consumer) {
        if (root != null) {
            BinaryTreeHelper.infixOrder(root, consumer);
        }
    }

    /**
     * 后序遍历
     *
     * @param consumer 消费者
     */
    public void postOrder(Consumer<BinaryTreeNode<T>> consumer) {
        if (root != null) {
            BinaryTreeHelper.postOrder(root, consumer);
        }
    }

    /**
     * 前序遍历
     *
     * @param node 待查找节点
     * @param comparator 比较器
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> preOrderSearch(BinaryTreeNode<T> node, Comparator<BinaryTreeNode<T>> comparator) {
        if (root != null) {
            return BinaryTreeHelper.preOrderSearch(node, root, comparator);
        }
        return null;
    }

    /**
     * 中序遍历
     *
     * @param node 待查找节点
     * @param comparator 比较器
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> infixOrderSearch(BinaryTreeNode<T> node, Comparator<BinaryTreeNode<T>> comparator) {
        if (root != null) {
            return BinaryTreeHelper.infixOrderSearch(node, root, comparator);
        }
        return null;
    }

    /**
     * 后序遍历
     *
     * @param node 待查找节点
     * @param comparator 比较器
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> postOrderSearch(BinaryTreeNode<T> node, Comparator<BinaryTreeNode<T>> comparator) {
        if (root != null) {
            return BinaryTreeHelper.postOrderSearch(node, root, comparator);
        }
        return null;
    }

    /**
     * 删除节点及其子树
     *
     * @param node 待删除节点
     * @param comparator 比较器
     */
    public void deleteNode(BinaryTreeNode<T> node, Comparator<BinaryTreeNode<T>> comparator) {
        if (root == null) {
            return;
        }
        if (BinaryTreeHelper.isEquals(node, root, comparator)) {
            root = null;
            return;
        }
        BinaryTreeHelper.deleteNode(node, root, comparator);
    }
}
