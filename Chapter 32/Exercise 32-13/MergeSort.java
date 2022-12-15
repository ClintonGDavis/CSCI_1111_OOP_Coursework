public class MergeSort {
  /** The method for sorting the numbers */
  public static void mergeSort(Integer[] list2) {
    if (list2.length > 1) {
      // Merge sort the first half
      Integer[] firstHalf = new Integer[list2.length / 2];
      System.arraycopy(list2, 0, firstHalf, 0, list2.length / 2);
      mergeSort(firstHalf);

      // Merge sort the second half
      int secondHalfLength = list2.length - list2.length / 2;
      Integer[] secondHalf = new Integer[secondHalfLength];
      System.arraycopy(list2, list2.length / 2,
        secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);

      // Merge firstHalf with secondHalf into list
      merge(firstHalf, secondHalf, list2);
    }
  }

  /** Merge two sorted lists 
 * @param <E>*/
  public static <E> void merge(Object[] firstHalf, Object[] secondHalf, E[] list) {
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp

    while (current1 < firstHalf.length && current2 < secondHalf.length) {
      if (firstHalf[current1] != secondHalf[current2])
        list[current3++] = (E) firstHalf[current1++];
      else
        list[current3++] = (E) secondHalf[current2++];
    }

    while (current1 < firstHalf.length)
      list[current3++] = (E) firstHalf[current1++];

    while (current2 < secondHalf.length)
      list[current3++] = (E) secondHalf[current2++];
  }

  /** A test method */
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    mergeSort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
}
