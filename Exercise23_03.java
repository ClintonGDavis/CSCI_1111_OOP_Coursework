/*
Author: Clint Davis
Date: 11/03/22

This is my attempt at solving Exercise 23-03.
*/

import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);

    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println("");
    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
            new Circle(5), new Circle(6), new Circle(1), new Circle(2),
            new Circle(3), new Circle(14), new Circle(12)};

    quickSort(list1, new GeometricObjectComparator());

    for (int i = 0; i < list1.length; i++) {
    System.out.println(list1[i] + " ");
    }

    System.out.println("");
    // Create an Integer array
    Integer[] intArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(intArray);

    for (int i = 0; i < intArray.length; i++) {
      System.out.print(intArray[i] + " ");
    }

    System.out.println("");
    // Create a Double array
    Double[] doubleArray = {3.4, 1.3, -22.1, 14.8, 6.0, 2.3, 12.2};
    quickSort(doubleArray);

    for (int i = 0; i < doubleArray.length; i++) {
      System.out.print(doubleArray[i] + " ");
    }

    System.out.println("");
    // Create a Character array
    Character[] charArray = {'a', 'J', 'r'};
    quickSort(charArray);

    for (int i = 0; i < charArray.length; i++) {
      System.out.print(charArray[i] + " ");
    }

    System.out.println("");
    // Create a String array
    String[] stringArray = {"Tom", "Susan", "Kim"};
    quickSort(stringArray);

    for (int i = 0; i < stringArray.length; i++) {
      System.out.print(stringArray[i] + " ");
    }
    System.out.println("");
  }

  public static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, 0, list.length - 1);
  }

  private static <E extends Comparable<E>> void quickSort(E[] list, int indexL, int indexH) {
    if (indexH > indexL) {
      int pivot = partition(list, indexL, indexH);

      quickSort(list, indexL, pivot - 1);
      quickSort(list, pivot + 1, indexH);
    }
  }

  public static <E extends Comparable<E>>
  int partition(E[] list, int first, int last) {
    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && list[low].compareTo(pivot) <= 0) {
        low++;
      }

      while (low <= high && list[high].compareTo(pivot) > 0) {
        high--;
      }

      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high].compareTo(pivot) >= 0)
      high--;

    if (pivot.compareTo(list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }

  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
    quickSort(list, 0, list.length - 1, comparator);
  }

  private static <E> void quickSort(E[] list, int indexL, int indexH, Comparator<? super E> comparator) {
    if (indexH > indexL) {
      int pivot = partition(list, indexL, indexH, comparator);

      quickSort(list, indexL, pivot - 1, comparator);
      quickSort(list, pivot + 1, indexH, comparator);
    }
  }

  public static <E> int partition(
          E[] list, int first, int last, Comparator<? super E> comparator) {
    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && comparator.compare(list[low], pivot) <= 0) {
        low++;
      }

      while (low <= high && comparator.compare(list[high], pivot) > 0) {
        high--;
      }

      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && comparator.compare(list[high] , pivot) >= 0)
      high--;

    if (comparator.compare(pivot, list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }
}