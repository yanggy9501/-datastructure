package com.app.tree.helper;

import com.app.tree.module.BinaryTree;
import com.app.tree.module.binarytree.BinaryTreeNode;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 二叉树工具类
 *
 * @author yanggy
 */
public class BinaryTreeHelper {
    // ******************************************************** 前序处理 *************************************************
    /**
     * 前序遍历
     *
     * @param root "root"节点
     * @param consumer 节点的消费者
     */
    public static <T> void preOrder(BinaryTreeNode<T> root, Consumer<BinaryTreeNode<T>> consumer) {
        consumer.accept(root);
        if (root.getLeftNode() != null) {
            preOrder(root.getLeftNode(), consumer);
        }
        if (root.getRightNode() != null) {
            preOrder(root.getRightNode(), consumer);
        }
    }

    /**
     * 前序遍历
     *
     * @param binaryTree 二叉树
     * @param consumer 节点的消费者
     */
    public static <T>  void preOrder(BinaryTree<T> binaryTree, Consumer<BinaryTreeNode<T>> consumer) {
        preOrder(binaryTree.getRoot(), consumer);
    }

    /**
     * 前序遍历查找二叉树的某个节点
     *
     * @param root 根节点
     * @param predicate 断言
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> preOrderSearch(BinaryTreeNode<T> root, Predicate<BinaryTreeNode<T>> predicate) {
        if (predicate.test(root)) {
            return root;
        }
        BinaryTreeNode<T> resultNode = null;
        if (root.getLeftNode() != null) {
            resultNode = preOrderSearch(root.getLeftNode(), predicate);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (root.getRightNode() != null) {
            resultNode = preOrderSearch(root.getRightNode(), predicate);
        }
        return resultNode;
    }

    /**
     * 前序遍历查找二叉树的某个节点
     *
     * @param binaryTree 二叉树
     * @param predicate 断言
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> preOrderSearch(BinaryTree<T> binaryTree,
        Predicate<BinaryTreeNode<T>> predicate) {
        return preOrderSearch(binaryTree.getRoot(), predicate);
    }

    // ******************************************************** 中序处理 ************************************************/

    /**
     * 中序遍历
     *
     * @param root "root"节点
     * @param consumer 节点的消费者
     */
    public static <T> void infixOrder(BinaryTreeNode<T> root, Consumer<BinaryTreeNode<T>> consumer) {
        if (root.getLeftNode() != null) {
            infixOrder(root.getLeftNode(), consumer);
        }
        consumer.accept(root);
        if (root.getRightNode() != null) {
            infixOrder(root.getRightNode(), consumer);
        }
    }

    /**
     * 中序遍历
     *
     * @param binaryTree 二叉树
     * @param consumer 节点的消费者
     */
    public static <T> void infixOrder(BinaryTree<T> binaryTree,  Consumer<BinaryTreeNode<T>> consumer) {
        infixOrder(binaryTree.getRoot(), consumer);
    }

    /**
     * 中序遍历查找二叉树的某个节点
     *
     * @param root 根节点
     * @param predicate 断言
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> infixOrderSearch(BinaryTreeNode<T> root,
        Predicate<BinaryTreeNode<T>> predicate) {
        BinaryTreeNode<T> resultNode = null;
        if (root.getLeftNode() != null) {
            resultNode = infixOrderSearch(root.getLeftNode(), predicate);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (predicate.test(root)) {
            return root;
        }
        if (root.getRightNode() != null) {
            resultNode = infixOrderSearch(root.getRightNode(), predicate);
        }
        return resultNode;
    }

    /**
     * 中序遍历查找二叉树的某个节点。
     *
     * @param binaryTree 二叉树
     * @param predicate 断言
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> infixOrderSearch(BinaryTree<T> binaryTree,
        Predicate<BinaryTreeNode<T>> predicate) {
        return infixOrderSearch(binaryTree.getRoot(), predicate);
    }

    // ******************************************************** 后序处理 ************************************************/

    /**
     * 后序遍历
     *
     * @param root "root"节点
     * @param consumer 节点的消费者
     */
    public static <T> void postOrder(BinaryTreeNode<T> root, Consumer<BinaryTreeNode<T>> consumer) {
        if (root.getLeftNode() != null) {
            postOrder(root.getLeftNode(), consumer);
        }
        if (root.getRightNode() != null) {
            postOrder(root.getRightNode(), consumer);
        }
        consumer.accept(root);
    }

    /**
     * 后序遍历
     *
     * @param binaryTree 二叉树
     * @param consumer 节点的消费者
     */
    public static <T> void postOrder(BinaryTree<T> binaryTree, Consumer<BinaryTreeNode<T>> consumer) {
        postOrder(binaryTree.getRoot(), consumer);
    }

    /**
     * 后序遍历查找二叉树的某个节点
     *
     * @param root 根节点
     * @param predicate 断言
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> postOrderSearch(BinaryTreeNode<T> root,
        Predicate<BinaryTreeNode<T>> predicate) {
        BinaryTreeNode<T> resultNode = null;
        if (root.getLeftNode() != null) {
            resultNode = postOrderSearch(root.getLeftNode(), predicate);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (root.getRightNode() != null) {
            resultNode = postOrderSearch(root.getRightNode(), predicate);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (predicate.test(root)) {
            return root;
        }
        return null;
    }

    /**
     * 后序遍历查找二叉树的某个节点
     *
     * @param binaryTree 二叉树
     * @param predicate 断言
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> postOrderSearch(BinaryTree<T> binaryTree,
        Predicate<BinaryTreeNode<T>> predicate) {
        return postOrderSearch(binaryTree.getRoot(), predicate);
    }

    /**
     * 后序删除符合条件的所有二叉树节点及其子树
     * 1.二叉树是单向的，无法删除当前节点，需转为是否需要删除当前节点的子节点
     * 2.如果当前节点左节点不为 null 且是待删除节点，则删除，否就递归左子树
     * 3.如果当前节点右节点不为 null 且是待删除节点，则删除，否就递归右子树
     *
     * @param root 根节点
     * @param predicate 断言
     * @param <T> 数据泛型
     */
    public static <T> void deleteNode(BinaryTreeNode<T> root, Predicate<BinaryTreeNode<T>> predicate) {
        if (root.getLeftNode() != null && predicate.test(root.getLeftNode())){
            // delete left node
            root.setLeftNode(null);
        }
        if (root.getRightNode() != null && predicate.test(root.getLeftNode())){
            // delete right node
            root.setRightNode(null);
        }
        if (root.getLeftNode() != null) {
            deleteNode(root.getLeftNode(), predicate);
        }
        if (root.getRightNode() != null) {
            deleteNode(root.getRightNode(), predicate);
        }
    }

    /**
     * 后序删除符合条件的所有节点及其子树
     *
     * @param binaryTree 二叉树
     * @param predicate 断言
     * @param <T> 数据泛型
     */
    public static <T> void deleteNode(BinaryTree<T> binaryTree, Predicate<BinaryTreeNode<T>> predicate) {
        deleteNode(binaryTree.getRoot(), predicate);
    }

    // ******************************************************** 其他处理 ************************************************/

    /**
     * 判断 node 节点是否是叶子节点
     *
     * @param node 节点
     * @return boolean
     */
    public static <T> boolean isLeafNode(BinaryTreeNode<T> node) {
        return node != null && node.getLeftNode() == null && node.getRightNode() == null;
    }

    /**
     * 判断节点的度|分支是否为 2
     *
     * @param node 节点
     * @return boolean
     */
    public static <T> boolean hasTwoBranch(BinaryTreeNode<T> node) {
        return node != null && node.getLeftNode() != null && node.getRightNode() != null;
    }
}