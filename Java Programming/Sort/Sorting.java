import java.util.Arrays;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] array = {2, 3, 5, 7, 11, 13, 17, 19};
		int x = 17;
		System.out.printf("Position of x is: %d\n", binarySearch(array, x));
		System.out.printf("Position of x is: %d\n", binarySearch(array, x, 0, array.length-1));

		int[] a = {21, 4, 5, 9, 1, 8};
		System.out.println("Selection Sort: " + Arrays.toString(selectionSort(Arrays.copyOf(a, a.length))));
		System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort(Arrays.copyOf(a, a.length))));
		System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(Arrays.copyOf(a, a.length))));
		System.out.println("Merge Sort: " + Arrays.toString(mergeSort(Arrays.copyOf(a, a.length))));
		System.out.println("Quick Sort: " + Arrays.toString(quickSort(Arrays.copyOf(a, a.length))));
		
		System.out.println("Array: " + Arrays.toString(a));		
	}
	
	public static int binarySearch(int[] arr, int x) {
		
		int mid, low = 0;
		int high = arr.length - 1;
		
		while (low <= high) {
			mid = (low + high)/2;
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] < x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		return -1;
	}
	
	public static int binarySearch(int[] arr, int x, int low, int high) {
		if (low > high)
			return -1;
		
		int mid = (low + high)/2;
		if (arr[mid] == x)
			return mid;
		else if (arr[mid] < x)
			return binarySearch(arr, x, mid+1, high);
		else
			return binarySearch(arr, x, low, mid-1);
	}
	
	public static int[] selectionSort(int[] a) {
		for(int i = a.length - 1; i >= 1; i--) {
			int largestIndex = i;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[largestIndex])
					largestIndex = j;
			}
			swap(a, i, largestIndex);
		}
		return a;
	}
	
	public static int[] bubbleSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			boolean isSorted = true;
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
					isSorted = false;
				}
			}
			if (isSorted)
				return a;
		}
		return a;
	}
	
	public static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static int[] insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int value = a[i];
			int j;
			for (j = i-1; j >= 0 && a[j] > value; j--)
				a[j+1] = a[j];
			a[j+1] = value;
		}
		return a;
	}
	
	public static int[] mergeSort(int[] a) {
		return mergeSort(a, 0, a.length-1);
	}

	public static int[] mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right)/2;
			a = mergeSort(a, left, mid);
			a = mergeSort(a, mid+1, right);
			a = merge(a, left, mid, right);
		}
		return a;
	}
	
	public static int[] merge(int[] a, int low, int mid, int high) {
		int temp[] = new int[high-low+1];
		int left = low, right = mid+1, count = 0;
		
		while(left <= mid && right <= high) {
			if (a[left] <= a[right])
				temp[count++] = a[left++];
			else
				temp[count++] = a[right++];
		}
		
		while(left <= mid)
			temp[count++] = a[left++];
		while(right <= high)
			temp[count++] = a[right++];
		
		for (int k = 0; k < temp.length; k++)
			a[low+k] = temp[k];
		
		return a;
	}
	
	public static int[] quickSort(int[] a) {
		return quickSort(a, 0, a.length-1);
	}
	
	public static int[] quickSort(int[] a , int low, int high) {
		if (low < high) {
			int pivot = partition(a, low, high);
			a = quickSort(a, low, pivot-1);
			a = quickSort(a, pivot+1, high);
		}
		return a;
	}
	
	public static int partition(int[] a, int low, int high) {
		int pivotValue = a[low];
		int pivotPosition = low;
		
		for (int i = low+1; i <= high; i++) {
			if (a[i] < pivotValue) {
				pivotPosition++;
				swap(a, i, pivotPosition);
			}
		}
		swap(a, low, pivotPosition);
		return pivotPosition;
	}
	
}