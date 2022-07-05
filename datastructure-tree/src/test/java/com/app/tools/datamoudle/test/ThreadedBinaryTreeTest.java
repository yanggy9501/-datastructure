package com.app.tools.datamoudle.test;

import com.app.tools.datamoudle.module.binarytree.ThreadedBinaryTreeNode;
import com.app.tools.datamoudle.dto.Hero;
import com.app.tools.datamoudle.helper.ThreadedBinaryTreeHelper;
import org.junit.Test;

/**
 * @author yanggy
 */
public class ThreadedBinaryTreeTest {

    /*
                    1
                  /   \
                 2     3
                      /  \
                     4    5
     */

    private static ThreadedBinaryTreeNode<Hero>  newThreadedBinaryTreeNode() {
        // 创建节点
        Hero hero1 = new Hero(1, "宋将");
        Hero hero2 = new Hero(2, "吴用");
        Hero hero3 = new Hero(3, "卢俊义");
        Hero hero4 = new Hero(4, "林冲");
        Hero hero5 = new Hero(5, "关胜");

        ThreadedBinaryTreeNode<Hero> root = new ThreadedBinaryTreeNode<>();
        ThreadedBinaryTreeNode<Hero> node2 = new ThreadedBinaryTreeNode<>();
        ThreadedBinaryTreeNode<Hero> node3 = new ThreadedBinaryTreeNode<>();
        ThreadedBinaryTreeNode<Hero> node4 = new ThreadedBinaryTreeNode<>();
        ThreadedBinaryTreeNode<Hero> node5 = new ThreadedBinaryTreeNode<>();

        root.setData(hero1);
        root.setLeftNode(node2);
        root.setRightNode(node3);

        node2.setData(hero2);

        node3.setData(hero3);
        node3.setLeftNode(node4);
        node3.setRightNode(node5);

        node4.setData(hero4);

        node5.setData(hero5);

        return root;
    }

    
    @Test
    public void testInfixThreadedBinaryTree() {
        ThreadedBinaryTreeNode<Hero> root = newThreadedBinaryTreeNode();
        ThreadedBinaryTreeHelper.infixOrderThread(root);
        ThreadedBinaryTreeHelper.infixOrder(root, System.out::println);
    }
}
