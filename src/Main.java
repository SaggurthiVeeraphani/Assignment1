import java.util.*;
import java.io.*;

public class Main {
    /*There are N mountains in linear order where you are given an array of height of length L and height[i] denotes the height of the mountain
     at ith position and you are also given an integer value k i.e the number of mountains to climb .
    You can climb mountains in any order. Each mountain you climb has points associated with it which is calculated using below formula:
    points = | height[previousMountainIndex] - height[currentMountainIndex] |  */
     public static void main(String[] args) {
         //Take input
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int [] arr = new int[n];
         for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
         }
         int k = sc.nextInt();
         int ans = solve(arr,n,k);
         System.out.println(ans);
     }
     public static int solve(int []arr,int n,int k){
         if(k > n) return -1;//edge case
         int ans = 0;
         // 2 <= k <= height.length <= 100000
         // 1 <= height[i] <= 1000000000
         Arrays.sort(arr); // sort the given Array
         int start = 1;
         int end = arr[n-1] - arr[0];

         while(start <= end){

             int mid = (start+end)/2;
             //check whether mid is the minimum of maximum distances
             if(check(arr,n,k,mid)){
                 ans = mid;
                 start = mid+1;
             }
             else{
                 end = mid-1;
             }

         }
         return ans;
     }
     public static boolean check(int [] arr,int n, int k, int mid){

         int prevInd = 0;
         int count = 1;

         for(int i=0;i<n;i++){

             if(arr[i] - arr[prevInd] >= mid){
                 count++;
                 prevInd = i;

             }
             else{
                 continue;
             }
         }
         return count>=k;//return true or false

     }
}