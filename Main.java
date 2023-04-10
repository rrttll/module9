
//Importing the required packages
import java.util.Random;
public class Main {
public static void main(String[] args){
	// Creating a Random object
	Random rand = new Random();
    // Initializing an array with 200 million integers
	int[] arr = new int[200000000];
    // Filling the array with random integers between 1 and 10 (inclusive)
	for (int i = 0; i < arr.length; i++) {
		arr[i] = rand.nextInt(10) + 1;
	}
    // Recording the start time for single-threaded sum
	long start = System.currentTimeMillis();
    // Calculating the single-threaded sum
	System.out.println("Single sum: " + (Concurrency_v.sum(arr)));
    // Calculating and printing the time taken for single-threaded sum
	System.out.println("Single time in milliseconds: " + (System.currentTimeMillis() - start)+'\n');
    // Recording the start time for parallel sum
	start = System.currentTimeMillis();
    // Calculating the parallel sum
	System.out.println("Parallel sum: " + (Concurrency_v.parallelSum(arr)));
    // Calculating and printing the time taken for parallel sum
	System.out.println("Parallel time in milliseconds: " + (System.currentTimeMillis() - start));
	}
}
