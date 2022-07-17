package com.app.tools.datamoudle.module;

import com.app.tools.datamoudle.module.binarytree.BinaryTreeNode;
import com.app.tools.datamoudle.helper.BinaryTreeHelper;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 二叉排序树
 *
 * @author yanggy
 */
@Getter
@Setter
public class BinarySortTree<T> extends BinaryTree<T> {
    /**
     * 比较器
     */
    private Comparator<T> comparator;

    public BinarySortTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public BinarySortTree(BinaryTreeNode<T> root, Comparator<T> comparator) {
        super(root);
        this.comparator = comparator;
    }

    /**
     * 添加节点二叉排序数中
     *
     * @param data 数据
     */
   public void add(T data) {
       BinaryTreeNode<T> node = new BinaryTreeNode<>(data);
       // 遍历指针
       BinaryTreeNode<T> currentNode = getRoot();
       if (currentNode == null) {
           setRoot(node);
           return;
       }
       // currentNode 的前驱
       BinaryTreeNode<T> preNode = null;
       // 找 node 的位置，preNode保存前驱
       while (currentNode != null) {
           preNode = currentNode;
           // 小于等于走左边，否则右边
           currentNode = comparator.compare(data, currentNode.getData()) <= 0 ?
               currentNode.getLeftNode() : currentNode.getRightNode();
       }
       // 添加node到叶子节点
       if (comparator.compare(data, preNode.getData()) <= 0) {
           preNode.setLeftNode(node);
       } else {
           preNode.setRightNode(node);
       }
   }


    /**
     * 添加节点二叉排序数中
     *
     * @param dataList 数据集合
     */
   public void add(List<T> dataList) {
       dataList.forEach(this::add);
   }

    /**
     * 删除二叉排序数的节点
     *
     * @param targetValue 待删除节点值
     */
   public void deleteSortedTreeNode(T targetValue) {
       BinaryTreeNode<T> targetNode = search(targetValue);
       if (targetNode == null) {
           return;
       }
       BinaryTreeNode<T> parentNode = searchParentNode(targetNode);
       if (BinaryTreeHelper.isLeafNode(targetNode)) {
            // 若targetNode 是叶子节点
           deleteLeafNode(targetNode, parentNode);
       } else if (BinaryTreeHelper.hasTwoBranch(targetNode)) {
           // 若targetNode 度为2
           deleteDoubleBranchNode(targetNode);
       } else {
           // 若targetNode 度为1
           deleteSingleBranchNode(targetNode, parentNode);
       }
   }

    /**
     * 删除targetNode 叶子节点
     *
     * @param targetNode 叶子节点
     * @param parentNode targetNode的父节点
     */
   private void deleteLeafNode(BinaryTreeNode<T> targetNode, BinaryTreeNode<T> parentNode) {
       // root.parent == parentNode == null 的处理（parentNode == null，则targetNode是root节点）.
       if (parentNode == null) {
           // delete root
           setRoot(null);
           return;
       }
       // 判断targetNode是parentNode左或右节点
       if (parentNode.getLeftNode() == targetNode) {
           parentNode.setLeftNode(null);
       } else {
           parentNode.setRightNode(null);
       }
   }

    /**
     * 删除只有一个分支的节点
     *
     * @param singleBranchNode delete的目标节点
     * @param parentNode targetNode的父节点
     */
   private void deleteSingleBranchNode(BinaryTreeNode<T> singleBranchNode, BinaryTreeNode<T> parentNode) {
        // root.parent == parentNode == null 的处理（parentNode == null，则targetNode是root节点）.
       if (parentNode == null) {
           if (singleBranchNode.getLeftNode() != null) {
               setRoot(singleBranchNode.getLeftNode());
           } else {
               setRoot(singleBranchNode.getRightNode());
           }
           return;
       }
       // 判断targetNode 是parentNode左节点还是右节点
       if (parentNode.getLeftNode() == singleBranchNode) {
           // 判断targetNode的分支是左还是右
           if (singleBranchNode.getLeftNode() != null) {
               parentNode.setLeftNode(singleBranchNode.getLeftNode());
           } else {
               parentNode.setLeftNode(singleBranchNode.getRightNode());
           }
       } else {
           // 判断targetNode的分支是左还是右
           if (singleBranchNode.getLeftNode() != null) {
               parentNode.setRightNode(singleBranchNode.getLeftNode());
           } else {
               parentNode.setRightNode(singleBranchNode.getRightNode());
           }
       }
   }

    /**
     * 删除度为2的节点，以左节点最右边的最大值的节点替换（注意该最大值的节点右左分支）
     *
     * @param doubleBranchNode 度为2的节点
     */
    private void deleteDoubleBranchNode(BinaryTreeNode<T> doubleBranchNode) {
        BinaryTreeNode<T> replaceNode = doubleBranchNode.getLeftNode();
        // replaceNode 的parentNode
        BinaryTreeNode<T> parentNode = doubleBranchNode;
        while (replaceNode.getRightNode() != null) {
            parentNode = replaceNode;
            replaceNode = replaceNode.getRightNode();
        }
        // 左节点最右边的节点. 1：叶子节点；2：单分支节点
        if (BinaryTreeHelper.isLeafNode(replaceNode)) {
            // 若replaceNode 是叶子节点
            deleteLeafNode(replaceNode, parentNode);
        } else {
            // 若replaceNode 是单分支节点
            deleteSingleBranchNode(replaceNode, parentNode);
        }
        doubleBranchNode.setData(replaceNode.getData());
    }

    /**
     * 二叉树删除与二叉排序树删除有区别，二叉排序树禁用删除二叉树的deleteNode方法
     *
     * @param predicate 比较器
     */
    @Deprecated
    @Override
    public void deleteNode(Predicate<BinaryTreeNode<T>> predicate) {
        super.deleteNode(predicate);
    }

    /**
     * 二叉排序数的中序查找（覆写并弃用）
     * 在有序的情况下，采用全部遍历不可取
     *
     * @param predicate 断言
     * @return BinaryTreeNode<T>
     */
    @Deprecated
    @Override
    public BinaryTreeNode<T> infixOrderSearch(Predicate<BinaryTreeNode<T>> predicate) {
        return super.infixOrderSearch(predicate);
    }

    /**
     * 查找符合条件value 的节点
     *
     * @param targetValue 条件值
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> search(T targetValue) {
        BinaryTreeNode<T> node = getRoot();
        while (node != null) {
            // equals
            if (comparator.compare(targetValue, node.getData()) == 0) {
                return node;
            }
            // go left or right tree
            node = comparator.compare(targetValue, node.getData()) < 0 ? node.getLeftNode() : node.getRightNode();
        }
        // not find
        return null;
    }

    /**
     * 查找 targetNode 节点的父节点
     *
     * @param targetNode targetNode必须尾BinarySortTree中的节点
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> searchParentNode(BinaryTreeNode<T> targetNode) {
        if (targetNode == null) {
            return null;
        }
        BinaryTreeNode<T> tempNode = getRoot();
        while (tempNode != null) {
            // equals
            if (tempNode.getLeftNode() == targetNode || tempNode.getRightNode() == targetNode) {
                return tempNode;
            }
            // go left or right tree
            tempNode = comparator.compare(targetNode.getData(), tempNode.getData()) < 0 ?
                tempNode.getLeftNode() : tempNode.getRightNode();
        }
        return null;
    }

    /**
     * 查找 targetValue == node.getData 节点的父节点
     *
     * @param targetValue 目标节点的值
     * @return BinaryTreeNode<T>
     */
    public BinaryTreeNode<T> searchParentNode(T targetValue) {
        if (targetValue == null) {
            return null;
        }
        BinaryTreeNode<T> tempNode = getRoot();
        while (tempNode != null) {
            // equals
            if (comparator.compare(targetValue, tempNode.getLeftNode().getData()) == 0
                || comparator.compare(targetValue, tempNode.getRightNode().getData()) == 0) {
                return tempNode;
            }
            // go left or right tree
            tempNode = comparator.compare(targetValue, tempNode.getData()) < 0 ?
                tempNode.getLeftNode() : tempNode.getRightNode();
        }
        return null;
    }
}
