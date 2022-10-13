/**
 * Author: Clint Davis
 * Date: 10/13/22
 *
 * This is my attempt at solving Exercise 24-05.
 */

public class Exercise24_05<E> extends GenericQueue {
    private static GenericQueue<Integer> queue = new GenericQueue<>();

    public static void main(String[] args) {
        queue.enqueue(12);
        System.out.println("(1) " + queue);

        queue.enqueue(24);
        System.out.println("(2) " + queue);

        queue.enqueue(36);
        System.out.println("(3) " + queue);

        queue.enqueue(48);
        System.out.println("(4) " + queue);

        queue.enqueue(60);
        System.out.println("(5) " + queue);

        queue.enqueue(72);
        System.out.println("(6) " + queue);

        queue.enqueue(84);
        System.out.println("(7) " + queue);

        queue.enqueue(96);
        System.out.println("(8) " + queue);

        queue.dequeue();
        System.out.println("(7) " + queue);

        queue.dequeue();
        System.out.println("(6) " + queue);

        queue.dequeue();
        System.out.println("(5) " + queue);

        queue.dequeue();
        System.out.println("(4) " + queue);

        queue.dequeue();
        System.out.println("(3) " + queue);

        queue.dequeue();
        System.out.println("(2) " + queue);

        queue.dequeue();
        System.out.println("(1) " + queue);

    }
}
