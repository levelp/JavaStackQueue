import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование стека
 */
public class StackTest {

    /**
     * Стек с целыми числами
     */
    @Test
    public void testIntStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
    }

    /**
     * Стек со строками
     */
    @Test
    public void testStringStack() {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("world");
        assertEquals("world", stack.pop());
        assertEquals("Hello", stack.pop());
    }

    /**
     * Стек пуст и мы пытаемся из него вытащить значение
     */
    @Test(expected = EmptyStackException.class)
    public void testEmptyStack() {
        class MyClass {
        }
        Stack<MyClass> stack = new Stack<>();
        stack.pop();
    }

    /**
     * Stack overflow test
     */
    @Test(expected = StackOverflowError.class)
    public void testStackOverflow() {
        class MyClass {
        }
        // New stack with max size [0; 20]
        Stack<MyClass> stack = new Stack<>(new Random().nextInt(20));

        // fill the stack
        for (int i = 0; i < stack.capacity(); i++) {
            stack.push(new MyClass());
        }

        stack.push(new MyClass());

    }

    /**
     * Test the stack printing
     * with forEach
     */
    @Test
    public void testIterator(){
        // The stack with max size 10
        Stack<Integer> stack = new Stack<>(10);
        // The stack filling
        for (int i = 0; i < stack.capacity(); i++) {
            stack.push(i);
        }

        // test the stack iterator
        Integer value = stack.size() - 1;
        for (Integer i : stack){
            System.out.println(value + " " + i);
            assertEquals(value, i);
            value--;
        }
    }

}
