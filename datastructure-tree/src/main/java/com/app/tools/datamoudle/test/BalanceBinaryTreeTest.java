package com.app.tools.datamoudle.test;

import com.app.tools.datamoudle.helper.BinaryTreeHelper;
import com.app.tools.datamoudle.module.BalancedBinaryTree;
import com.app.tools.datamoudle.module.BinarySortTree;
import com.app.tools.datamoudle.module.binarytree.BinaryTreeNode;
import org.junit.Test;

import java.util.Comparator;

/**
 * @author yanggy
 */
public class BalanceBinaryTreeTest {
    /*
                     6
                  /     \
                1        10
              /   \     /   \
            -5     3    9    11
                    \
                     4
     */

    private BalancedBinaryTree<Integer> createBalancedBinarySortTree() {
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<>();
        Comparator<Integer> comparator = Integer::compare;
        balancedBinaryTree.add(6, comparator);
        balancedBinaryTree.add(1, comparator);
        balancedBinaryTree.add(3, comparator);
        balancedBinaryTree.add(10, comparator);
        balancedBinaryTree.add(-5, comparator);
        balancedBinaryTree.add(4, comparator);
        balancedBinaryTree.add(9, comparator);
        balancedBinaryTree.add(11, comparator);

        return balancedBinaryTree;
    }

    /*
                     6
                  /     \
                1        10
              /   \     /   \
            -5     3    9    11
                    \
                     4
     */

    private BinarySortTree<Integer> createBinarySortTree() {
        BinarySortTree<Integer> binarySortTree = new BinarySortTree<>();
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        binarySortTree.add(6, comparator);
        binarySortTree.add(1, comparator);
        binarySortTree.add(3, comparator);
        binarySortTree.add(10, comparator);
        binarySortTree.add(-5, comparator);
        binarySortTree.add(4, comparator);
        binarySortTree.add(9, comparator);
        binarySortTree.add(11, comparator);

        binarySortTree.add(5, comparator);
        binarySortTree.add(12, comparator);

        return binarySortTree;
    }

    @Test
    public void testCreatBinarySortTree() {
        BalancedBinaryTree<Integer> balancedBinaryTree = createBalancedBinarySortTree();
        BinaryTreeNode<Integer> node = balancedBinaryTree.search(1, Integer::compare);
        int treeHeight = BinaryTreeHelper.getHeight(node);
        System.out.println(treeHeight);
    }

    @Test
    public void testBalanced() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        BinaryTreeNode<Integer> node = binarySortTree.search(111, Integer::compare);
        System.out.println(BinaryTreeHelper.isBalance(node));
    }
    
    /*
         6                      10
           \                  /    \
            10               6      11
             \                       \
                                      12
                                       \
     */

    private BalancedBinaryTree<Integer> createLeftRotateBalancedBinaryTree() {
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<>();
        Comparator<Integer> comparator = Integer::compare;
        balancedBinaryTree.add(6, comparator);
        balancedBinaryTree.add(10, comparator);
        balancedBinaryTree.add(11, comparator);
        balancedBinaryTree.add(12, comparator);
        balancedBinaryTree.add(13, comparator);
        return balancedBinaryTree;
    }
    
    @Test
    public void testLeftRotate() {
        BalancedBinaryTree<Integer> balancedBinaryTree = createLeftRotateBalancedBinaryTree();
        System.out.println(balancedBinaryTree.getRoot());
    }

    /*
                        6               5                       5
                      /               /   \                   /    \
                     5              4       6               3       6
                    /                                      /  \
                                                          2    4

     */

    private BalancedBinaryTree<Integer> createRightRotateBalancedBinaryTree() {
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<>();
        Comparator<Integer> comparator = Integer::compare;
        balancedBinaryTree.add(6, comparator);
        balancedBinaryTree.add(5, comparator);
        balancedBinaryTree.add(4, comparator);

        balancedBinaryTree.add(3, comparator);
        balancedBinaryTree.add(2, comparator);
        return balancedBinaryTree;
    }

    @Test
    public void testRightRotate() {
        BalancedBinaryTree<Integer> balancedBinaryTree = createRightRotateBalancedBinaryTree();
        System.out.println(balancedBinaryTree.getRoot());
    }

    /*
                       20               10                       10                         10                      8
                      /               /    \                   /    \                     /    \                  /    \
                     10              5      20               5       20      ====>        8     20       ===>    5      10
                    /                                       /   \                      /   \                   /      /    \
                                                          -5     8                    5     9               -5       9      20
                                                                   \                 /                                       \
                                                                                   -5                                          30
     */

    private BalancedBinaryTree<Integer> createBalancedBinaryTree() {
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<>();
        Comparator<Integer> comparator = Integer::compare;
        balancedBinaryTree.add(20, comparator);
        balancedBinaryTree.add(10, comparator);
        balancedBinaryTree.add(5, comparator);

        balancedBinaryTree.add(8, comparator);
        balancedBinaryTree.add(-5, comparator);

        balancedBinaryTree.add(9, comparator);
        balancedBinaryTree.add(30, comparator);


        return balancedBinaryTree;
    }

    @Test
    public void testRotate() {
        BalancedBinaryTree<Integer> balancedBinaryTree = createBalancedBinaryTree();
        System.out.println("------------");
        balancedBinaryTree.infixOrder(System.out::println);
    }
}
