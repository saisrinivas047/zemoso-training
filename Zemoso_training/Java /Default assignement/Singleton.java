package yourname.assignment.singleton;

public class Singleton {
    String S;

    static Singleton getObj(String str)
    {
        Singleton singletonObj = new Singleton(); //We get an error here that the non-static field 'S' cannot be used here in Static field
        singletonObj.S = str;                       //So we create an object so initialize the string
        return singletonObj;
    }

    public void print_string()
    {
        System.out.println("The string is : " + S);
    }

}
