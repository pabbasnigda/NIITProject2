package com.arrayPrgms;

import java.util.Scanner;

public class LargestAndSmallest 
{
    public static void main(String args[]) 
    {
        int n, max, min, i;
        int[] inputArray = new int[50];
   
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements");
        n = in.nextInt();
        
        System.out.println("Enter " + n + " elements");
         
        for(i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }
   
        max = min = inputArray[0];
         
        for(i = 1; i < n; i++) {
            if(inputArray[i] > max)
                max = inputArray[i];
            else if (inputArray[i] < min)
                min = inputArray[i];
                
        }
        
        System.out.println("Largest Number : " + max);
        System.out.println("Smallest Number : " + min);
    }
}