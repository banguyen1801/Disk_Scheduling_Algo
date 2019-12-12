import java.util.Random;

public class DiskScheduling {

	public static void main(String[] args) {
		int start = 53;
		int requests [] = new int[999];

		requests = createRequests();
		
		System.out.println("Total Disk Movement: "  + FirstComeFirstServe(start, requests));
	}

	public static int FirstComeFirstServe(int start, int queue []) {
		int total = Math.abs(start - queue[0]);
	
		for(int i = 0; i < queue.length-1; i++) {
			
			total += (Math.abs(queue[i] - queue[i+1]));
			
		}
		return total;
		
	}
	
	public static int randomValue() {
		Random rand = new Random();
		int num = rand.nextInt(5000);
		return num;
	}
	
	public static int[] createRequests() {
		int [] request = new int [999];
		for (int i = 0; i < request.length; i++) {
			request[i] = randomValue();
			// System.out.println(request[i]);
		}
		return request;
	}
}
