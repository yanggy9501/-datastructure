package com.app.tools.datastruct.module;

import com.app.tools.datastruct.module.stack.AbstractStack;

import java.util.LinkedList;

/**
 * LinkedList实现的栈
 *
 * @author yanggy
 */
public class LinkedStack<T> extends AbstractStack<T> {
    /**
     * 栈
     */
    private final LinkedList<T> stack;

    public LinkedStack() {
        this.stack = new LinkedList<>();
    }

    @Override
    public boolean push(T element) {
        stack.addLast(element);
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.removeLast();
    }

    @Override
    public T getHead() {
        if (isEmpty()) {
            return null;
        }
        return stack.getFirst();
    }

    @Override
    public int length() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
