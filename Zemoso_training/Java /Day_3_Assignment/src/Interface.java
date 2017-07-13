import java.util.*;
interface one
{
    void method1();
    void method2();
}

interface two
{
    void method3();
    void method4();
}

interface three
{
    void method5();
    void method6();
}

interface four extends one,two,three
{
    void method7();
}

class five  //concrete class
{
    public void method8()
    {

    }
}

public class Interface extends five implements four  /**Implementing from a interface and inherited from a concrete class*/
{
    public void method1(){System.out.println("I am method 1");}
    public void method2(){System.out.println("I am method 2");}
    public void method3(){System.out.println("I am method 3");}
    public void method4(){System.out.println("I am method 4");}
    public void method5(){System.out.println("I am method 5");}
    public void method6(){System.out.println("I am method 6");}
    public void method7(){System.out.println("I am method 7");}
}

class inter
{
    public static void method9(one a) {a.method1();a.method2();}
    public static void method10(two b) {b.method3();b.method4();}
    public static void method11(three c) {c.method5();c.method6();}
    public static void method12(four d) {d.method7();}

    public static void main(String args[])
    {
        Interface s = new Interface(); //calling the methods
        method9(s);
        method10(s);
        method11(s);
        method12(s);
    }

}