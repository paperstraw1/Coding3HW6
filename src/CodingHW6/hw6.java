package CodingHW6;

import java.util.Arrays;
public class hw6 {
	
	private static void swap(int[] arr, int i, int x) {
		int temp = arr[i];
		arr[i] = arr[x];
		arr[x] = temp;
	}
	
	
	//Loop for Bubble Sort
	private static int bubbleSort(int[] numbers) {
		int comp = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int x = 0; x < numbers.length - 1; x++) {
				if (numbers[x] > numbers[x+1]) {

					int temp = numbers[x];
					numbers[x] = numbers[x+1];
					numbers[x+1] = temp;
					
					comp++;
				}
			}
		}
		
		return comp;
		
	}
	
	
	
	//Loop for Selection Sort
	private static int selectionSort(int[] numbers) {
		int comp = 0;
		
		for (int i = 0; i < numbers.length - 1; i++) {
			int min = i;
			for (int x = i + 1; x < numbers.length; x++) {
				if (numbers[x] < numbers[min]) {
					min = x;
				}
			}
			
			int temp = numbers[i];
			numbers[i] = numbers[min];
			numbers[min] = temp;
			
			comp++;
		}
		
		return comp;
	}
	
	
	
	
	//Loop for Insertion Sort
	private static int insertionSort(int[] numbers, int diff, int start) {
		int comp = 0;
		
		for (int i = start + diff; i < numbers.length; i = i + diff) {	

			for (int x = i; x - diff >= 0; x = x - diff) {
				
				if (numbers[x] < numbers[x-diff]) {
					swap(numbers, x, x-diff);
					comp++;
				} else {
					break;
				}
			}
		}
		
		return comp;
		
	}
	
	
	
	
	//Loop for Shell Sort
	private static int shellSort(int[] numbers) {
		
		int comp = 0;
		
		for (int diff = numbers.length / 2; diff >= 1; diff = diff / 2) {
			
			for (int i = 0; i < diff; i++) {
				comp = comp + insertionSort(numbers, diff, i);
			}	
		}
		
		return comp;
	}
	
	//main
	public static void main(String[] args) {
	      
		int[] numbers = {34, 64, 12, 27, 15, 75, 99, 44, 23, 32};
		int[] n2 = numbers.clone();
		int[] n3 = numbers.clone();
		int[] n4 = numbers.clone();
		
	    System.out.println("Not Sorted: " + Arrays.toString(numbers));
	      
	    int swap = bubbleSort(numbers);
	    int swap2 = selectionSort(n2);
	    int swap3 = insertionSort(n3,1,0);
	    int swap4 = shellSort(n4);
	      
	    System.out.println("Sorted with bubble sort: " + Arrays.toString(numbers));
	    System.out.println("Sorted with selection sort: " + Arrays.toString(n2));
	    System.out.println("Sorted with insertion sort: " + Arrays.toString(n3));
	    System.out.println("Sorted with shell sort: " + Arrays.toString(n4));
	    
	    System.out.println("Amount of Numbers: " + numbers.length);
	    System.out.println("Times swapped for bubble sort: " + swap);
		System.out.println("Times swapped for selection sort: " + swap2);
		System.out.println("Times swapped for insertion sort: " + swap3);
		System.out.println("Times swapped for shell sort: " + swap4);
	}
	
}