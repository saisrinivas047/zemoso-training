package yourname.assignment.data;

import java.util.Scanner;

public class Data {
    int a;
    char c;

    public void print()
    {
        System.out.println("The Variable is : " + a);
        System.out.println("The character is :" + c);
    }

   
    /*public void print_local()
    {
        int x, y;
        System.out.println("The Variable is :" + x);
        System.out.println("The Variable is :" + y);
    }*/ //This part will not run because the variables are not initialized locally to resolve this problem the variable should be initialized globally
}
