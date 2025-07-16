// leetCode 33 Search in Rotated Sorted Array
// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:

// Input: nums = [1], target = 0
// Output: -1

import java.util.Scanner;

public class Search_in_Rotated_Sorted_Array {

     public static void Find_Target(int[] nums, int target, int start, int end) {

          if (start > end) {
               System.out.println("Target not found");
               return;
          }

          int mid = start + (end - start) / 2;

          if (nums[mid] == target) {
               System.out.println("Target found at index: " + mid);
               return;
          }

          if (nums[start] <= nums[mid]) {

               if (target >= nums[start] && target < nums[mid]) {
                    Find_Target(nums, target, start, mid - 1);
               } else {
                    Find_Target(nums, target, mid + 1, end);
               }
          } else {
               if (target > nums[mid] && target <= nums[end]) {
                    Find_Target(nums, target, mid + 1, end);
               } else {
                    Find_Target(nums, target, start, mid - 1);
               }
          }
     }

     public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);

          System.out.println("Enter Array Size : ");
          int size = sc.nextInt();
          sc.nextLine();

          int[] nums = new int[size];

          System.out.println("Enter Number of Element : ");
          for (int i = 0; i < size; i++) {
               nums[i] = sc.nextInt();
          }

          System.out.println("Enter Target Value : ");
          int target = sc.nextInt();
          sc.nextLine();

          Find_Target(nums, target, 0, size - 1);
     }
}