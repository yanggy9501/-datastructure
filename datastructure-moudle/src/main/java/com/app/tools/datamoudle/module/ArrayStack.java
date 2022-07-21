package com.app.tools.datamoudle.module;

import com.app.tools.datamoudle.module.stack.AbstractStack;

/**
 * 数组实现的栈
 *
 * @author yanggy
 */
public class ArrayStack<T> extends AbstractStack<T> {
    /**
     * 栈
     */
    private final Object[] stack;

    /**
     * 栈顶指针
     */
    private int top;

    public ArrayStack(int initSize) {
        this.stack = new Object[initSize];
        top = -1;
    }

    @Override
    public boolean push(T element) {
        if (isFull()) {
            return false;
        }
        stack[++top] = element;
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return (T) stack[top--];
    }

    @Override
    public T getHead() {
        return (T) stack[top];
    }

    @Override
    public int length() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public boolean isFull() {
        return top == stack.length - 1;
    }
}
