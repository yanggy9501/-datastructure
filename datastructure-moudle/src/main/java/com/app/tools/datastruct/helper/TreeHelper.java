package com.app.tools.datastruct.helper;


import com.app.tools.datastruct.module.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tree 工具类
 *
 * @author yanggy
 */
public class TreeHelper {
    /**
     * 构建树
     *
     * @param collect  数据集合
     * @param nodeRelationPredicate 节点关系，实现两个方法以判断节点是root，以及判断两个节点的关系
     * @param comparator 比较器，用于节点排序
     * @return TreeNode 树
     */
    public static <T> List<TreeNode<T>> buildTree(List<T> collect, NodeRelationPredicate<T> nodeRelationPredicate,
        Comparator<TreeNode<T>> comparator) {
        List<TreeNode<T>> treeNodeList = collect.stream().map(TreeNode::new).collect(Collectors.toList());
        return buildTree(treeNodeList, comparator, nodeRelationPredicate);
    }

    /**
     * 构建树
     *
     * @param collect TreeNode 集合
     * @param comparator 比较器，用于节点排序
     * @param nodeRelationPredicate 节点关系，实现两个方法以判断节点是root，以及判断两个节点的关系
     * @return TreeNode 树
     */
    private static <T> List<TreeNode<T>> buildTree(List<TreeNode<T>> collect, Comparator<TreeNode<T>> comparator,
        NodeRelationPredicate<T> nodeRelationPredicate) {
        List<TreeNode<T>> treeNodeList = new ArrayList<>();
        if (collect == null || collect.size() == 0) {
            return Collections.emptyList();
        }
        for (TreeNode<T> node : collect) {
            // 判断是否为第一层节点
            if (nodeRelationPredicate.isRootNode(node.getData())) {
                buildChildrenNode(node, collect, comparator, nodeRelationPredicate);
                treeNodeList.add(node);
            }
        }
        treeNodeList.sort(comparator);
        return treeNodeList;
    }

    /**
     * 递归构建孩子节点
     *
     * @param parentNode 父节点
     * @param collect TreeNode 集合
     * @param comparator TreeNode 比较器，比较两个节点是否时父子关系。0：父子关系
     */
    private static <T> void buildChildrenNode(TreeNode<T> parentNode, List<TreeNode<T>> collect,
        Comparator<TreeNode<T>> comparator, NodeRelationPredicate<T> nodeRelationPredicate) {
        List<TreeNode<T>> children = new ArrayList<>();
        for (TreeNode<T> node : collect) {
            if (nodeRelationPredicate.isParentChildRelation(node.getData(), parentNode.getData())) {
                buildChildrenNode(node, collect, comparator, nodeRelationPredicate);
                children.add(node);
            }
        }
        if (children.size() > 0) {
            children.sort(comparator);
            parentNode.setChildren(children);
        }
    }

    /**
     * 节点关系抽象类
     *
     * @param <T> 节点的数据域泛型
     */
    public interface NodeRelationPredicate<T> {

        /**
         * 判断当前data是否是第一层节点的data
         *
         * @param node 当前节点
         * @return boolean
         */
        boolean isRootNode(T node);

        /**
         * 判断两个节点是否是父子关系
         *
         * @param node 当前节点
         * @param mightParentNode 可能的父节点
         * @return boolean
         */
        boolean isParentChildRelation(T node, T mightParentNode);
    }
}
