package com.app.tree.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * 顺序存储的二叉树
 * 一般存储完成二叉树，存储下标从 1 开始。
 *
 * @author yanggy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrayBinaryTree <T> {
    /**
     * 存储数组，从下标 1 开始存储
     */
    private ArrayList<T> data;

    /**
     * 前序遍历二叉树或二叉树的子树
     *
     * @param root 二叉树或子树的根
     * @param consumer 消费者
     */
    public void preOrder(int root, Consumer<T> consumer) {
        if (data == null || data.isEmpty()) {
            return;
        }
        // visit node
        consumer.accept(data.get(root));
        if ((root << 1) < data.size()) {
            preOrder(root << 1, consumer);
        }

        if (((root << 1) + 1) < data.size()) {
            preOrder((root << 1) + 1, consumer);
        }
    }

    /**
     * 前序遍历二叉树
     *
     * @param consumer 消费者
     */
    public void preOrder(Consumer<T> consumer) {
        preOrder(1, consumer);
    }

    /**
     * 中序遍历二叉树或二叉树的子树
     *
     * @param root 叉树或子树的根
     * @param consumer 消费者
     */
    public void infixOrder(int root, Consumer<T> consumer) {
        if (data == null || data.isEmpty()) {
            return;
        }

        if ((root << 1) < data.size()) {
            preOrder(root << 1, consumer);
        }
        // visit node
        consumer.accept(data.get(root));
        if (((root << 1) + 1) < data.size()) {
            preOrder((root << 1) + 1, consumer);
        }
    }

    /**
     * 中序遍历二叉树
     *
     * @param consumer 消费者
     */
    public void infixOrder(Consumer<T> consumer) {
        infixOrder(1, consumer);
    }

    /**
     * 后序遍历二叉树或二叉树的子树
     *
     * @param root 叉树或子树的根
     * @param consumer 消费者
     */
    public void postOrder(int root, Consumer<T> consumer) {
        if (data == null || data.isEmpty()) {
            return;
        }

        if ((root << 1) < data.size()) {
            preOrder(root << 1, consumer);
        }
        if (((root << 1) + 1) < data.size()) {
            preOrder((root << 1) + 1, consumer);
        }
        // visit node
        consumer.accept(data.get(root));
    }

    /**
     * 后序遍历二叉树
     *
     * @param consumer 消费者
     */
    public void postOrder(Consumer<T> consumer) {
        postOrder(1, consumer);
    }
}
