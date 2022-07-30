package com.app.tools.datastruct.datamodule;

import com.app.tools.datastruct.datamodule.queue.AbstractQueue;

/**
 * 数组实现的队列
 *
 * @author yanggy
 */
public class ArrayQueue<T> extends AbstractQueue<T> {
    /**
     * 队列
     */
    private final Object[] queue;

    /**
     * 队头
     */
    private int head;

    /**
     * 队尾
     */
    private int rear;

    public ArrayQueue(int initSize) {
        this.queue = new Object[initSize + 1];
        this.head = rear = 0;
    }

    @Override
    public boolean enqueue(T element) {
        if (isFull()) {
            return false;
        }
        rear = getIndex(rear + 1);
        queue[rear] = element;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        head = getIndex(head + 1);
        T d = (T) queue[head];
        queue[head] = null;
        return d;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getHead() {
        return (T) queue[getIndex(head + 1)];
    }

    @Override
    public int length() {
        return queue.length;
    }

    @Override
    public boolean isEmpty() {
        return head == rear;
    }

    @Override
    protected boolean isFull() {
        return (rear + 1 + length()) % length() == head;
    }

    private int getIndex(int index) {
        return index % length();
    }
}
