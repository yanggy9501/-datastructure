package com.app.tools.datamoudle.test.tree;

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
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<>(Integer::compare);
        balancedBinaryTree.add(6);
        balancedBinaryTree.add(1);
        balancedBinaryTree.add(3);
        balancedBinaryTree.add(10);
        balancedBinaryTree.add(-5);
        balancedBinaryTree.add(4);
        balancedBinaryTree.add(9);
        balancedBinaryTree.add(11);

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
        BinarySortTree<Integer> binarySortTree = new BinarySortTree<>(Integer::compare);
        binarySortTree.add(6);
        binarySortTree.add(1);
        binarySortTree.add(3);
        binarySortTree.add(10);
        binarySortTree.add(-5);
        binarySortTree.add(4);
        binarySortTree.add(9);
        binarySortTree.add(11);

        binarySortTree.add(5);
        binarySortTree.add(12);

        return binarySortTree;
    }

    @Test
    public void testCreatBinarySortTree() {
        BalancedBinaryTree<Integer> balancedBinaryTree = createBalancedBinarySortTree();
        BinaryTreeNode<Integer> node = balancedBinaryTree.search(1);
        int treeHeight = BinaryTreeHelper.getHeight(node);
        System.out.println(treeHeight);
    }

    @Test
    public void testBalanced() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        BinaryTreeNode<Integer> node = binarySortTree.search(111);
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
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<>(Integer::compare);
        balancedBinaryTree.add(6);
        balancedBinaryTree.add(10);
        balancedBinaryTree.add(11);
        balancedBinaryTree.add(12);
        balancedBinaryTree.add(13);
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
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<>(Integer::compare);
        balancedBinaryTree.add(6);
        balancedBinaryTree.add(5);
        balancedBinaryTree.add(4);

        balancedBinaryTree.add(3);
        balancedBinaryTree.add(2);
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
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<>(Integer::compare);
        balancedBinaryTree.add(20);
        balancedBinaryTree.add(10);
        balancedBinaryTree.add(5);

        balancedBinaryTree.add(8);
        balancedBinaryTree.add(-5);

        balancedBinaryTree.add(9);
        balancedBinaryTree.add(30);


        return balancedBinaryTree;
    }

    @Test
    public void testRotate() {
        BalancedBinaryTree<Integer> balancedBinaryTree = createBalancedBinaryTree();
        System.out.println("------------");
        balancedBinaryTree.infixOrder(System.out::println);
    }
}
