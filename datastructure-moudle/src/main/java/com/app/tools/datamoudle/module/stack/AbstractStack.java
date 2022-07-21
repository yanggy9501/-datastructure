package com.app.tools.datamoudle.module.stack;

/**
 * 栈的抽象接口
 *
 * @author yanggy
 */
public abstract class AbstractStack<T> {
    /**
     * 压栈
     *
     * @param element 数据元素
     * @return boolean 是否压栈成功
     */
    public abstract boolean push(T element);

    /**
     * 弹栈
     *
     * @return T 栈顶元素
     */
    public abstract T pop();

    /**
     * 获取栈顶元素
     *
     * @return T 栈顶元素
     */
    public abstract T getHead();

    /**
     * 获取栈的长度
     *
     * @return int 栈的大小
     */
    public abstract int length();

    /**
     * 判断栈是否为空
     *
     * @return boolean
     */
    public abstract boolean isEmpty();

    /**
     * 判断栈是否已经栈满
     *
     * @return boolean
     */
    public abstract boolean isFull();
}
