
class Concurrency_v extends Thread {
private int[] arr;
private int low, high, partial;
//Constructor to set the array and its range to be summed
public Concurrency_v(int[] arr, int low, int high){
	this.arr = arr;
	this.low = low;
	this.high = Math.min(high, arr.length);
	}
//Method to get the partial sum calculated by the thread
	public int getPartialSum(){
		return partial;
		}
	// The thread's run method that calculates the partial sum
	public void run(){
		partial = sum(arr, low, high);
		}
	// Method to calculate the sum of the entire array
	public static int sum(int[] arr){
		return sum(arr, 0, arr.length);
		}
	// Method to calculate the sum of a specific range in the array
	public static int sum(int[] arr, int low, int high){
		int total = 0;
		for (int i = low; i < high; i++) {
			total += arr[i];
		}

		return total;
		}
	// Method to calculate the parallel sum using the default number of threads
	public static int parallelSum(int[] arr){
		return parallelSum(arr, Runtime.getRuntime().availableProcessors());
		}
	// Method to calculate the parallel sum using the specified number of threads
	public static int parallelSum(int[] arr, int threads){
		int size = (int) Math.ceil(arr.length * 1.0 / threads);
	    // Creating and starting threads for calculating partial sums
		Concurrency_v[] sums = new Concurrency_v[threads];
		for (int i = 0; i < threads; i++) {
			sums[i] = new Concurrency_v(arr, i * size, (i + 1) * size);
			sums[i].start();
		}
	    // Waiting for all threads to finish
		try {
			for (Concurrency_v sum : sums) {
				sum.join();
			}
		} catch (InterruptedException e) { }
	    // Aggregating the partial sums
		int total = 0;
		for (Concurrency_v sum : sums) {
			total += sum.getPartialSum();
		}
		return total;
	}

}