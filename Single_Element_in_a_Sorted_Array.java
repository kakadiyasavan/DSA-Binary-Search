// leetCode 540 Single Element in a Sorted Array
// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
// Return the single element that appears only once.
// Your solution must run in O(log n) time and O(1) space.

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: nums = [3,3,7,7,10,11,11]
// Output: 10

import java.util.*;

public class Single_Element_in_a_Sorted_Array {

     public static void Find_Single(int[] nums){

          int start = 0;
          int end = nums.length - 1;

          while (start<end) {
               
               int mid = start+(end-start)/2;

               if(mid % 2 == 1){
                    mid--;
               }

               if(nums[mid] == nums[mid+1]){
                    start = mid + 2;
               } else {
                    end = mid;
               } 
          }
          System.out.println("Single Element is : " + nums[start]);
     }
     
     public static void main(String[] args){

          Scanner sc = new Scanner(System.in);

          System.out.println("Enter Array size : ");
          int size = sc.nextInt();
          sc.nextLine();

          int[] nums = new int[size];

          System.out.println("Enter Element in Array : ");
          for(int i=0 ; i<size ; i++){
               nums[i] = sc.nextInt();
          }

          Find_Single(nums);
     }
}
