import java.util.*;
class Cycle
{

}
class Unicycle extends Cycle
{
    public void balance()
    {
        System.out.println("One wheel");
    }
}

class Bicycle extends Cycle
{
    public void balance()
    {
        System.out.println("Two wheels");
    }
}

class Tricycle extends Cycle
{

}

class Test{

    public static void main(String args[])
    {
        Unicycle U = new Unicycle();
        Bicycle B = new Bicycle();
        Tricycle T = new Tricycle();

        Cycle c[] = {U, B, T}; // Upcasting
        c[0].balance();// Error is because balance method is not present in the main Cycle class
        c[1].balance();
        c[2].balance();

        System.out.println("\n Downcasting: \n");
        U = (Unicycle)c[0];
        B = (Bicycle)c[1];
        T = (Tricycle)c[2];

        U.balance();
        B.balance();
        T.balance(); // Error is because the tricycle cast dont have a menthod called balance
    }
}


