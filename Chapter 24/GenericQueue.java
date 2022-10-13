import java.util.LinkedList;

class GenericQueue<E> extends java.util.LinkedList<E> {

    public void enqueue(E data) {
        addLast(data);
    }

    public E dequeue() {
        return removeFirst();
    }
}