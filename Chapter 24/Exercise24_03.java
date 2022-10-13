/**
 * Author: Clint Davis
 * Date: 10/12/22
 *
 * This is my attempt at solving Exercise 24-03.
 */

class Exercise24_03 {
	public static void main(String[] args) {
		TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		java.util.ListIterator<Integer> iterator = list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();

		// System.out.print(iterator.next() + " ");

		System.out.println();
		while (iterator.hasPrevious())
		  System.out.print(iterator.previous() + " ");
	}
}