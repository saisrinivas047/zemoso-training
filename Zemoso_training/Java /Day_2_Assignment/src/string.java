/**
 * Program to create array of object references
 */
public class string
{
    public string(String S)
    {
        System.out.println(S);
    }

    public static void main(String args[])
    {
        string a[] = new string[3];  /**Object array reference*/
        a[1]= new string("Srinivas");
    }
}