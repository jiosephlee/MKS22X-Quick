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
     test = new int[] {1,0,5,7,7,8,6,7,8,8,8,9,8,3,6};
     quicksort(test,0,test.length-1);
     for(int i : test){
         System.out.print(i);
     }
     System.out.println();
     test = new int[] {1,0,5,7,9,8,3,6};
     System.out.println(quickselect(test,4));
//added mrks driver
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
 public static int quickselect(int []data, int k){
     int min = 0;
     int max = data.length - 1;
     int pivot = partition(data,0,data.length-1);
     while(pivot != k){
         pivot = partition(data,min,max); //reset with new partition
         if(pivot < k){
             min = pivot; //narrow the array we're looking at using the bounds of partition
         }
         if(pivot > k){
             max = pivot;
         }
     }
     return data[pivot];
 }

 /*@return the index of the final position of the pivot element.
 */
 public static int partition (int [] data, int start, int end){ // this partition can't deal with duplicates
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
         if(data[start] > data[pivot]){ //if current value is greater than pivot, put it at the "end" and swap it with current
             hold = data[start];
             data[start] = data[end];
             data[end] = hold;
             end--;
         } else if(data[start] < data[pivot]){ // if current value is smaller than pivot, -
             hold = data[start];
             data[start] = data[pivot];
             data[pivot] = hold;
             pivot = start;
             start++;
         } else{ //if they're equal, randomly put on either side
             int random = rand.nextInt(2);
             if (random == 0){
                 hold = data[start];
                 data[start] = data[end];
                 data[end] = hold;
                 end--;
             } else{
                 hold = data[start];
                 data[start] = data[pivot];
                 data[pivot] = hold;
                 pivot = start;
                 start++;
             }
         }
     }
     return pivot;
 }
 private static int[] partitionDutch(int[] data, int current, int end){
     Random rand = new Random();
     int index = rand.nextInt(end-current+1)+current;
     //pivot swap
     int hold = data[current];
     data[current] = data[index];
     data[index] = hold;
     int pivotlo = current;
     int pivothi = current;
     current++;
      //start comparing and swapping;
     while(current <= end){
         //for(int i : data){
        //     System.out.print(i); }
         //System.out.println();
         if(data[current] > data[pivotlo]){ // when the current value is greater than the pivot, swap with the end
             hold = data[current];
             data[current] = data[end];
             data[end] = hold;
             end--;
         } else if(data[current] < data[pivotlo]){ //when the current value is less than the the pivot, swap with the low pivot
             hold = data[current];
             data[current] = data[pivotlo];
             data[pivotlo] = hold;
             pivothi = current;
             pivotlo++;
             current++;
         } else{
             current++;
             pivothi++;
         }
     }
     return new int[]{pivotlo,pivothi};
}
 /*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data){
     quicksort(data,0,data.length-1);
 }
 public static void quicksort(int[] data, int lo, int hi){
     if (lo >= hi){
         return;
     }
     int pivot[] = partitionDutch(data,lo,hi);
     quicksort(data, lo, pivot[0]-1);
     quicksort(data, pivot[1]+1, hi);
 }
}
