import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование очереди
 */
public class QueueTest {

    /**
     * Очередь со строками
     */
    @Test
    public void testStringQueue() {
        Queue<String> queue = new Queue<>();
        queue.put("Hello");
        queue.put("world");
        assertEquals("Hello", queue.get());
        assertEquals("world", queue.get());
    }

    /**
     * Очередь пуста и мы пытаемся из неё вытащить значение
     */
    @Test(expected = NoSuchElementException.class)
    public void testEmptyQueue() {
        class MyClass {
        }
        Queue<MyClass> queue = new Queue<>();
        queue.get();
    }

    /**
     * Queue overflow test
     */
    @Test(expected = IllegalStateException.class)
    public void testFullQueue() {
        class MyClass{
        }

        // Filling and initialization
        Queue<MyClass> queue = new Queue<>(new Random().nextInt(20));
        for (int i = 0; i < queue.capacity(); i++) {
            queue.put(new MyClass());
        }

        // test
        queue.put(new MyClass());
    }

    /**
     * Test the Iterable interface
     * implementation
     */
    @Test
    public void testIterator() {
        // Filling and initialization
        Queue<Integer> queue = new Queue<>(new Random().nextInt(20));
        for (int i = 0; i < queue.capacity(); i++) {
            queue.put(i);
        }

        // test
        int value = 0;
        for (Integer i : queue) {
            assertEquals(Integer.valueOf(value++), i);
        }

    }
}
