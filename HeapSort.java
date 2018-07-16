package heap;

public class HeapSort {
	int x=100000000;
	
	private static int[] array = new int[]{5, 3, 6, 4, 8, 9 , 1, 10};
	

    public static void main(String[] args) {
        heapSort();

        for(int i : array) {
            System.out.println(i);
        }
    }

    private static void heapSort() {
        int length = array.length;

        buildMaxHeap(array, length);
        for(int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array, 1, i);
        }
    }

    private static void buildMaxHeap(int[] array, int heapSize) {
        if(array == null) {
            throw new NullPointerException("null");
        }
        if(array.length <=0 || heapSize <= 0) {
            throw new IllegalArgumentException("illegal");
        }
        if(heapSize > array.length) {
            heapSize = array.length;
        }

        for(int i = heapSize/2; i > 0; i--) {
            maxHeapify(array, i, heapSize);
        }
    }

    private static void maxHeapify(int[] array, int index, int heapSize) {
        int l = index * 2;
        int r = l + 1;
        int largest;

        if(l <= heapSize && array[l - 1] > array[index - 1]) {
            largest = l;
        } else {
            largest = index;
        }

        if(r <= heapSize && array[r - 1] > array[largest - 1]) {
            largest = r;
        }

        if(largest != index) {
            int temp = array[index - 1];
            array[index - 1] = array[largest - 1];
            array[largest - 1] = temp;
            maxHeapify(array, largest, heapSize);
        }
    }

}
