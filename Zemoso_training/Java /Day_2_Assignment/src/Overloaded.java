/**
 * Program to call a Parameterized constructor from a Default constructor
 */

public class Overloaded
{
    public Overloaded() /**Default Constructor*/
    {
        this(10);
    }

    public Overloaded(int x) /**Parameterized constructor*/
    {
        System.out.println(x);
    }

    public static void main(String args[]) /**main method*/
    {
            Overloaded a=new Overloaded();
    }
}
