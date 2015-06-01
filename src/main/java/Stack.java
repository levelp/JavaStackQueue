import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Стек: LIFO = Last Input First Output
 */
public class Stack<T> implements Iterable<T> {
    // The current stack size
    private int size;
    // The maximum stack size
    private final int MAX_SIZE;

    private Element<T> top;


    /**
     * Default constructor
     */
    public Stack() {
        this(100);
    }

    /**
     * Constructor with the capacity
     * @param MAX_SIZE
     */
    public Stack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    /**
     * Добавить на вершину стека
     *
     * @param v значение
     */
    public void push(T v) {
        // TODO: реализовать
        if (size != MAX_SIZE) {
            this.top = new Element<>(v, this.top);
            size++;
        }
        else throw new StackOverflowError();
    }

    /**
     * Получить значение с вершины
     *
     * @return значение
     */
    public T pop() {
        // TODO: реализовать
        if (!isEmpty()) {
            T value = this.top.value;
            this.top = this.top.next;
            size--;
            return value;
        }

        throw new EmptyStackException();
    }

    /**
     * Элемент стека
     */
    private static class Element<T> {

        private final T value;
        private final Element<T> next;

        // Constructor
        private Element(T value, Element<T> next){
            this.value = value;
            this.next = next;
        }
    }
    /**
     * If the stack is empty
     *
     * @return true;
     */
    boolean isEmpty(){
        return size == 0;
    }

    /**
     * Getter for size
     *
     * @return size
     */
    int size(){
        return size;
    }

    /**
     * Getter for maximum size
     *
     * @return MAX_SIZE
     */
    public int capacity() {
        return MAX_SIZE;
    }

    /**
     * The Iterable interface
     * implementation
     *
     * @return Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Element<T> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
