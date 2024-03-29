public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the list

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	/** Return true if this list contains no elements */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else
			return false;
	}

    /** Adds the elements in otherList to this list.
     * Returns true if this list changed as a result of the call */
    public boolean addAll(MyList<E> otherList) {
		otherList.forEach((n) -> add((E)n));
		return otherList.size() != size;
    }

    /** Removes all the elements in otherList from this list
     * Returns true if this list changed as a result of the call */
    public boolean removeAll(MyList<E> otherList) {
		otherList.forEach((n) ->
				remove((E)n));
		return otherList.size() != size;
    }

    /** Retains the elements in this list that are also in otherList
     * Returns true if this list changed as a result of the call */
    public boolean retainAll(MyList<E> otherList) {
		this.forEach((n) -> {
			if (!otherList.contains((E)n))
				remove((E)n);
		});
		this.forEach((n) -> {
			if (!otherList.contains((E)n))
				remove((E)n);
		});

		return otherList.size() != size;
    }
}