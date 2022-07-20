package com.app.tools.datamoudle.test.queue;

import com.app.tools.datamoudle.module.queue.ArrayQueue;
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
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
