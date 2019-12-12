import java.util.Scanner;

public class SSTF { // Omar
	
	
      
	 public static void main(String [] args){
		 
		 
		 Scanner kb  = new Scanner(System.in);
	     int head;
	     int [] requests = new int[1000];
	     
	        
	        
	     System.out.println("SSTF Disk Scheduling");
	     System.out.println();

	        
	     for (int i=0; i< requests.length;i++){
	          requests[i] = (int)(Math.random()*5000);
	        }

	     System.out.println("Enter Starting Head Position");
	     head = kb.nextInt();
	        
	        
	     int result = sstf(requests,head);
	     System.out.println("Total Amount of Head Movement: "+ result);

	     
	 
	
	 }
	 
	 
	public static int sstf(int requests[],int initialhead ) {
		
		 
		int [] tempArr;
	        tempArr = new int[1000];
	        
	    int head = initialhead;
	    int headMovement = 0;
	    int temp;
	        
	    for (int i=0; i<requests.length; i++) {
	    	tempArr[i] = Math.abs(head-requests[i]);
	        }
	   
	       
	    for (int i=0; i<requests.length; i++){
	    	
	        for (int j=i+1; j<requests.length; j++){
	        	if(tempArr[i] >tempArr[j]){
	        	    temp = tempArr[i];
	                tempArr[i] = tempArr[j];
	                tempArr[j] = temp;

	                temp = requests[i];
	                requests[i] = requests[j];
	                requests[j] = temp;
	               }

	           }
	       }

	        for (int i=1; i<requests.length; i++){
	            headMovement = headMovement + Math.abs(head-requests[i]);
	            head = requests[i];
	        }

	        return headMovement;

	    }
} 

	
	
	
	
	
