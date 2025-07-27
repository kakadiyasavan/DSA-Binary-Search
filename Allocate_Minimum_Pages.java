// Allocate Minimum Pages
// Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:
// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

// Examples:

// Input: arr[] = [12, 34, 67, 90], k = 2
// Output: 113
// Explanation: Allocation can be done in following ways:
//              => [12] and [34, 67, 90] Maximum Pages = 191
//              => [12, 34] and [67, 90] Maximum Pages = 157
//              => [12, 34, 67] and [90] Maximum Pages = 113.
//              Therefore, the minimum of these cases is 113, which is selected as the output.

import java.util.*;

public class Allocate_Minimum_Pages {

     public static boolean isPossible(int[] arr,int k,int maxPages){
          int students = 1;
          int currentPages = 0;

          for(int pages : arr){
               if(pages > maxPages) return false ;

               if(currentPages + pages > maxPages){
                    students++;
                    currentPages = pages;

                    if(students > k) return false;
               } else {
                    currentPages += pages;
               }
          }
          return true;
     }

     public static int findMinimumPages(int[] arr,int k){

          if(k> arr.length) return -1;

          int low = 0,high = 0;
          for(int pages : arr){
               low = Math.max(low,pages);
               high += pages;
          }

          int result = -1;

          while(low <= high){
               int mid = low + (high - low)/2;

               if(isPossible(arr, k, mid)){
                    result = mid;
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return result;
     }
     
     public static void main(String[] args){

          Scanner sc = new Scanner(System.in);

          System.out.println("Enter Number of Books : ");
          int n = sc.nextInt();
          int[] arr = new int[n];

          System.out.println("Enter pages in each book : ");
          for(int i=0 ; i<n ; i++){
               arr[i] = sc.nextInt();
          }

          System.out.println("Enter number of students : ");
          int k = sc.nextInt();

          int result = findMinimumPages(arr, k);
          System.out.println("Minimum Maximum Pages : " + result);
     }
}
