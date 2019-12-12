import java.util.Arrays;
import java.util.Random;

public class DiskSchedulingAlgorithms {
	
	private int[] cylRequest;
	private int request;
	private int cylinder;
	private int base;
	private int limit;
	
	Random random = new Random();
	
	public DiskSchedulingAlgorithms(int r, int c, int b) {
		this.request = r;
		this.cylinder = c;
		this.base = b;
		
		this.limit = c + b;
		
		getRandomRequest(r);		
	}
	
	private void getRandomRequest(int n) {
		cylRequest = new int[n];
		for (int i =0; i < n; i ++) {
			cylRequest[i] = base + random.nextInt(cylinder);
		}
		
		
	}

	public int Scan(int head) {
		if(isInvalid(head)) {
			System.err.println("Invalid");
			return -1;
		}
		
		
		int[] list = new int[cylRequest.length + 2];
		System.arraycopy(cylRequest, 0, list, 0, cylRequest.length);
		
		list[list.length - 2] = 0;
		list[list.length -1] = head;
		Arrays.sort(list);
		
		int index = Arrays.binarySearch(list, head);
		int[] left = new int[index];
		
		for (int i = index -1; i > 0; i--) {
			left[index - i - 1] = list[i];
		}
		
		for (int i = 0; i < left.length; i++) {
			list[i] = left[i];
		}
		
		return distance(list, head);
	}
	
	

	private boolean isInvalid(int head) {
		if(head < 0 || head >= limit) {
			return true;
		}
		
		return false;
	}

	private int distance(int[] list, int head) {
		
		int headMovement = Math.abs(list[0] - head);
		for (int i = 1; i < list.length; i++) {
			headMovement += Math.abs(list[i] - list [i-1]);
		}	
		
		return headMovement;
	}

	

}