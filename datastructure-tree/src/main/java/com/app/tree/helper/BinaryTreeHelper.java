package com.app.tree.helper;

import com.app.tree.domain.BinaryTree;
import com.app.tree.domain.binarytree.BinaryTreeNode;

import java.util.Comparator;
import java.util.function.Consumer;

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
     * @param node 待查找节点
     * @param root 根节点
     * @param comparator 比较器
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> preOrderSearch(BinaryTreeNode<T> node, BinaryTreeNode<T> root,
        Comparator<BinaryTreeNode<T>> comparator) {
        if (comparator.compare(node, root) == 0) {
            return root;
        }
        BinaryTreeNode<T> resultNode = null;
        if (root.getLeftNode() != null) {
            resultNode = preOrderSearch(node, root.getLeftNode(), comparator);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (root.getRightNode() != null) {
            resultNode = preOrderSearch(node, root.getRightNode(), comparator);
        }
        return resultNode;
    }

    /**
     * 前序遍历查找二叉树的某个节点
     *
     * @param node 待查找节点
     * @param binaryTree 二叉树
     * @param comparator 比较器
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> preOrderSearch(BinaryTreeNode<T> node, BinaryTree<T> binaryTree,
        Comparator<BinaryTreeNode<T>> comparator) {
        return preOrderSearch(node, binaryTree.getRoot(), comparator);
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
     * @param node 待查找节点
     * @param root 根节点
     * @param comparator 比较器
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> infixOrderSearch(BinaryTreeNode<T> node, BinaryTreeNode<T> root,
        Comparator<BinaryTreeNode<T>> comparator) {
        BinaryTreeNode<T> resultNode = null;
        if (root.getLeftNode() != null) {
            resultNode = infixOrderSearch(node, root.getLeftNode(), comparator);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (comparator.compare(node, root) == 0) {
            return root;
        }
        if (root.getRightNode() != null) {
            resultNode = infixOrderSearch(node, root.getRightNode(), comparator);
        }
        return resultNode;
    }

    /**
     * 中序遍历查找二叉树的某个节点。
     *
     * @param node 待查找节点
     * @param binaryTree 二叉树
     * @param comparator 比较器
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> infixOrderSearch(BinaryTreeNode<T> node, BinaryTree<T> binaryTree,
        Comparator<BinaryTreeNode<T>> comparator) {
        return infixOrderSearch(node, binaryTree.getRoot(), comparator);
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
     * @param node 待查找节点
     * @param root 根节点
     * @param comparator 比较器
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> postOrderSearch(BinaryTreeNode<T> node, BinaryTreeNode<T> root,
        Comparator<BinaryTreeNode<T>> comparator) {
        BinaryTreeNode<T> resultNode = null;
        if (root.getLeftNode() != null) {
            resultNode = postOrderSearch(node, root.getLeftNode(), comparator);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (root.getRightNode() != null) {
            resultNode = postOrderSearch(node, root.getRightNode(), comparator);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (comparator.compare(node, root) == 0) {
            return root;
        }
        return null;
    }

    /**
     * 后序遍历查找二叉树的某个节点
     *
     * @param node 待查找节点
     * @param binaryTree 二叉树
     * @param comparator 比较器
     * @param <T> 数据泛型
     * @return BinaryTreeNode<T> 树的节点
     */
    public static <T> BinaryTreeNode<T> postOrderSearch(BinaryTreeNode<T> node, BinaryTree<T> binaryTree,
        Comparator<BinaryTreeNode<T>> comparator) {
        return postOrderSearch(node, binaryTree.getRoot(), comparator);
    }

    /**
     * 后序删除符合条件的所有节点及其子树
     * 1.二叉树是单向的，无法删除当前节点，需转为是否需要删除当前节点的子节点
     * 2.如果当前节点左节点不为 null 且是待删除节点，则删除，否就递归左子树
     * 3.如果当前节点右节点不为 null 且是待删除节点，则删除，否就递归右子树
     *
     * @param node 待查找节点
     * @param root 根节点
     * @param comparator 比较器
     * @param <T> 数据泛型
     */
    public static <T> void deleteNode(BinaryTreeNode<T> node, BinaryTreeNode<T> root,
        Comparator<BinaryTreeNode<T>> comparator) {
        if (root.getLeftNode() != null && isEquals(node, root.getLeftNode(), comparator)){
            // delete node
            root.setLeftNode(null);
        }
        if (root.getRightNode() != null && isEquals(node, root.getRightNode(), comparator)){
            // delete node
            root.setRightNode(null);
        }
        if (root.getLeftNode() != null) {
            deleteNode(node, root.getLeftNode(), comparator);
        }
        if (root.getRightNode() != null) {
            deleteNode(node, root.getRightNode(), comparator);
        }
    }

    /**
     * 后序删除符合条件的所有节点及其子树
     *
     * @param node 待查找节点
     * @param binaryTree 二叉树
     * @param comparator 比较器
     * @param <T> 数据泛型
     */
    public static <T> void deleteNode(BinaryTreeNode<T> node, BinaryTree<T> binaryTree,
        Comparator<BinaryTreeNode<T>> comparator) {
        deleteNode(node, binaryTree.getRoot(), comparator);
    }

    // ******************************************************** 其他处理 ************************************************/

    /**
     * 判断两个节点是否相等
     *
     * @param node1 节点1
     * @param node2 节点2
     * @param comparator 比较器
     * @param <T> 数据泛型
     */
    public static <T> boolean isEquals(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2,
        Comparator<BinaryTreeNode<T>> comparator) {
        return comparator.compare(node1, node2) == 0;
    }
}
