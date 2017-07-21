import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regular_exp
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); //Scanner to input the matcher text
        String pattern = "^\\p{Upper}.*\\.$"; //pattern to check if the text starts with a capital letter and ends with a period.
        Pattern p = Pattern.compile(pattern); //compiling the pattern

        System.out.println("Enter the text :");
        Matcher matcher = p.matcher(sc.nextLine()); //inputing the text 

        System.out.println(" Result : " +matcher.find()); //checks the text and outputs true or false 

    }
}
