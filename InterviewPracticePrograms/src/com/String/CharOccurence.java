package com.String;

public class CharOccurence 
{
    /* "Enhanced for loop Method" that return count of the given ....!!!!
	  											 4 Ways 1.Enhanced for loop
     													2.Ordinary for loop 
													    3.Recursion 
														4.length() concept   */
    public static int count(String s, char c)
    {
        int res = 0;
 
        for (int i=0; i<s.length(); i++)
        {
            // checking character in string
            if (s.charAt(i) == c)
            res++;
        } 
        return res;
    }
     
    // Driver method
    public static void main(String args[])
    {
        String str= "fellow";
        char c = 'l';
        System.out.println(count(str, c));
    }
}