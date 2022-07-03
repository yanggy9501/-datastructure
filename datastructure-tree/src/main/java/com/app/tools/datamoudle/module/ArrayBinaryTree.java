package com.app.tools.datamoudle.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * 顺序存储的二叉树
 *
 * @author yanggy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrayBinaryTree <T> {
    /**
     * 存储数组，从下标 0 开始存储
     */
    private ArrayList<T> data;

    /**
     * 前序遍历二叉树或二叉树的子树
     * (root + 1) * 2 = left + 1 ==> left = 2 * root +1
     * (root + 1) * 2 + 1 = right + 1 ==> right = 2 * root + 2
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
        // go left
        if ((root << 1) + 1 < data.size()) {
            preOrder(root << 1, consumer);
        }
        // go right
        if ((root << 1) + 2 < data.size()) {
            preOrder((root << 1) + 1, consumer);
        }
    }

    /**
     * 前序遍历二叉树
     *
     * @param consumer 消费者
     */
    public void preOrder(Consumer<T> consumer) {
        preOrder(0, consumer);
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
        // go left
        if ((root << 1) + 1 < data.size()) {
            preOrder(root << 1, consumer);
        }
        // visit node
        consumer.accept(data.get(root));
        // go right
        if ((root << 1) + 2 < data.size()) {
            preOrder((root << 1) + 1, consumer);
        }
    }

    /**
     * 中序遍历二叉树
     *
     * @param consumer 消费者
     */
    public void infixOrder(Consumer<T> consumer) {
        infixOrder(0, consumer);
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
        // go left
        if ((root << 1) + 1 < data.size()) {
            preOrder(root << 1, consumer);
        }
        // go right
        if (((root << 1) + 2) < data.size()) {
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
        postOrder(0, consumer);
    }
}
