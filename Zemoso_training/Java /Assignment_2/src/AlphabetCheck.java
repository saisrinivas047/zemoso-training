import java.util.Scanner;

public class AlphabetCheck
{
    /**
     * This method checks if the string contains all the alphabets or not using Regular Expression
     * @param string the Input string
     */

    //Time Complexity will be O(n), n is the length of the string
    //Space Compexity will also be O(n)
    public boolean checks(String string)
    {
        string = string.replaceAll("[^a-zA-Z]", ""); // replace everything that is not between A-Za-z
        string = string.toLowerCase();
        string = string.replaceAll("(.)(?=.*\\1)", ""); // replace duplicate characters.
        System.out.println("The length of the string is " + string.length() + " \n");

        if(string.length() != 26){
            System.out.println("The String does not contain all the alphabets");
            return false;
            }
        else
            System.out.println("The String contains all the alphabets");
            return true;

    }

    public static void main(String args[])
    {
        AlphabetCheck alphabetCheck = new AlphabetCheck();
        System.out.println("Enter the String");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        alphabetCheck.checks(str);
    }
}
