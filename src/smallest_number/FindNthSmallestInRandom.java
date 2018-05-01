package smallest_number;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class FindNthSmallestInRandom {

	public static int findKthSmallestElement(int[] array, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int i = 0; i < array.length; i++) {
			priorityQueue.offer(array[i]);
		}
		System.out.println("Final priority-queue " + priorityQueue);
		int currentNo = 0;
		while (k > 0) {
			currentNo = (Integer) priorityQueue.poll();
			k--;
		}
		return currentNo;
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many numbers you want to add to the array : ");
		int total_num = scanner.nextInt();
		int[] num_array = new int[total_num];
		for (int i = 0; i < total_num; i++)
			num_array[i] = Math.abs(random.nextInt(10000));
		System.out.println("Random array : ");
		printArray(num_array);
		System.out.println("");
		System.out.println("Enter k : ");
		int k = scanner.nextInt();
		System.out.println("Smallest element for k = " + k + " : " + findKthSmallestElement(num_array, k));
	}

}
