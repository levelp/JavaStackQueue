import java.util.EmptyStackException;

/**
 * Стек: LIFO = Last Input First Output
 */
public class Stack<T> {

    Element lastElement = null;

    /**
     * Добавить на вершину стека
     *
     * @param v значение
     */
    public void push(T v) {
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
     * Получить значение с вершины
     *
     * @return значение
     */
    public T pop() throws EmptyStackException {
        /**
         * Проверяем наличие элемента на вершине стека
         * если его нет - генерируем исключение.
         * В случае если элемент присутствует, возвращаем
         * его значение и передвигаем указатель на предпоследний элемент
         */
        if (lastElement == null) {
            throw new EmptyStackException();
        } else {
            T value = lastElement.value;
            if (lastElement.next == null) {
                lastElement = null;
            } else {
                lastElement = lastElement.next;
            }
            return value;
        }
    }

    /**
     * Элемент стека
     */
    class Element {
        T value;
        Element next;
    }

}
