package com.app.tools.datastruct.datamodule.queue;

/**
 * 队列抽象接口
 *
 * @author yanggy
 */
public abstract class AbstractQueue<T> {
    /**
     * 入队
     *
     * @param element 入队元素
     * @return boolean true表示入队成功，否则入队失败
     */
    public abstract boolean enqueue(T element);

    /**
     * 出队
     *
     * @return 队头元素
     */
    public abstract T dequeue();

    /**
     * 获取队头元素
     *
     * @return 队头元素
     */
    public abstract T getHead();

    /**
     * 获取队列长度，即返回队列中有多少个元素长度
     *
     * @return int 队列的长度
     */
    public abstract int length();

    /**
     * 判断队列是否为空
     *
     * @return boolean true则队列为空，否则队列非空
     */
    public abstract boolean isEmpty();

    /**
     * 判断队列是否已满
     *
     * @return boolean true则队已满，否则队列非满
     */
    protected abstract boolean isFull();
}
