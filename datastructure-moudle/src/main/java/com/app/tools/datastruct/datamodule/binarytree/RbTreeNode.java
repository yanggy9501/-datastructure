package com.app.tools.datastruct.datamodule.binarytree;

import com.app.tools.datastruct.constants.RbtColorEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 树的孩子表示法
 *
 * @author yanggy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RbTreeNode<T> extends BinaryTreeNode<T> {
    public RbTreeNode() {
        color = RbtColorEnum.RED;
    }

    public RbTreeNode(T data) {
        super(data);
        color = RbtColorEnum.RED;
    }

    /**
     * 红黑树节点类型
     */
    private RbtColorEnum color;

    /**
     * 父节点
     */
    private RbTreeNode<T> parent;

    @Override
    public RbTreeNode<T> getLeftNode() {
        return (RbTreeNode<T>) super.getLeftNode();
    }

    @Override
    public RbTreeNode<T> getRightNode() {
        return (RbTreeNode<T>) super.getRightNode();
    }
}
