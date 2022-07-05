package com.app.tools.datamoudle.test;

import com.app.tools.datamoudle.module.BinarySortTree;
import org.junit.Test;

import java.util.Comparator;

/**
 * @author yanggy
 */
public class BinarySortTreeTest {
    /*
                    5
                  /     \
                1        10
              /   \     /   \
            -5     3    9    11
                    \
                     4
     */

    private BinarySortTree<Integer> createBinarySortTree() {
        BinarySortTree<Integer> binarySortTree = new BinarySortTree<>();
        Comparator<Integer> comparator = Integer::compare;
        binarySortTree.add(5, comparator);
        binarySortTree.add(1, comparator);
        binarySortTree.add(3, comparator);
        binarySortTree.add(10, comparator);
        binarySortTree.add(-5, comparator);
        binarySortTree.add(4, comparator);
        binarySortTree.add(9, comparator);
        binarySortTree.add(11, comparator);

        return binarySortTree;
    }

    @Test
    public void testCreatBinarySortTree() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        binarySortTree.infixOrder(System.out::println);
    }

    @Test
    public void testDeleteLeafNode() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        binarySortTree.deleteSortedTreeNode(4, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(9, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(11, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(1111, Integer::compareTo);
        binarySortTree.infixOrder(System.out::println);
    }

    @Test
    public void testDeleteSingleBranchNode() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        binarySortTree.deleteSortedTreeNode(3, Integer::compareTo);
        binarySortTree.infixOrder(System.out::println);
    }

    @Test
    public void testDeleteDoubleBranchNode() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        binarySortTree.deleteSortedTreeNode(5, Integer::compareTo);
        binarySortTree.infixOrder(System.out::println);
    }

    @Test
    public void testDeleteDNode() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        binarySortTree.deleteSortedTreeNode(5, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(-5, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(3, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(4, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(10, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(11, Integer::compareTo);
        binarySortTree.deleteSortedTreeNode(1, Integer::compareTo);
        binarySortTree.infixOrder(System.out::println);
    }
}
