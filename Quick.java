import java.util.*;
public class Quick{
    /*return the value that is the kth smallest value of the array.
 */
 public static void main(String[] args) {
     int[] test = new int[] {1,0,5,7,3};
     System.out.println(partition(test,2,4));
     for(int i : test){
         System.out.print(i);
     }
     System.out.println();
     test = new int[] {1,0,5,7,9,8,3,6};
     quicksort(test,0,test.length-1);
     for(int i : test){
         System.out.print(i);
     }
     System.out.println();
     test = new int[] {1,0,5,7,9,8,3,6};
     System.out.println(quickselect(test,4));
 }
 public static int quickselect(int []data, int k){
     int test = partition(data,0,data.length-1);
     if(test > k){
         quickselect(Arrays.copyOfRange(data,0,test),k);
     }else if(test < k){
         quickselect(Arrays.copyOfRange(data,test+1,data.length),k-(test+1));
     }
     return data[test];
 }

 /*@return the index of the final position of the pivot element.
 */
 public static int partition (int [] data, int start, int end){
     Random rand = new Random();
     int index = rand.nextInt(end-start+1)+start;
     //pivot swap
     int hold = data[start];
     data[start] = data[index];
     data[index] = hold;
     int pivot = start;
     start++;
      //start comparing and swapping;
     while(start <= end){
         if(data[start] > data[pivot]){
             hold = data[start];
             data[start] = data[end];
             data[end] = hold;
             end--;
         } else if(data[start] < data[pivot]){
             hold = data[start];
             data[start] = data[pivot];
             data[pivot] = hold;
             pivot = start;
             start++;
         }
     }
     return pivot;
 }
 /*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data, int lo, int hi){
     if (lo >= hi){
         return;
     }
     int pivot = partition(data,lo,hi);
     quicksort(data, lo, pivot-1);
     quicksort(data, pivot+1, hi);
 }
}
