import java.util.*;
public class Quick{
    /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
 }

 /*@return the index of the final position of the pivot element.
 */
 public static int partition (int [] data, int start, int end){
     Random rand = new Random();
     int index = rand.nextInt(data.length);
     //pivot swap
     int hold = data[start];
     data[start] = data[index];
     data[index] = hold;
     int pivot = start;
     start++;
     //start comparing and swapping;
     for(int i = start; i < data.length; i++){
         if(data[i] > data[pivot]){
             hold = data[i];
             data[i] = data[end];
             data[end] = hold;
             i--;
         } else if(data[i] < data[pivot]){
             hold = data[i];
             data[i] = data[pivot];
             data[pivot] = hold;
             pivot = i;
         }
     }
 }
}
