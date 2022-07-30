package com.app.tools.datastruct.test.tree;

import com.app.tools.datastruct.datamodule.BinarySortTree;
import org.junit.Test;

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
        BinarySortTree<Integer> binarySortTree = new BinarySortTree<>(Integer::compare);
        binarySortTree.add(5);
        binarySortTree.add(1);
        binarySortTree.add(3);
        binarySortTree.add(10);
        binarySortTree.add(-5);
        binarySortTree.add(4);
        binarySortTree.add(9);
        binarySortTree.add(11);

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
        binarySortTree.delete(4);
        binarySortTree.delete(9);
        binarySortTree.delete(11);
        binarySortTree.delete(1111);
        binarySortTree.infixOrder(System.out::println);
    }

    @Test
    public void testDeleteSingleBranchNode() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        binarySortTree.delete(3);
        binarySortTree.infixOrder(System.out::println);
    }

    @Test
    public void testDeleteDoubleBranchNode() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        binarySortTree.delete(5);
        binarySortTree.infixOrder(System.out::println);
    }

    @Test
    public void testDeleteDNode() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        binarySortTree.delete(5);
        binarySortTree.delete(-5);
        binarySortTree.delete(3);
        binarySortTree.delete(4);
        binarySortTree.delete(10);
        binarySortTree.delete(11);
        binarySortTree.delete(1);
        binarySortTree.infixOrder(System.out::println);
    }
}
