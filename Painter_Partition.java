// Painter's Partition
// There is fence which consists of 
//  wooden blocks with each block having a number written on it represented by an array 
// . The painter is also given two numbers 
//  and 
//  . He is given the task to paint the fence using at most 
//  colors. But there are certain conditions which the painter must follow while painting:

// He has to paint the fence in sequential manner from left to right i.e, first paint the first block then second block and so on without leaving any block not being painted. 
// He will also use colors in sequential manner i.e, first paint with 1st color,then with 2nd color and so on. Note that he can paint any number of blocks sequentially with a single color and a color once used cannot be reused.
// The sum of numbers written on blocks painted with same color must lie between 
//  and 
//  ( both inclusive ).
//     The painter wants to know in how many ways can he paint the fence.Since the answer can be large, find the answer modulo 
// .

// Input Format

// First line contains 3 space separated denoting the values of 
//  and 
// Next line contains 
//  space separated integers denoting the values of array 

import java.util.*;

public class Painter_Partition {

     public static boolean isPossible(int[] boards,int k,int max_time){

          int painters = 1;
          int total = 0;

          for(int board : boards){
               if(board > max_time) return false;
               total += board;

               if(total > max_time){
                    painters++;
                    total = board;
               }

               if(painters > k) return false;
          }
          return true;
     }

     public static int findMinTime(int[] boards,int k){

          int left = Arrays.stream(boards).max().getAsInt();
          int right = Arrays.stream(boards).sum();
          int result = right;

          while(left <= right){
               int mid = left+(right-left)/2;

               if(isPossible(boards, k, mid)){
                    result = mid;
                    right = mid - 1;
               } else {
                    left = mid + 1;
               }
          }
          return result;
     }
     
     public static void main(String[] args){
        
          Scanner sc = new Scanner(System.in);

          int n = sc.nextInt();
          int k = sc.nextInt();
          int[] boards = new int[n];

          for(int i=0 ; i<n ; i++){
               boards[i] = sc.nextInt();
          }

          System.out.println(findMinTime(boards,k));
     }
}
