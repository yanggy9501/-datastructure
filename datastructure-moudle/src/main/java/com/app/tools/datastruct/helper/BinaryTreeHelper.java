package com.app.tools.datastruct.helper;

import com.app.tools.datastruct.datamodule.BinaryTree;
import com.app.tools.datastruct.datamodule.LinkedQueue;
import com.app.tools.datastruct.datamodule.binarytree.BinaryTreeNode;

import java.util.Comparator;
import java.util.List;
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
     * @param binaryTree 二叉树
     * @param consumer 节点的消费者
     */
    public static <T>  void preOrder(BinaryTree<T> binaryTree, Consumer<BinaryTreeNode<T>> consumer) {
        preOrder(binaryTree.getRoot(), consumer);
    }

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

    // ******************************************************** 中序处理 ************************************************/

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

    // ******************************************************** 后序处理 ************************************************/

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

    // ******************************************************** 层次处理 ************************************************/

    /**
     * 层次遍历
     *
     * @param binaryTree 二叉树
     * @param consumer 节点的消费者
     */
    public static <T> void levelOrder(BinaryTree<T> binaryTree, Consumer<BinaryTreeNode<T>> consumer) {
        levelOrder(binaryTree.getRoot(), consumer);
    }
    /**
     * 层次遍历
     *
     * @param root "root"节点
     * @param consumer 节点的消费者
     */
    public static <T> void levelOrder(BinaryTreeNode<T> root, Consumer<BinaryTreeNode<T>> consumer) {
        LinkedQueue<BinaryTreeNode<T>> queue = new LinkedQueue<>();
        BinaryTreeNode<T> node;
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            consumer.accept(node);
            if (node.getLeftNode() != null) {
                queue.enqueue(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.enqueue(node.getRightNode());
            }
        }
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
    public static <T> void remove(BinaryTreeNode<T> root, Predicate<BinaryTreeNode<T>> predicate) {
        if (root.getLeftNode() != null && predicate.test(root.getLeftNode())){
            // delete left node
            root.setLeftNode(null);
        }
        if (root.getRightNode() != null && predicate.test(root.getRightNode())){
            // delete right node
            root.setRightNode(null);
        }
        if (root.getLeftNode() != null) {
            remove(root.getLeftNode(), predicate);
        }
        if (root.getRightNode() != null) {
            remove(root.getRightNode(), predicate);
        }
    }

    /**
     * 后序删除符合条件的所有节点及其子树
     *
     * @param binaryTree 二叉树
     * @param predicate 断言
     * @param <T> 数据泛型
     */
    public static <T> void remove(BinaryTree<T> binaryTree, Predicate<BinaryTreeNode<T>> predicate) {
        remove(binaryTree.getRoot(), predicate);
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

    /**
     * 获取二叉树中的BinaryTreeNode节点的高度
     * 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数
     * 实现：node的高度 = Max(左子树高度, 右子树高度) + 1
     *
     * @param node 二叉树中的BinaryTreeNode节点
     * @return height
     */
    public static <T> int getHeight(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.getLeftNode()) + 1, getHeight(node.getRightNode()) + 1);
    }

    /**
     * 获取二叉树的高度
     *
     * @param binaryTree 二叉树
     * @return height
     */
    public static <T> int getHeight(BinaryTree<T> binaryTree) {
        return getHeight(binaryTree.getRoot());
    }

    /**
     * 获取node 节点的访问路径，从根出发到node包括node节点
     *
     * @param node 二叉树节点
     * @return 访问路径
     */
    public static <T> List<BinaryTreeNode<T>> getVisitPath(BinaryTreeNode<T> node, BinaryTreeNode<T> root,
        Comparator<T> comparator) {

        return null;
    }

    /**
     * 判断 node节点为子树的root的子树否是平衡的
     *
     * @param node 二叉树节点
     * @return boolean，true为平衡子树
     */
    public static <T> boolean isBalance(BinaryTreeNode<T> node) {
        if (node == null) {
            return true;
        }
        // 判断孩子节点是否平衡，否则返回false，是还要判断当前节点是否平衡
        if (!isBalance(node.getLeftNode()) || !isBalance(node.getRightNode())) {
            return false;
        }
        // 判断节点是否是平衡的
        return Math.abs(getHeight(node.getLeftNode()) - getHeight(node.getRightNode())) < 2;
    }

    /**
     * 判断二叉树否是平衡
     *
     * @param binaryTree 二叉树
     * @return boolean，true为平衡子树
     */
    public static <T> boolean isBalance(BinaryTree<T> binaryTree) {
        return isBalance(binaryTree.getRoot());
    }
}