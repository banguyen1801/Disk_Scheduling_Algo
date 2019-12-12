import java.util.*;
import java.io.*;

public class ScanAlgorithm
{
    
    public static void main(String[] args)
    {
       int floor = 0;
       int cieling = 4999;
       int start = 0;
       int[] Cylinders = new int[1000];
       int[] randomNum = new int[5000];
       Random rand = new Random();
	
     /**
	 * creat an array or random numbers 0-5000
	 */
         
         for(int i = 0;i<5000;i++)
        {
           randomNum[i] = i;
        }
        for (int i = 0; i < randomNum.length; i++) {
			int randomIndexToSwap = rand.nextInt(randomNum.length);
			int temp = randomNum[randomIndexToSwap];
			randomNum[randomIndexToSwap] = randomNum[i];
			randomNum[i] = temp;
        }
        /**
           * fill cylinder array
        */
       
       for(int i=0;i<1000;i++)
       {
           Cylinders[i] = randomNum[i];
                  
       }
       
       /**
        * create variable for first cylinder to be serviced
        */
       start = Cylinders[0];
      
       /**
       * sort cylinder array
       */
        
        int temp;
       for (int i = 1; i < Cylinders.length; i++)
       {
       for (int j = i; j > 0; j--) 
       {
       if (Cylinders[j] < Cylinders [j - 1])
       {
       temp = Cylinders[j];
       Cylinders[j] = Cylinders[j - 1];
       Cylinders[j - 1] = temp;
       }
        
      }
   
    }
 
        /**
         * find the array position of start variable
         */
        
       int startPosition = 0;
       for(int i=0;i<1000;i++)
       {
           if(Cylinders[i]== start)
           {
               startPosition=i;
               
            }
           
        }
    
    /**
     * calculate Total Head Movement
     */
    
    int totalHeadMovement = 0;
    
    if((Cylinders[startPosition]-Cylinders[0])<=(Cylinders[999]-Cylinders[startPosition]))
    {
        totalHeadMovement = (Cylinders[startPosition]-Cylinders[0])+ (Cylinders[999]-Cylinders[0]);
        
        
    } else{
        totalHeadMovement = (Cylinders[999]-Cylinders[startPosition])+(Cylinders[999]-Cylinders[0]);
        
        
        
    }
    
    
    
    System.out.println(totalHeadMovement);

}
}