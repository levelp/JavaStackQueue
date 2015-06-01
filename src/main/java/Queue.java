import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Очередь: FIFO = First Input First Output
 */
public class Queue<T> implements Iterable<T> {
    // The queue size
    private int size = 0;
    // The queue maximum capacity
    private final int MAX_SIZE;

    // link to the queue head
    private Element<T> front;
    // link to the queue tail
    private Element<T> rear;

    /**
     * Default constructor
     */
    public Queue() {
        this(100);
    }

    /**
     * Constructor with the capacity
     *
     * @param MAX_SIZE
     */
    public Queue(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    /**
     * Добавить в конец очереди
     *
     * @param v значение
     */
    public void put(T v) {
        // TODO: реализовать
        if (size != MAX_SIZE) {
            if (isEmpty()){
                this.front = new Element<>(v, null);
                this.rear = this.front;
            } else {
                this.rear.next = new Element<>(v, null);
                this.rear = this.rear.next;
            }
            size++;
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + "is full");
        }
    }

    /**
     * Взять из начала очереди
     *
     * @return значение
     */
    public T get() {
        // TODO: реализовать
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T value = this.front.value;
        this.front = this.front.next;
        size--;

        return value;
    }

    /**
     * Элемент очереди
     */
    private static class Element<T> {


        T value;
        Element next;
        private Element(T value, Element<T> next) {
            this.value = value;
            this.next = next;
        }

    }
    /**
     * Size getter
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Capacity getter
     *
     * @return int
     */
    public int capacity() {
        return MAX_SIZE;
    }

    /**
     * The empty queue check
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return size == 0;
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

            private Element<T> current = front;

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
