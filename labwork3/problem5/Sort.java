package labwork3.problem5;

public class Sort {

    static <E> void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static <E extends Comparable<E>> void bubbleSort(E[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // swap array[j] and array[j+1]
                    swap(array, j, j + 1);
                }
            }
        }
    }

    static <E extends Comparable<E>> void heapSort(E[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from the heap
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root to the end
            swap(array, 0, i);

            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    static <E extends Comparable<E>> void heapify(E[] array, int n, int i) {
        int largest = i; // Initialize largest as the root
        int l = 2 * i + 1; // Left child = 2*i + 1
        int r = 2 * i + 2; // Right child = 2*i + 2

        // If the left child is larger than the root
        if (l < n && array[l].compareTo(array[largest]) > 0) {
            largest = l;
        }

        // If the right child is larger than the largest so far
        if (r < n && array[r].compareTo(array[largest]) > 0) {
            largest = r;
        }

        // If the largest is not the root
        if (largest != i) {
            swap(array, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }
}