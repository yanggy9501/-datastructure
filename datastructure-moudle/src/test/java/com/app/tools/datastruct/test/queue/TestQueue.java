package com.app.tools.datastruct.test.queue;

import com.app.tools.datastruct.datamodule.ArrayQueue;
import org.junit.Test;

/**
 * @author yanggy
 */
public class TestQueue {

    @Test
    public void testEnqueue() {
        ArrayQueue<String> queue = new ArrayQueue<String>(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        System.out.println(queue);
        System.out.println();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    @Test
    public void testEnqueue2() {
        ArrayQueue<String> queue = new ArrayQueue<>(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.enqueue("f");
        queue.enqueue("f");
        System.out.println();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.length());
        queue.enqueue("f");
        queue.enqueue("f");
        queue.enqueue("f");
    }
}
