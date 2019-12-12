import java.util.*;
class Main {
  static int FCFSAlgorithm(int[] arr, int head){
    int headmovement = 0;
    int curr;
    /*
    set the current to the first value of the array
    then as we calculate headmovement while looping linearly throught the array, we set the new head to the value we just passed through 
    */
    for(int i = 0; i < arr.length; i++){
      curr = arr[i];
      headmovement += Math.abs(curr - head);
      head = curr;
    }
    System.out.print("Total Head Movement: " +headmovement);

    return headmovement;
  }
  public static void main(String[] args) {
    int[] a = {1,2,3,4};
    int start = 5;
    FCFSAlgorithm(a, start);
  }
}