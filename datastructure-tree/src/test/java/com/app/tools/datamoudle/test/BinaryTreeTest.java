package com.app.tools.datamoudle.test;

import com.app.tools.datamoudle.dto.Hero;
import com.app.tools.datamoudle.module.BinaryTree;
import com.app.tools.datamoudle.module.binarytree.BinaryTreeNode;
import com.app.tools.datamoudle.module.ArrayBinaryTree;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author yanggy
 */
public class BinaryTreeTest {

    /*
                    1
                  /   \
                 2     3
                      /  \
                     4    5
     */

    private static BinaryTree<Hero> newBinaryTree() {
        // 创建节点
        Hero hero1 = new Hero(1, "宋将");
        Hero hero2 = new Hero(2, "吴用");
        Hero hero3 = new Hero(3, "卢俊义");
        Hero hero4 = new Hero(4, "林冲");
        Hero hero5 = new Hero(5, "关胜");

        BinaryTreeNode<Hero> root = new BinaryTreeNode<>();
        BinaryTreeNode<Hero> node2 = new BinaryTreeNode<>();
        BinaryTreeNode<Hero> node3 = new BinaryTreeNode<>();
        BinaryTreeNode<Hero> node4 = new BinaryTreeNode<>();
        BinaryTreeNode<Hero> node5 = new BinaryTreeNode<>();

        root.setData(hero1);
        root.setLeftNode(node2);
        root.setRightNode(node3);

        node2.setData(hero2);

        node3.setData(hero3);
        node3.setLeftNode(node4);
        node3.setRightNode(node5);

        node4.setData(hero4);

        node5.setData(hero5);

        // 创建二叉树
        return new BinaryTree<>(root);
    }

    /*
                      1
                  /        \
                 2           3
               /  \         /  \
              4    5       6    7
     */

    private static ArrayBinaryTree<Hero>  newArrayBinaryTree() {
        // 创建节点
        Hero hero1 = new Hero(1, "宋将");
        Hero hero2 = new Hero(2, "吴用");
        Hero hero3 = new Hero(3, "卢俊义");
        Hero hero4 = new Hero(4, "小丑4");
        Hero hero5 = new Hero(5, "跑龙套5");
        Hero hero6 = new Hero(6, "林冲");
        Hero hero7 = new Hero(7, "关胜");

        ArrayList<Hero> data = new ArrayList<>();
        data.add(null);
        data.add(hero1);
        data.add(hero2);
        data.add(hero3);
        data.add(hero4);
        data.add(hero5);
        data.add(hero6);
        data.add(hero7);

        return new ArrayBinaryTree<>(data);
    }

    @Test
    public void testPreOrder() {
        BinaryTree<Hero> binaryTree = newBinaryTree();
        binaryTree.preOrder(heroBinaryTreeNode -> System.out.println(heroBinaryTreeNode.toString()));
//        binaryTree.infixOrder();
//        binaryTree.postOrder();
    }

    @Test
    public void testXxxOrderSearch() {
        BinaryTree<Hero> binaryTree = newBinaryTree();
        BinaryTreeNode<Hero> nodeX = new BinaryTreeNode<>( new Hero(1, ""));
//        BinaryTreeNode<Hero> node = binaryTree.postOrderSearch(nodeX, (v1, v2) -> v1.getData().getNo() == v2.getData().getNo() ? 0 : -1);
//        BinaryTreeNode<Hero> node = binaryTree.infixOrderSearch(nodeX, (v1, v2) -> v1.getData().getNo() == v2.getData().getNo() ? 0 : -1);
//        BinaryTreeNode<Hero> node = binaryTree.postOrderSearch(nodeX, (v1, v2) -> v1.getData().getNo() == v2.getData().getNo() ? 0 : -1);
//        BinaryTreeNode<Hero> node = binaryTree.postOrderSearch(, (v1, v2) -> v1.getData().getNo() == v2.getData().getNo() ? 0 : -1);
        BinaryTreeNode<Hero> node = binaryTree.postOrderSearch(node1 -> node1.getData().getNo() == nodeX.getData().getNo());
        System.out.println(node);
    }

    @Test
    public void testDeleteNode() {
        BinaryTree<Hero> binaryTree = newBinaryTree();
        binaryTree.preOrder(heroBinaryTreeNode -> System.out.println(heroBinaryTreeNode.toString()));
    }

    @Test
    public void testArrayBinaryTree() {
        ArrayBinaryTree<Hero> arrayBinaryTree = newArrayBinaryTree();
        arrayBinaryTree.preOrder(System.out::println);
    }
}
