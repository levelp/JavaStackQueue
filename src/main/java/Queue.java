import java.util.NoSuchElementException;

/**
 * Очередь: FIFO = First Input First Output
 */
public class Queue<T> {

    Element lastElement = null;

    /**
     * Добавить в конец очереди
     *
     * @param v значение
     */
    public void put(T v) {
        /**
         * Создаем новый элемент и записываем в его
         * параметр next ссылку на предыдущий созданный обьект
         */
        Element newElement = new Element();
        newElement.value = v;
        if (lastElement == null) {
            newElement.next = null;
        } else {
            newElement.next = lastElement;
        }
        lastElement = newElement;
    }

    /**
     * Взять из начала очереди
     *
     * @return значение
     */
    public T get() throws NoSuchElementException {
        /**
         * Проверяем наличие последнего элемента в очереди
         * если его нет - генерируем исключение.
         * В случае если очередь не пуста, добираемся до первого
         * элемента и возвращаем его значение.
         */
        if (lastElement == null) {
            throw new NoSuchElementException("Queue is empty!");
        } else {
            Element head = lastElement;
            Element tail = head;
            T value;
            while (true) {
                if (head.next == null) {
                    value = head.value;
                    if (!tail.equals(head)) {
                        tail.next = null;
                    } else {
                        lastElement = null;
                    }
                    break;
                } else {
                    tail = head;
                    head = head.next;
                }

            }
            return value;
        }
    }

    /**
     * Элемент очереди
     */
    class Element {
        T value;
        Element next;
    }
}
