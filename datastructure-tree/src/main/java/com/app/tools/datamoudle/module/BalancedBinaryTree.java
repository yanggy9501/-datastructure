package com.app.tools.datamoudle.module;

import com.app.tools.datamoudle.helper.BinaryTreeHelper;
import com.app.tools.datamoudle.module.binarytree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 平衡二叉树
 *
 * @author yanggy
 */
public class BalancedBinaryTree<T> extends BinarySortTree<T> {
    @Override
    public void add(T data, Comparator<T> comparator) {
        super.add(data, comparator);
        // 调整,如果出现不平衡节点的话，否则不操作
        mightBalance(data, comparator);
    }

    /**
     * 调整不平衡节点如果有需要
     *
     * @param data 添加节点的data域
     * @param comparator 比较器
     */
    private void mightBalance(T data, Comparator<T> comparator) {
        // 判断添加后是否是平衡二叉树（不平衡子树一定在添加节点的路径上）
        List<BinaryTreeNode<T>> visitPath = getVisitPath(data, comparator);
        // root --> node 倒序为 node --> root 以方便找第一个从叶子节点开始的不平衡子树
        Collections.reverse(visitPath);
        for (BinaryTreeNode<T> pathNode : visitPath) {
            // 判断不平衡后的旋转类型，NULL则平衡
            RotateTypeEnum rotateType = getRotateType(pathNode);
            if (rotateType.equals(RotateTypeEnum.LEFT_ROTATE)) {
                leftRotate(pathNode);
            } else if (rotateType.equals(RotateTypeEnum.RIGHT_ROTATE)) {
                rightRotate(pathNode);
            } else if (rotateType.equals(RotateTypeEnum.LEFT_RIGHT_ROTATE)){
                leftRotate(pathNode.getLeftNode());
                rightRotate(pathNode);
            } else if (rotateType.equals(RotateTypeEnum.RIGHT_LEFT_ROTATE)) {
                rightRotate(pathNode.getRightNode());
                leftRotate(pathNode);
            } else {
                // RotateTypeEnum.NULL 时继续在路径上找不平衡节点
                continue;
            }
            // 调整结束
            break;
        }
    }

    /**
     * 获取node节点旋转类型如果该节点不平衡时
     *
     * @param node 二叉树节点
     * @return RotateTypeEnum
     */
    private RotateTypeEnum getRotateType(BinaryTreeNode<T> node) {
        int leftHeight = BinaryTreeHelper.getHeight(node.getLeftNode());
        int rightHeight = BinaryTreeHelper.getHeight(node.getRightNode());
        if (rightHeight - leftHeight > 1) {
            // 若右子树高度 - 左子树高度 > 1，node左旋转
            // 进一步判断是否右子树先进行右旋，node在进行左旋，条件：node.right.left.length > node.right.right.length
            boolean rightLeftRotateFlag = BinaryTreeHelper.getHeight(node.getRightNode().getLeftNode())
                > BinaryTreeHelper.getHeight(node.getRightNode().getRightNode());
            return rightLeftRotateFlag ? RotateTypeEnum.RIGHT_LEFT_ROTATE : RotateTypeEnum.LEFT_ROTATE;
        } else if (leftHeight - rightHeight > 1) {
            // 若左子树高度 - 右子树高度 > 1，node右旋转
            // 进一步判断是否左子树先进行左旋，node在进行右旋，条件：node.left.right.length > node.left.left.length
            boolean leftRightRotateFlag = BinaryTreeHelper.getHeight(node.getLeftNode().getRightNode())
                > BinaryTreeHelper.getHeight(node.getLeftNode().getLeftNode());
            return leftRightRotateFlag ? RotateTypeEnum.LEFT_RIGHT_ROTATE : RotateTypeEnum.RIGHT_ROTATE;
        } else {
            return RotateTypeEnum.NULL;
        }

    }

    /**
     * 获取node 节点的访问路径，从根出发到node包括node节点
     *
     * @param targetNodeValue 二叉树节点的value
     * @return 访问路径
     */
    public List<BinaryTreeNode<T>> getVisitPath(T targetNodeValue, Comparator<T> comparator) {
        List<BinaryTreeNode<T>> path = new ArrayList<>(8);
        BinaryTreeNode<T> node = getRoot();
        while (node != null) {
            path.add(node);
            if (comparator.compare(targetNodeValue, node.getData()) == 0) {
                return path;
            }
            // go left or right tree
            node = comparator.compare(targetNodeValue, node.getData()) < 0 ? node.getLeftNode() : node.getRightNode();
        }
        return Collections.emptyList();
    }

    /**
     * 不平衡子树左旋操作，降低右子树高度
     * 实现：创建节点和删除节点 + 修改指针实现左旋
     * 1. new 一个新节点newNode，其值的 = root，以取代root实现其右旋，而root将被右节点替换
     * 2. 不平衡节点root先左旋，newNode.left = root.left; newNode.right = root.right.left
     * 3. 不平衡节点的右节点左旋上移，root.data = root.right.data(通过替换data值实现)
     * 4. 重新搭建root的左右子树，root.left = newNode; root.right = root.right.right
     *
     * @param root 最小不平衡子树的根
     */
    private void leftRotate(BinaryTreeNode<T> root) {
        // root --> root.left, 第一个不平衡节点左旋
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(root.getData());
        newNode.setLeftNode(root.getLeftNode());
        newNode.setRightNode(root.getRightNode().getLeftNode());
        // 不平衡节点的右节点左旋上移. root.right --> root
        root.setData(root.getRightNode().getData());
        root.setLeftNode(newNode);
        root.setRightNode(root.getRightNode().getRightNode());
    }

    /**
     * 不平衡子树右旋操作，降低左子树高度
     * 实现同：{@link #leftRotate}
     *
     * @param root 最小不平衡子树的根
     */
    private void rightRotate(BinaryTreeNode<T> root) {
        // root --> root.right, 第一个不平衡节点右旋
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(root.getData());
        newNode.setRightNode(root.getRightNode());
        newNode.setLeftNode(root.getLeftNode().getRightNode());
        // 不平衡节点的左节点右旋上移. root.left --> root
        root.setData(root.getLeftNode().getData());
        root.setRightNode(newNode);
        root.setLeftNode(root.getLeftNode().getLeftNode());
    }

    /**
     * 平衡二叉树节点旋转类型
     */
    public enum RotateTypeEnum {
        LEFT_ROTATE,
        RIGHT_ROTATE,
        LEFT_RIGHT_ROTATE,
        RIGHT_LEFT_ROTATE,
        NULL
    }
}
