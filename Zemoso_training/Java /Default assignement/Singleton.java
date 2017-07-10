package yourname.assignment.singleton;

public class Singleton {
    String S;

    static Singleton getObj(String str)
    {
        Singleton singletonObj = new Singleton();
        singletonObj.S = str;
        return singletonObj;
    }

    public void print_string()
    {
        System.out.println("The string is : " + S);
    }

}
