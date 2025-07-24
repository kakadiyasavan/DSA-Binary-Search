// leetCode 852 Peak Index in a Mountain Array
// You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
// Return the index of the peak element.
// Your task is to solve it in O(log(n)) time complexity.

// Example 1:

// Input: arr = [0,1,0]
// Output: 1

// Example 2:

// Input: arr = [0,2,1,0]
// Output: 1

// Example 3:

// Input: arr = [0,10,5,2]
// Output: 1

import java.util.*;

public class Peak_Index_in_a_Mountain_Array {

     public static void Peak_Mountain(int[] nums) {

          int start = 1, end = nums.length - 2;

          while (start <= end) {

               int mid = start + (end - start) / 2;

               if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                    System.out.println("Peak Mountain Element Index is : " + mid);
                    return;
               }

               if (nums[mid - 1] < nums[mid]) {
                    start = mid + 1;
               } else {
                    end = mid - 1;
               }
          }
     }

     public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);

          System.out.println("Enter Array Size : ");
          int size = sc.nextInt();
          sc.nextLine();

          int[] nums = new int[size];

          System.out.println("Enter Mountain Number : ");
          for (int i = 0; i < size; i++) {
               nums[i] = sc.nextInt();
          }

          Peak_Mountain(nums);
     }
}
