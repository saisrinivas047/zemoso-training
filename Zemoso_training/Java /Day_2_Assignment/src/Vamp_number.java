/**
 * This Program is to print the first 100 vampire numbers
 */

import java.util.*;

public class Vamp_number
{
    public static void main (String args[])
    {
        int i, j, P = 1, Product;
        int count = 0;      /**Declaring count for the while loop to print the 100 numbers*/
        ArrayList<Integer> arr = new ArrayList<Integer>(); /**Array list to store the vampire numbers*/

        while (count <= 100) /**While loop to print the vampire numbers*/
        {
            for (i = (int) Math.pow(10, P); i < (int) Math.pow(10, P + 1); i++) /**loop to input the numbers from 10 to 100 which will be increased for each loop(fang 1)*/
            {
                for (j = i; j < (int) Math.pow(10, P + 1); j++) /**loop to identify fang 2*/
                {
                    if (i % 10 == 0 && j % 10 == 0) continue; /**condition to discard all the numbers trailing with zeroes*/

                    String x = Integer.toString(i) + Integer.toString(j); /**conversion of integers to strings to combine both the fangs*/
                    Product = i * j;
                    String y = Integer.toString(Product);
                    char[] m = x.toCharArray(); char[] n = y.toCharArray();
                    Arrays.sort(m); Arrays.sort(n);

                    if (Arrays.equals(m,n))
                    {
                        if(!arr.contains(Product)) /**to eliminate the repeated ones.*/
                        {
                            arr.add(Product);
                        }
                    }
                }count++;

            }P++;
            }

        Collections.sort(arr);/**sorting the arraylist in order*/
        System.out.println("The First 100 Vampire numbers are : ");
        for(int k=0;k<100;k++)
            System.out.println(arr.get(k));
    }
}
