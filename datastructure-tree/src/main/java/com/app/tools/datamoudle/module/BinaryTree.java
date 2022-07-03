package com.app.tools.datamoudle.module;

import com.app.tools.datamoudle.helper.BinaryTreeHelper;
import com.app.tools.datamoudle.module.binarytree.BinaryTreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Predicate;

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
     * 前序查找节点
     *
     * @param predicate 断言
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> preOrderSearch(Predicate<BinaryTreeNode<T>> predicate) {
        if (root != null) {
            BinaryTreeHelper.preOrderSearch(root, predicate);
        }
        return null;
    }

    /**
     * 中序遍历查找节点
     *
     * @param predicate 断言
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> infixOrderSearch(Predicate<BinaryTreeNode<T>> predicate) {
        if (root != null) {
            return BinaryTreeHelper.infixOrderSearch(root, predicate);
        }
        return null;
    }

    /**
     * 后序遍历
     *
     * @param predicate 断言
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> postOrderSearch(Predicate<BinaryTreeNode<T>> predicate) {
        if (root != null) {
            return BinaryTreeHelper.postOrderSearch(root, predicate);
        }
        return null;
    }

    /**
     * 删除节点及其子树
     *
     * @param predicate 比较器
     */
    public void deleteNode(Predicate<BinaryTreeNode<T>> predicate) {
        if (root == null) {
            return;
        }
        if (predicate.test(root)) {
            root = null;
            return;
        }
        BinaryTreeHelper.deleteNode(root, predicate);
    }

    /**
     * 获取树的高度
     *
     * @return tree height
     */
    public int getHeight() {
        return BinaryTreeHelper.getHeight(root);
    }
}
