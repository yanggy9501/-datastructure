package com.app.tools.datamoudle.module;

import com.app.tools.datamoudle.module.queue.AbstractQueue;

import java.util.LinkedList;

/**
 * LinkedList列表实现的队列
 *
 * @author yanggy
 */
public class LinkedQueue<T> extends AbstractQueue<T> {
    /**
     * 队列
     */
    private final LinkedList<T> queue;

    public LinkedQueue() {
        this.queue = new LinkedList<>();
    }

    @Override
    public boolean enqueue(T element) {
        queue.addLast(element);
        return true;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    @Override
    public T getHead() {
        if (isEmpty()) {
            return null;
        }
        return queue.getFirst();
    }

    @Override
    public int length() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    protected boolean isFull() {
        return false;
    }
}
