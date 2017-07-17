import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regular_exp
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String pattern = "^\\p{Upper}.*\\.$";
        Pattern p = Pattern.compile(pattern);

        System.out.println("Enter the text :");
        Matcher matcher = p.matcher(sc.nextLine());

        System.out.println(" Result : " +matcher.find());

    }
}
