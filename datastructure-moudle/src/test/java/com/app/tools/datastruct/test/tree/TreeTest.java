package com.app.tools.datastruct.test.tree;

import com.app.tools.datastruct.dto.Menu;
import com.app.tools.datastruct.helper.TreeHelper;
import com.app.tools.datastruct.datamodule.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanggy
 */
public class TreeTest {

    @Test
    public void test1() {
        Menu menu1 = new Menu(0, 1, "菜单目录1");
        Menu menu2 = new Menu(1, 2, "菜单2");
        Menu menu11 = new Menu(0, 11, "菜单目录11");
        Menu menu22 = new Menu(11, 22, "菜单222");
        ArrayList<Menu> list = new ArrayList<>();
        list.add(menu1);
        list.add(menu2);
        list.add(menu11);
        list.add(menu22);

        List<TreeNode<Menu>> tree = TreeHelper.buildTree(list, new TreeHelper.NodeRelationPredicate<Menu>() {
            @Override
            public boolean isRootNode(Menu nodeData) {
                return nodeData.getParentId() == 0;
            }

            @Override
            public boolean isParentChildRelation(Menu currentNodeData, Menu mightParentNode) {
                return currentNodeData.getParentId() == mightParentNode.getId();
            }
        }, (o1, o2) -> 0);

        System.out.println(tree);
    }
}
