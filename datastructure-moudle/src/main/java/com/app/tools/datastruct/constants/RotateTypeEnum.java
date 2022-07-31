package com.app.tools.datastruct.constants;

/**
 * 平衡二叉树节点旋转类型
 */
public enum RotateTypeEnum {
    /**
     * 左旋
     */
    LEFT_ROTATE,

    /**
     * 右旋
     */
    RIGHT_ROTATE,

    /**
     * 先左旋有右旋
     */
    LEFT_RIGHT_ROTATE,

    /**
     * 先右旋后左旋
     */
    RIGHT_LEFT_ROTATE,

    /**
     * 平衡
     */
    NULL
}
